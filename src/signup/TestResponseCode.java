package signup;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestResponseCode
{
  public static void main(String[] args)
  {
    // simple page (without many resources so that the output is
    // easy to understand
    String url = "https://www.phptravels.net/register";

    DownloadPage(url);
  }

  private static void DownloadPage(String url)
  {
	  WebDriver driver = null;

    try
    {
		System.setProperty("webdriver.chrome.driver",".\\driver\\chromedriver.exe" );

      ChromeOptions options = new ChromeOptions();
      // add whatever extensions you need
      // for example I needed one of adding proxy, and one for blocking
      // images
      // options.addExtensions(new File(file, "proxy.zip"));
      // options.addExtensions(new File("extensions",
      // "Block-image_v1.1.crx"));

    //  DesiredCapabilities cap = new DesiredCapabilities("chrome", "", Platform.ANY);
      DesiredCapabilities cap = DesiredCapabilities.chrome();

      cap.setCapability(ChromeOptions.CAPABILITY, options);
      System.out.println("\nList of log entries:11\n");

      // set performance logger
      // this sends Network.enable to chromedriver
      LoggingPreferences logPrefs = new LoggingPreferences();
      logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
      cap.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
      System.out.println("\nList of log entries1:\n");
      System.out.println("Navigate to " + url);

      driver = new ChromeDriver();
		
		driver.get("https://www.phptravels.net/register");

      // navigate to the page
      System.out.println("Navigate to " + url);
      driver.navigate().to(url);

      // and capture the last recorded url (it may be a redirect, or the
      // original url)
      String currentURL = driver.getCurrentUrl();
      System.out.println("Navigate to " + currentURL);

      // then ask for all the performance logs from this request
      // one of them will contain the Network.responseReceived method
      // and we shall find the "last recorded url" response
      System.out.println(driver.manage().logs().getAvailableLogTypes());

      //LogEntries logs = driver.manage().logs().get("Performance");
      List<LogEntry> logs = driver.manage().logs().get(LogType.PERFORMANCE).getAll();
      System.out.println(logs.size() + " " + LogType.PERFORMANCE + " log entries found");

      System.out.println("Navigate to 1111" + logs);

      int status = -1;

      System.out.println("\nList of log entries:\n");

      for (Iterator<LogEntry> it = logs.iterator(); it.hasNext();)
      {
        LogEntry entry = it.next();

        try
        {
          JSONObject json = new JSONObject(entry.getMessage());

          System.out.println(json.toString());

          JSONObject message = json.getJSONObject("message");
          String method = message.getString("method");

          if (method != null
              && "Network.responseReceived".equals(method))
          {
            JSONObject params = message.getJSONObject("params");

            JSONObject response = params.getJSONObject("response");
            String messageUrl = response.getString("url");

            if (currentURL.equals(messageUrl))
            {
              status = response.getInt("status");

              System.out.println(
                  "---------- bingo !!!!!!!!!!!!!! returned response for "
                      + messageUrl + ": " + status);

              System.out.println(
                  "---------- bingo !!!!!!!!!!!!!! headers: "
                      + response.get("headers"));
            }
          }
        }
        catch (JSONException e)
        {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }

      System.out.println("\nstatus code: " + status);
    }
    finally
    {
//      if (driver != null)
//      {
//        driver.quit();
//      }
//
//      System.exit(0);
    }
  }
}
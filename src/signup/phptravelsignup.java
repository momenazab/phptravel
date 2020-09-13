package signup;


import java.util.Iterator;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


public class phptravelsignup {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//SET CHROME DRIVER PROPERTY FOR CHROME BROWSER
				System.setProperty("webdriver.chrome.driver",".\\driver\\chromedriver.exe" );
				
				//INVOKE CHROME DRIVER  
				
				WebDriver driver = new ChromeDriver();
				
				driver.get("https://www.phptravels.net/register");
				
				
				//MAXIMIZE WEB PAGE
				
				driver.manage().window().maximize();
				
				
				//ENTER FIRSTNAME ON INPUT FIELD
				
				
				WebElement firstname =driver.findElement(By.name("firstname"));
				
				firstname.sendKeys("Momen");
				
				String firstnameStr=firstname.getAttribute("value");
				
				
				
				Character.isUpperCase(firstnameStr.charAt(0));

				if (Character.isUpperCase(firstnameStr.charAt(0))) {
					
					System.out.println("Valid  first name");
					
				}
				else {
					
					System.out.println("Unvalid first name");
				}
				
				//ENTER LASTNAME ON INPUT FIELD 
				
				
				WebElement lastname=driver.findElement(By.name("lastname"));
				
				lastname.sendKeys("Azab");	
				
				String lastnameStr=lastname.getAttribute("value");
				
				Character.isUpperCase(lastnameStr.charAt(0));

				if (Character.isUpperCase(lastnameStr.charAt(0))) {
					System.out.println("Valid last name");
					
				}
				else {
					System.out.println("Unvalid last name");
				}
				
				
				//ENTER MOBILE NUMBER ON INPUT FIELD
				
				WebElement mobile =driver.findElement(By.name("phone"));
				
				mobile.sendKeys("01111819172");
				
				String mobileStr =mobile.getAttribute("value");
				
				String validation ="^[0-9]{11}$";
				
				Pattern p1= Pattern.compile(validation);
				
				Matcher m1 =p1.matcher(mobileStr);
				
				if (m1.matches()) {
				System.out.println("Valid mobile number ");
							
						}
						else {
						System.out.println("Unvaid");
						}
				
				//ENTER YOUR EMAIL ON INPUT FIELD 
				
				WebElement email=driver.findElement(By.name("email"));
				
				email.sendKeys("momenazab2494@gmail.com");
				
				String emailStr=email.getAttribute("value");
				
				String emailCheck="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
				
				Pattern p2 =Pattern.compile(emailCheck);
				
				Matcher m2=p2.matcher(emailStr);
				
				if(m2.matches()) {
					System.out.println("Valid email");
					
				}
				
				else {
					System.out.println("Unvalid email");
				
				}
				
				
				//ENTER PASSWORD ON INPUT FIELD
				
				WebElement passowrd= driver.findElement(By.name("password"));
				
				passowrd.sendKeys("Abc123499");
				
				String passwordStr=passowrd.getAttribute("value");
				 
				System.out.println("Entered value "+passwordStr);
				 
				String pws = "^(?=.*[0-9])"+ "(?=.*[a-z])(?=.*[A-Z])"+ "(?=\\S+$).{8,20}$"; 
				
				Pattern p = Pattern.compile(pws);
				
				Matcher m= p.matcher(passwordStr);
				
				System.out.println(m.matches());

				
				
				 //ENTER CONFIRM PASSWORD ON INPUT 
			
				 WebElement confirmPassword=driver.findElement(By.name("confirmpassword"));
			
				 confirmPassword.sendKeys("Abc123499");
			
				 String confirmPasswordStr=confirmPassword.getAttribute("value");
			
				 System.out.println("Entered value "+confirmPasswordStr);
			 
			 
				 if (passwordStr.equals(confirmPasswordStr)) {
					 	System.out.println("True");
				 
				 }
				 else {
					 	System.out.println("False");
				 }
			
			
				 //SUBMIT THE FORM BY CLICKING SIGN UP


				 driver.findElement (By.xpath("//*[@id=\'headersignupform\']/div[8]/button/i")).submit();
				 
				 //Test Response code 
				 
				 String url = "https://www.phptravels.net/register";

				    DownloadPage(url);
				  }

				  private static void DownloadPage(String url)
				  {
				    ChromeDriver driver = null;

				    try
				    {
				      ChromeOptions options = new ChromeOptions();
				     

				      DesiredCapabilities cap = new DesiredCapabilities("chrome", "", Platform.ANY);
				      cap.setCapability(ChromeOptions.CAPABILITY, options);

				    
				      LoggingPreferences logPrefs = new LoggingPreferences();
				      logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
				      cap.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);

				      driver = new ChromeDriver(cap);

				      // navigate to the page
				      System.out.println("Navigate to " + url);
				      driver.navigate().to(url);

				      // and capture the last recorded url (it may be a redirect, or the
				      // original url)
				      String currentURL = driver.getCurrentUrl();

				      // then ask for all the performance logs from this request
				      // one of them will contain the Network.responseReceived method
				      // and we shall find the "last recorded url" response
				      LogEntries logs = driver.manage().logs().get("performance");

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
				      if (driver != null)
				      {
				        driver.quit();
				      }

				      System.exit(0);
				    }
				  }
				
			
	       
	       
	       

	}



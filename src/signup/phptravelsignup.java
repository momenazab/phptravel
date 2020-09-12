package signup;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


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
				String Firstname="momen";
				driver.findElement(By.name("firstname")).sendKeys(Firstname.substring(0,1).toUpperCase() + Firstname.substring(1).toLowerCase());	
				
				
				//ENTER LASTNAME ON INPUT FIELD 
				String Lastname="azab";
				driver.findElement(By.name("lastname")).sendKeys(Lastname.substring(0,1).toUpperCase() + Lastname.substring(1).toLowerCase());	
				
				//ENTER MOBILE NUMBER ON INPUT FIELD
				driver.findElement(By.name("phone")).sendKeys("01111819172");
				
				
				
				
				//ENTER YOUR EMAIL ON INPUT FIELD 
				driver.findElement(By.name("email")).sendKeys("momenazab2494@gmail.com");
				
				//ENTER PASSWORD ON INPUT FIELD
				 driver.findElement(By.name("passowrd"));
				 String password="Abc@1234";
				 String pattern  = ("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$\r\n" + 
						"");
				 System.out.println(password.matches(pattern));
				
				
				//ENTER CONFIRM PASSWORD ON INPUT 
				driver.findElement(By.name("confirmpassword")).sendKeys("Abc@1234");
				
				//SUBMIT THE FORM BY CLICKING SIGN UP
		        driver.findElement (By.xpath("//*[@id=\'headersignupform\']/div[8]/button/i")).click();

	}

	
	

}

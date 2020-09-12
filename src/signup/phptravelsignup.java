package signup;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
				
				WebElement firstname =driver.findElement(By.name("firstname"));
				firstname.sendKeys("Momen");
				String firstnameStr=firstname.getAttribute("value");
				Character.isUpperCase(firstnameStr.charAt(0));

				if (Character.isUpperCase(firstnameStr.charAt(0))) {
					System.out.println("Valid captilize first letter");
					
				}
				else {
					System.out.println("Unvalid captilize first letter");
				}
				
				//ENTER LASTNAME ON INPUT FIELD 
				
				WebElement lastname=driver.findElement(By.name("lastname"));
				lastname.sendKeys("Azab");	
				String lastnameStr=lastname.getAttribute("value");
				Character.isUpperCase(lastnameStr.charAt(0));

				if (Character.isUpperCase(lastnameStr.charAt(0))) {
					System.out.println("Valid captilize last letter");
					
				}
				else {
					System.out.println("Unvalid captilize last letter");
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
				 
				 String pws = "^(?=.*[0-9])"
	                       + "(?=.*[a-z])(?=.*[A-Z])"
	                       + "(?=\\S+$).{8,20}$"; 
				Pattern p = Pattern.compile(pws);
				Matcher m= p.matcher(passwordStr);
				 System.out.println(m.matches());

				
				
				
				//ENTER CONFIRM PASSWORD ON INPUT 
			WebElement confirmPassword=	driver.findElement(By.name("confirmpassword"));
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
//				 Sign Up
		       driver.findElement (By.xpath("//*[@id=\'headersignupform\']/div[8]/button/i")).submit();
			



	}

	
	

}

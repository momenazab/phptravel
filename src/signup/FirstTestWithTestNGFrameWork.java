//package signup;
//
//import org.testng.annotations.Test;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.BeforeClass;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.AfterSuite;
//
//public class FirstTestWithTestNGFrameWork {
//	WebDriver driver;
//
//  @Test()
//  public void signUp() {
//
//		WebElement firstname =driver.findElement(By.name("firstname"));
//		firstname.sendKeys("Momen");
//		
//		WebElement lastname=driver.findElement(By.name("lastname"));
//		lastname.sendKeys("Azab");	
//		
//		WebElement mobile =driver.findElement(By.name("phone"));
//		mobile.sendKeys("01111819172");
//		
//		WebElement email=driver.findElement(By.name("email"));
//		email.sendKeys("momenazab2494@gmail.com");
//		
//		 WebElement passowrd= driver.findElement(By.name("password"));
//		 passowrd.sendKeys("Abc123499");
//		 
//		 WebElement confirmPassword=	driver.findElement(By.name("confirmpassword"));
//		confirmPassword.sendKeys("Abc123499");
//		
//	       driver.findElement (By.xpath("//*[@id=\'headersignupform\']/div[8]/button/i")).submit();
//
//  } 
//  @BeforeMethod
//  public void beforeMethod() {
//		driver.get("https://www.phptravels.net/register");
//
//	  
//  }
//
//  @AfterMethod
//  public void afterMethod() {
//	  System.out.println(driver.getCurrentUrl());
//
//  }
//
//
//
//  @BeforeClass
//  public void beforeClass() {
//	  System.setProperty("webdriver.chrome.driver",".\\driver\\chromedriver.exe" );
//		
//		//INVOKE CHROME DRIVER  
//		driver = new ChromeDriver();
//		
//		//MAXIMIZE WEB PAGE
//		driver.manage().window().maximize();
//  }
//
//  @AfterClass
//  public void afterClass() {
//	  driver.quit();
//
//  }
//
//
//
//}

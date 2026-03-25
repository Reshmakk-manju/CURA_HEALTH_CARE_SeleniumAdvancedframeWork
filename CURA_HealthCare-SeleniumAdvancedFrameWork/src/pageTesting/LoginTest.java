package pageTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjectModel.DashBoardpage;
import pageObjectModel.LoginPage;

public class LoginTest {
	
	WebDriver driver;
	DashBoardpage dp;
	LoginPage lp;
	
  @BeforeTest
  public void beforeTest() {
	  driver=new ChromeDriver();
	  driver.get("https://katalon-demo-cura.herokuapp.com/");
	  dp=new DashBoardpage(driver);
	  lp=new LoginPage(driver);
	  
  }
  
  @Parameters({"user","password"})
  @Test
  public void testLogin(String username,String password) {
	  //click to make appointment
	  dp.clickMakeAppointment();
	  //login with credentials
	  lp.UserName(username);
	  lp.Password(password);
	  lp.Login();
	  String expectedUrl="https://katalon-demo-cura.herokuapp.com/#appointment";
	  String actualUrl=driver.getCurrentUrl();
	  SoftAssert soft=new SoftAssert();
	  soft.assertEquals(actualUrl, expectedUrl, "Login should succeed only for valid credentials");
	  soft.assertAll();
	  
  }
  @AfterMethod
  public void reset() {
      driver.get("https://katalon-demo-cura.herokuapp.com/");
  }
  @AfterTest
  public void afterTest() {
	  driver.quit();
	  
  }
  
}

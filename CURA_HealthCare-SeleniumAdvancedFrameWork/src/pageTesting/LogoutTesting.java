package pageTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjectModel.DashBoardpage;
import pageObjectModel.LoginPage;

public class LogoutTesting {
	WebDriver driver;
	DashBoardpage dp;
	LoginPage lp;
	
  @Test
  public void testLogout() {
	  dp.clickMakeAppointment();
	  lp.UserName("John Doe");
	  lp.Password("ThisIsNotAPassword");
	  lp.Login();
	  driver.findElement(By.id("menu-toggle")).click();
	  driver.findElement(By.linkText("Logout")).click();
	  String expectedURL = "https://katalon-demo-cura.herokuapp.com/";
	  String actualURL = driver.getCurrentUrl();

	  Assert.assertEquals(actualURL, expectedURL, 
	        "Logout failed - URL mismatch, user not redirected to login page");
  }
  @BeforeTest
  public void beforeTest() {
	  driver=new ChromeDriver();
	  driver.get("https://katalon-demo-cura.herokuapp.com/");
	  driver.manage().window().maximize();
	  dp=new DashBoardpage(driver);
	  lp=new LoginPage(driver);
  }
  @AfterTest
  public void afterTest() {
	  driver.quit();
	  
  }
}

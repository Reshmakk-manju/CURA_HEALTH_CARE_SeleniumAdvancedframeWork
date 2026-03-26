package pageTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjectModel.DashBoardpage;
import pageObjectModel.LoginPage;

public class AppoinmentPage {
	WebDriver driver;
	//initialize page objects
	DashBoardpage dp;
	LoginPage lp;
  @Test
  public void appoinmentTest() {
	  //click to make appointment from dashboard page
	  dp.clickMakeAppointment();
	  //enter the login credentials
	  lp.UserName("John Doe");
	  lp.Password("ThisIsNotAPassword");
	  lp.Login();
	  //select drop down
	  WebElement y = driver.findElement(By.id("combo_facility"));
	  Select s=new Select(y);
	  s.selectByVisibleText("Hongkong CURA Healthcare Center");
	  //check box selection
	  WebElement checkbox=driver.findElement(By.xpath("//input[@name='hospital_readmission']"));
	  if(!checkbox.isSelected()) {
		  checkbox.click();
	  }
	  //radio button selection
	  driver.findElement(By.id("radio_program_medicare")).click();
	  
	  //date selection
	  //select calendar
	  driver.findElement(By.id("txt_visit_date")).click();
	  // Select Month & Year
	  while (true) {
	      String monthYear = driver.findElement(By.xpath("//th[@class='datepicker-switch']")).getText();

	      if (monthYear.equals("March 2026")) {
	          break;
	      } else {
	          driver.findElement(By.xpath("//th[@class='next']")).click();
	      }
	  }

	  // Select date
	  driver.findElement(By.xpath("//td[text()='26']")).click();
	  //enter the comment
	  driver.findElement(By.id("txt_comment")).sendKeys("Need an appoinment");
	  driver.findElement(By.id("btn-book-appointment")).click();
	  String expectedUrl="https://katalon-demo-cura.herokuapp.com/appointment.php#summary";
	  String actualUrl=driver.getCurrentUrl();
	  Assert.assertEquals(actualUrl, expectedUrl,"login failed");
	  System.out.println("appoinment maded");
	  
  }
  @BeforeTest
  public void beforeTest() {
	  driver=new ChromeDriver();
	  driver.get("https://katalon-demo-cura.herokuapp.com/");
	  driver.manage().window().maximize();
	  lp=new LoginPage(driver);
	  dp=new DashBoardpage(driver);
  }
  @AfterTest
  public void afterTest() {
	  driver.quit();
	  
  }
}

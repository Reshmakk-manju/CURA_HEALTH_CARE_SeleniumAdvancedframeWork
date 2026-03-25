package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DashBoardpage {
  WebDriver driver;
  By makeApt=By.id("btn-make-appointment");;
  public DashBoardpage(WebDriver driver) {
	  this.driver = driver;
  }
  public void clickMakeAppointment() {
	  driver.findElement(makeApt).click();
  }
}

package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DashBoardpage {
  WebDriver driver;
  By makeApt=By.xpath("//a[@id='btn-make-appointment']");
  public DashBoardpage(WebDriver driver) {
	  driver=new ChromeDriver();
  }
  public void clickMe(String m) {
	  driver.findElement(makeApt).click();
  }
}

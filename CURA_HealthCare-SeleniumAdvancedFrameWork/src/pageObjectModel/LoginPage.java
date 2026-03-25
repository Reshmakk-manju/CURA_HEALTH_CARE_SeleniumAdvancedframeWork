package pageObjectModel;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class LoginPage {
  public WebDriver driver;
  By uname = By.id("txt-username");
  By pwd = By.id("txt-password");
  By login = By.id("btn-login");
  By errorMsg = By.xpath("//p[@class='lead text-danger']");
 
  public LoginPage(WebDriver driver) {
	  this.driver=driver; 
  }
  public void UserName(String u) {
	  driver.findElement(uname).sendKeys(u);
  }
  public void Password(String p) {
	  driver.findElement(pwd).sendKeys(p);
  }
  public void Login() {
	  driver.findElement(login).click();
  }
 

  public String getErrorMessage() {
      return driver.findElement(errorMsg).getText();
  }
}

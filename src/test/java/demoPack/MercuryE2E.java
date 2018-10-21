package demoPack;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MercuryE2E 
{
	WebDriver driver;
	WebDriverWait wait;
	Select sel;
	@BeforeTest
	public void beforeTest()
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Testing\\Drivers\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("http://newtours.demoaut.com/");
	}

  @Test
  public void login() 
  {
	  driver.findElement(By.name("userName")).sendKeys("tutorial");
	  driver.findElement(By.name("password")).sendKeys("tutorial");
	  driver.findElement(By.name("login")).click();
  }
  @Test
  public void passngrDetails()
  {
	  sel= new Select(driver.findElement(By.name("passCount")));
	  sel.selectByIndex(1);
	  sel= new Select(driver.findElement(By.name("fromPort")));
	  sel.selectByVisibleText("Paris");
	  driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/font/font/input[1]")).click();
	  sel= new Select(driver.findElement(By.name("airline")));
	  sel.selectByVisibleText("Unified Airlines");
	  driver.findElement(By.name("findFlights")).click();
	  
  }
  @Test
  public void ticketBooking()
  {
	  List <WebElement> dept=driver.findElements(By.className("frame_action_xrows"));
	  dept.get(3).click();
	  dept.get(7).click();
	  driver.findElement(By.name("reserveFlights")).click();
	  
  }
  @Test
  public void zBookingfinalPage()
  {
	  driver.findElement(By.name("passFirst0")).sendKeys("Lekha");
	  driver.findElement(By.name("passLast0")).sendKeys("Nair");
	  driver.findElement(By.name("creditnumber")).sendKeys("123456");
	  List <WebElement>ticket=driver.findElements(By.name("ticketLess"));
	  ticket.get(0).click();
	  ticket.get(1).click();
	  driver.findElement(By.name("buyFlights")).click();
	  
  }
  /*@AfterTest
  public void afterTest()
  {
	  driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[7]/td/table/tbody/tr/td[3]/a/img")).click();
	  driver.close();
  }*/
}

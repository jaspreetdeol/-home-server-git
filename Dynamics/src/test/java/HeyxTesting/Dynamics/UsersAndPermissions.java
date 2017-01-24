package HeyxTesting.Dynamics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class UsersAndPermissions {
	
	WebDriver driver;
	
	@Test(priority =1)
	  public void authenticate() {
		  
		  //find elements here
		  WebElement user=driver.findElement(By.name("username"));
		  WebElement pass=driver.findElement(By.name("password"));
		  WebElement btn=driver.findElement(By.xpath("html/body/div[2]/form/div[4]/button"));
		
		  //action here
		  user.sendKeys("lyoung");
		  pass.sendKeys("1");
		  btn.click();
	 
	  }
	
	
	@Test(priority=2)
	public void groups()
	{
		//WebElement 
	}
  @BeforeTest
  public void start()
  {
	  driver=new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.get("http://52.54.76.113/dynamics");
  }


  @AfterTest
  public void afterTest() {
  }

}

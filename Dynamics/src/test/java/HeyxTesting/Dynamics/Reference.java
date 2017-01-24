package HeyxTesting.Dynamics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Reference {
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
  public void referenced() {
	  WebElement corporate_setting_link=driver.findElement(By.xpath("html/body/header/nav/div[3]/ul/li/a"));
	  corporate_setting_link.click();
	  WebElement referenced_code=driver.findElement(By.xpath("html/body/header/nav/div[3]/ul/li/ul/li[2]/a/span"));
	  referenced_code.click();
	 // driver.findElement(By.xpath(".//*[@id='2']/td[4]/a/i")).click();
	  //WebElement search=driver.findElement(By.cssSelector("input[type=’search’]"));
//	  search.click();
	 // search.sendKeys("company");
//	  search.click();
	 // driver.findElement(By.cssSelector("input[type='search']")).sendKeys("company");;
	  Select s=new Select(driver.findElement(By.name("tableList_length")));
	  s.selectByIndex(1);
	  
  }
  
  @BeforeTest
  public void start()
  {
	  driver=new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.get("http://52.54.76.113/dynamics");
  }
}

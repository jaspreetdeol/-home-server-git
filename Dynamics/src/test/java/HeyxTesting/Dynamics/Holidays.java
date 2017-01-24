package HeyxTesting.Dynamics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Holidays {
	
	WebDriver 	driver;
  @Test(priority =1)
  public void authenticate() {
	  
	  //find elements here
	  WebElement user=driver.findElement(By.name("username"));
	  WebElement pass=driver.findElement(By.name("password"));
	  WebElement btn=driver.findElement(By.xpath("html/body/div[2]/form/div[4]/button"));
	
	  //action here
	  
	  int id1X = driver.findElement(By.name("username")).getLocation().x; 
	  int id2X = driver.findElement(By.name("password")).getLocation().x;
	  System.out.println(id1X + "    " +id2X);
	  if(id1X==id2X)
	  {
		  System.out.println("Is aligned");
	  }
	  else
	  {
		  System.out.println("Not Aligned");
	  }
	  //Assert.assertEquals(id1X, id2X);
//	  JavascriptExecutor ex=(JavascriptExecutor) driver;
//	  ex.executeScript("alert('Ok')");
	  
	  user.sendKeys("lyoung");
	  pass.sendKeys("1");
	  btn.click();
 
  }
  @Test(priority =2)
  public void corporateSetting() throws InterruptedException {
	  //find elements
	  
	  WebElement corporate_setting_link=driver.findElement(By.xpath("html/body/header/nav/div[3]/ul/li/a"));
	WebElement holiday=driver.findElement(By.xpath("html/body/header/nav/div[3]/ul/li/ul/li[1]/a"));
	//cations on links
 corporate_setting_link.click();
 holiday.click();
 
 //new entery in holiday
 WebElement new_holiday=driver.findElement(By.xpath(".//*[@id='content']/div[3]/div[1]/a/span"));
 new_holiday.click();
 //enter holiday name
 WebElement holiday_name=driver.findElement(By.xpath(".//*[@id='holidayName']"));
 holiday_name.sendKeys("xyz16");
 //enter holiday date
 WebElement holiday_date=driver.findElement(By.xpath(".//*[@id='holidayDate']"));
 holiday_date.click();
 //Thread.sleep(2000);
// WebElement holiday_date_pick=driver.findElement(By.xpath("div/ul/li[1]/div/div[1]/table/tbody/tr[3]/td[5]"));
// holiday_date_pick.click();
// 
 WebElement holiday_button=driver.findElement(By.xpath(".//*[@id='formModal']/div[2]/button[2]"));
 holiday_button.click();
 
//driver.close();
 WebElement edit=driver.findElement(By.xpath(".//*[@id='tableList']/tbody/tr[1]/td[3]/a[1]/i"));
  //driver.navigate().back();
 edit.click();
  }
  
  
  @BeforeTest
  public void beforeTest() {
	  driver=new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.get("http://52.54.76.113/dynamics");
  }

  @AfterTest
  public void afterTest() {
	  //driver.quit();
  }
  
  @DataProvider()
  public Object[][] holiday(){
	  return new Object[][]{
			  {"chistmas"},
			  {"republic"}
			  
	  };
  }
  

}

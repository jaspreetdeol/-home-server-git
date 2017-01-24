package HeyxTesting.Dynamics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class ProjectRole {
	
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
	  WebElement project_role=driver.findElement(By.xpath("html/body/header/nav/div[3]/ul/li/ul/li[3]/a/span"));
	  project_role.click();
	  WebElement new_project=driver.findElement(By.xpath(".//*[@id='content']/div[3]/div[1]/a"));
	  new_project.click();
	  WebElement role_name=driver.findElement(By.xpath(".//*[@id='name']"));
	  role_name.sendKeys("tester");
	  WebElement role_description=driver.findElement(By.xpath(".//*[@id='description']"));
	  role_description.sendKeys("job to find bugs");
	  WebElement button_role=driver.findElement(By.xpath(".//*[@id='submit']"));
	  button_role.click();
	  String error_message=driver.findElement(By.xpath(".//*[@id='modalError']")).getText();
	  //error_message.getText();
	// String text= driver.switchTo().alert().getText();
	  System.out.println(" message is   " +error_message);
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
  
  @AfterTest
  public void afterTest() {
  }

}

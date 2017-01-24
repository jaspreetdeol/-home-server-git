package HeyxTesting.Dynamics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Links {
	
	WebDriver driver;
  @Test
  public void Links() {
	  
	  //Dynamics d=new Dynamics();
	 // d.beforeTest();
	  
	  
	  driver=new FirefoxDriver();
	  driver.get("http://52.54.76.113/dynamics");
	 // d.authenticate();d.authenticate();
	  WebElement user=driver.findElement(By.name("username"));
	  WebElement pass=driver.findElement(By.name("password"));
	  WebElement btn=driver.findElement(By.xpath("html/body/div[2]/form/div[4]/button"));
	
	  //action here
	  user.sendKeys("lyoung");
	  pass.sendKeys("1");
	  btn.click();
	  
	 List<WebElement> getLinks= driver.findElements(By.tagName("a"));
	 System.out.println("Total lins  " +getLinks.size());
	 String[] s=new String[getLinks.size()];
	 int  i=0;
	 for(WebElement link:getLinks)
	 {
		 s[i]=link.getText();
		 driver.findElement(By.linkText(s[i])).click();
		System.out.println(s[i]);
		 i++;
		 driver.navigate().back();
	 }
	 
	 for(String s1:s)
	 {
		 
		  //action here
		  
		// driver.findElement(By.linkText(s1)).click();
		 
		// System.out.println(s1);
		 //driver.navigate().back();
		 
		 user.sendKeys("lyoung");
		  pass.sendKeys("1");
		  btn.click();
	 }
	  
	  
  }
}

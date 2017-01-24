package HeyxTesting.Dynamics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Approval {
	WebDriver driver;
	
	@Test(priority =1)
	  public void authenticate() {
		  
		  //find elements here
		  WebElement user=driver.findElement(By.name("username"));
		  WebElement pass=driver.findElement(By.name("password"));
		  WebElement btn=driver.findElement(By.xpath("html/body/div[2]/form/div[4]/button"));
		  user.sendKeys("lyoung");
		  pass.sendKeys("1");
		  btn.click();
	 
	  }
	
	
	
  @Test(priority=2,dataProvider="data")
  public void checkApp(String w,String a,String s) {
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.navigate().to("http://52.54.76.113/dynamics/approval");
	 WebElement week_start=driver.findElement(By.xpath(".//*[@id='weekDate']"));
	week_start.sendKeys(w);
	 WebElement associate= driver.findElement(By.xpath(".//*[@id='userMasterId']"));
	associate.sendKeys(a);
	 WebElement status=driver.findElement(By.xpath(".//*[@id='status']"));
	 status.sendKeys(s);
	 WebElement filter=driver.findElement(By.xpath(".//*[@id='status']"));
	 filter.click();
	 WebElement default_val=driver.findElement(By.xpath(".//*[@id='content']/div[2]/div[1]/div[4]/div/button[2]"));
	 default_val.click();
  }
  @Test(priority=3)
  public void select()
  {
	  WebElement select1=driver.findElement(By.xpath(".//*[@id='tableList_length']/label/select"));
	  Select s=new Select(select1);
	  s.selectByIndex(1);
  }
  
  @Test(priority=4,dataProvider="search")
  public void search(String d) throws InterruptedException
  {
	  WebElement search=driver.findElement(By.xpath(".//*[@id='tableList_filter']/label/input"));
	  search.sendKeys(d);
	  Thread.sleep(2000);
	  search.clear();
  }
  @Test(priority=5)
  public void alignment() throws InterruptedException
  {
	  WebElement week_start=driver.findElement(By.xpath(".//*[@id='weekDate']"));
		int x1=week_start.getLocation().getX();
	  WebElement associate= driver.findElement(By.xpath(".//*[@id='userMasterId']"));
	  int x2=associate.getLocation().getX();
	  WebElement status=driver.findElement(By.xpath(".//*[@id='status']"));
	  int x3=status.getLocation().getX();
	 // WebElement filter=driver.findElement(By.xpath(".//*[@id='status']"));
	  //int x4=filter.getLocation().getX();
	  WebElement default_val=driver.findElement(By.xpath(".//*[@id='content']/div[2]/div[1]/div[4]/div/button[2]"));
//	  int x5=default_val.getLocation().getX();
//	  WebElement approvals=driver.findElement(By.xpath(".//*[@id='tableList']/thead/tr/th[1]"));
	  //int x6=approvals.getLocation().getX();
	  WebElement show_enteries=driver.findElement(By.xpath(".//*[@id='tableList_length']/label"));
	  int x7=show_enteries.getLocation().getX();
	  WebElement week_start1= driver.findElement(By.xpath(".//*[@id='tableList']/thead/tr/th[1]"));
	  int x8=week_start1.getLocation().getX();
	  if(x1==x2&& x2==x3&&x3==x7&&x7==x8)
	  	{
		  JavascriptExecutor ev=(JavascriptExecutor) driver;
		  ev.executeScript("alert('x direction aligned "+x7+"+"+x8+"')");
		  	  	}
	  
	  else
	  {
		  JavascriptExecutor ev=(JavascriptExecutor) driver;
		  ev.executeScript("alert('x direction not aligned')");

	  }
	  Thread.sleep(2000);
	 // driver.switchTo().alert().accept();
	  }
  
  
  
  @Test(priority=6)
  public void approveOrReject()
  {
	  WebElement check_app=driver.findElement(By.xpath("file:///home/server/Pictures/Approve.png"));
	  check_app.click();
	  driver.findElement(By.xpath(".//*[@id='timeEntryForm']/div[2]/div/div/div[4]/div/button[1]")).click();
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
	  //driver.quit();
  }

  @DataProvider(name="search")
  public Object[][] searchData()
  {
	  return new Object[][]{
			  {"l"},
			  {"y"},
			  {"s"}
	  };
  }
  
  @DataProvider(name="data")
  public Object[][] approvalData()
  {
	  return new Object[][]{
			  //{"01/15/2017","Linney Young","Submitted"},
			  {"01/22/2017","Linney Young","Approved"}
			  //{"01/29/2017","bharti user","Invoiced"}
	  };
  }
}

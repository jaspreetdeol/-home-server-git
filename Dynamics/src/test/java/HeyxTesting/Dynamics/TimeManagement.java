package HeyxTesting.Dynamics;


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

/**
 * @author server
 *
 */
public class TimeManagement {
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
	public void insert()
	{
		WebElement add_row=driver.findElement(By.xpath(".//*[@id='timeEntryForm']/div[2]/div/div/div[4]/div/button[3]"));
		add_row.click();
		WebElement project=driver.findElement(By.xpath(".//*[@id='aoTimeDetailDto0.engSubprojectId']"));
		Select s=new Select(project);
		s.selectByIndex(1);
		WebElement activity_Description=driver.findElement(By.xpath(".//*[@id='aoTimeDetailDto0.description']"));
		activity_Description.sendKeys("working on dynamics");
		WebElement bill=driver.findElement(By.xpath(".//*[@id='aoTimeDetailDto0.billable1']"));
		bill.click();
		WebElement sun=driver.findElement(By.xpath(".//*[@id='aoTimeDetailDto0.hourDetails1.hours']"));
		String s1=sun.getText();
		
		System.out.println(s1);
		sun.sendKeys("3");
		
		WebElement mon=driver.findElement(By.xpath(".//*[@id='aoTimeDetailDto0.hourDetails2.hours']"));
		mon.sendKeys("3");
		WebElement tues=driver.findElement(By.xpath(".//*[@id='aoTimeDetailDto0.hourDetails3.hours']"));
		tues.sendKeys("3");
		WebElement wed=driver.findElement(By.xpath(".//*[@id='aoTimeDetailDto0.hourDetails4.hours']"));
		wed.sendKeys("3");
		WebElement thurs=driver.findElement(By.xpath(".//*[@id='aoTimeDetailDto0.hourDetails5.hours']"));
		thurs.sendKeys("3");
		WebElement fri=driver.findElement(By.xpath(".//*[@id='aoTimeDetailDto0.hourDetails6.hours']"));
		fri.sendKeys("3");
		WebElement sat=driver.findElement(By.xpath(".//*[@id='aoTimeDetailDto0.hourDetails7.hours']"));
		sat.sendKeys("36");
		WebElement save=driver.findElement(By.xpath(".//*[@id='timeEntryForm']/div[2]/div/div/div[4]/div/button[2]"));
		save.click();
		
	}
	@Test(priority=3)
	public void Show() throws InterruptedException
	{
		WebElement Total_hour= driver.findElement(By.xpath(".//*[@id='totalHours']"));
		String text1=Total_hour.getText();
		WebElement Total_hour_display= driver.findElement(By.xpath(".//*[@id='totalHours']"));
		String text2=Total_hour_display.getText();
		JavascriptExecutor ex=(JavascriptExecutor) driver;
		if(text1.equals(text2))
		{
			ex.executeScript("alert('Total working hours equals')");
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
		}
	}
	@Test(priority=4)
	public void update()
	{
		
	}
	@Test(priority=5)
	public void alignment() throws InterruptedException
	{
		int x1=driver.findElement(By.xpath(".//*[@id='content']/div[1]/div/h3")).getLocation().x;
		int x2=driver.findElement(By.xpath(".//*[@id='content']/div[2]/div[1]/div")).getLocation().x;
		int x3=driver.findElement(By.xpath(".//*[@id='content']/div[2]/div[2]/div")).getLocation().x;
		int x4=driver.findElement(By.xpath(".//*[@id='content']/div[2]/div[3]/div")).getLocation().x;
		if(x1==x2 && x2==x3 && x3==x4)
		{
			JavascriptExecutor ex=(JavascriptExecutor) driver;
			ex.executeScript("alert('x aligned')");
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
		}
		
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
		  driver.quit();
	  }

	  

  
  
  @DataProvider(name="time")
public Object[][] addTime()
{
	return new Object[][]{
			{"","","","",""},
			{},
			{}
	};
	  
	  }
}

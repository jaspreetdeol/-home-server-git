package HeyxTesting.Dynamics;

//package HeyxTesting.Dynamics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Companies {
	WebDriver driver;
	
	
	@BeforeSuite 
	public void data()
	{
		driver=new FirefoxDriver();
		driver.get("http://google.com");
	}
	@Test(priority =1)
	  public void authenticate() {
		  
		  //find elements here
		System.out.println("authenticating......");
		  WebElement user=driver.findElement(By.name("username"));
		  WebElement pass=driver.findElement(By.name("password"));
		  WebElement btn=driver.findElement(By.xpath("html/body/div[2]/form/div[4]/button"));
		
		  //action here
		  user.sendKeys("lyoung");
		  pass.sendKeys("1");
		  btn.click();
		  System.out.println("authenticated......");
	 
	  }
@Test(priority=2, dataProvider="Reg")
public void insert(String name,String code1,String type,int status,String log,String url1) throws InterruptedException {
	
	System.out.println("Check Insert field with different inputs");
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  WebElement corporate_setting_link=driver.findElement(By.xpath("html/body/header/nav/div[3]/ul/li/a"));
	  corporate_setting_link.click();
	  WebElement Companies=driver.findElement(By.xpath("html/body/header/nav/div[3]/ul/li/ul/li[4]/a/span"));
	  Companies.click();
	  Thread.sleep(2000);
	  WebElement new_company=driver.findElement(By.xpath(".//*[@id='content']/div[3]/div[1]/a"));
	  new_company.click();
	  Thread.sleep(2000);
	  WebElement company_name=driver.findElement(By.xpath(".//*[@id='name']"));
	  company_name.sendKeys(name);
	  WebElement company_code=driver.findElement(By.xpath(".//*[@id='code']"));
	  company_code.sendKeys(code1);
	 WebElement company_type=driver.findElement(By.xpath(".//*[@id='type']"));
	 company_type.sendKeys(type);
	  WebElement company_status=driver.findElement(By.xpath(".//*[@id='status']"));
	  Select select_status=new Select(company_status);
	  select_status.selectByIndex(status);
	  WebElement invoice_code=driver.findElement(By.xpath(".//*[@id='invoiceCode']"));
	 boolean code=invoice_code.isEnabled();
	 System.out.println("it should be disabled"+code);
	 
	 WebElement invoice_sequence=driver.findElement(By.xpath(".//*[@id='invoiceCode']"));
	 boolean seq=invoice_sequence.isEnabled();
	 System.out.println("it should be disabled"+seq);
	 
	 WebElement logo=driver.findElement(By.xpath(".//*[@id='logo']"));
	 logo.sendKeys(log);
	 WebElement url=driver.findElement(By.xpath(".//*[@id='url']"));
	 url.sendKeys(url1);
	 
	  WebElement button_role=driver.findElement(By.xpath(".//*[@id='formModal']/div/div[5]/button[2]"));
	  button_role.click();
	  Thread.sleep(3000);
	  String error_message=driver.findElement(By.xpath(".//*[@id='modalError']")).getText();

	  System.out.println(" message is   " +error_message);
	  if(error_message.isEmpty())
	  {
	  }
	  else
	  {
		  System.out.println("Error message arised");
		  driver.findElement(By.xpath(".//*[@id='formModal']/div/div[5]/button[1]")).click();
		  System.out.println("Close pressed");
	  }
	  System.out.println("Checked");
}

@Test(priority=3)
public void Update() throws InterruptedException
{ 
	  
	System.out.println("update test");
	  driver.findElement(By.xpath(".//*[@id='tableList']/tbody/tr[1]/td[6]/a[1]/i")).click();
	  Thread.sleep(3000);
	  
	  driver.findElement(By.xpath(".//*[@id='formModal']/div/div[5]/button[2]")).click();

	  Thread.sleep(3000);
	  String error_message=driver.findElement(By.xpath(".//*[@id='modalError']")).getText();

	  if(error_message.equals("Company already exists!!"))
	  {
		  
		 WebElement edit_name= driver.findElement(By.xpath(".//*[@id='name']"));
		 edit_name.clear();
		 edit_name.sendKeys("Abc");
		WebElement edit_code=  driver.findElement(By.xpath(".//*[@id='code']"));
		edit_code.clear();
		edit_code.sendKeys("lmn");
		driver.findElement(By.xpath(".//*[@id='formModal']/div/div[5]/button[2]")).click();
		  //driver.findElement(By.xpath(".//*[@id='formModal']/div/div[5]/button[1]")).click();
	  }
	  else
	  {
		  driver.findElement(By.xpath(".//*[@id='formModal']/div/div[5]/button[1]")).click();

	  }
	 System.out.println("Checked");
	
	}

@Test(priority=4)
public void delete()
{

		System.out.println("delete");
	  driver.findElement(By.xpath(".//*[@id='tableList']/tbody/tr[1]/td[6]/a[2]/i")).click();
	  driver.switchTo().alert().accept();
	  System.out.println("Deleted");
	}

@Test(priority=5)
public void select()
{
	System.out.println("Selcting");
	Select s=new Select(driver.findElement(By.name("tableList_length")));
		  s.selectByIndex(1);
		  
		  System.out.println("Selected");
	}
@Test(priority=6,dataProvider="search")
public void search(String data) throws InterruptedException
{
	System.out.println("Seaching");
	WebElement search=driver.findElement(By.xpath(".//*[@id='tableList_filter']/label/input"));
	search.sendKeys(data);
	Thread.sleep(2000);
	search.clear();
	System.out.println("Searched");
}

  @BeforeTest
  public void start()
  {
	  System.out.println("=========================================");
	  System.out.println("Starting COMPANY module test");
	  driver=new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.get("http://52.54.76.113/dynamics");
	 System.out.println("started");
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
	  System.out.println("QUIT");
	  System.out.println("=========================================");
  }
  
  
  @DataProvider(name="Reg")
  public Object[][] companyRegister()
  {
	  return new Object[][]{
			  {"hello","hi","Client",1," ","http://www.google.com"},
			  {" ","hi123","Services",0,"/home/server/Pictures/images2.png","http://www.google.com"},
			  {" ok", "  ","Contractor",1,"/home/server/Pictures/images2.png","http://www.google.com"},
			  {"Working","123"," ",2,"/home/server/Pictures/images2.png","http://www.google.com"},
	  };
  }
  
  @DataProvider(name="search")
  public Object[][] searchData()
  {
	  return new Object[][]{
			  {"a"},
			  {"x"},
			  {"b"},
			  {"m"},
	  };
  }

}

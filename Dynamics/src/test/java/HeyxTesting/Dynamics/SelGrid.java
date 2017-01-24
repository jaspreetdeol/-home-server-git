package HeyxTesting.Dynamics;


import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class SelGrid {

	static WebDriver driver;
	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities cap= DesiredCapabilities.android();
		cap.setPlatform(Platform.ANDROID);
		cap.setBrowserName("chrome");
		WebDriver driver = new RemoteWebDriver(new URL(
			    "http://192.168.122.1:8080/wd/hub"), cap);
			driver.get("http://google.com");
			

	}
	
}

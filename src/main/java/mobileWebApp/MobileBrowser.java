package mobileWebApp;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;

public class MobileBrowser {
	static AndroidDriver driver;

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, MobileBrowserType.BROWSER);
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");
		
		driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.get("http://the-internet.herokuapp.com/login");
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		  driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		  driver.findElement(By.className("radius")).click(); 
		  driver.close();

	}

}

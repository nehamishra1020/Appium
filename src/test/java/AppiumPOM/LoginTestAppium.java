package AppiumPOM;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import AppiumPOM.*;


public class LoginTestAppium  {

	static AndroidDriver driver;

	@Test
	public void logintestAppium() throws MalformedURLException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "6.0");// fire adb command adb shell getprop ro.build.version.release
		cap.setCapability("deviceName", "emulator-5554"); // fire adb get-serialno
		cap.setCapability("appPackage", "com.tfs.testappium"); // fire dumpsys window windows | grep -E 'mCurrentFocus'
		cap.setCapability("appActivity", "com.tfs.testappium.MainActivity");// fire dumpsys window windows | grep -E 'mCurrentFocus'
		cap.setCapability("noReset", true);

		driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	}
		
		@Test
		public void f(){
			
			AppiumObjects object = new AppiumObjects(driver);
	      object.username.sendKeys("Pratiksha");
		object.password.sendKeys("Daptare");
		object.login.click();

		driver.closeApp();


		

	}
}
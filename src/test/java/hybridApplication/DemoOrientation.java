package hybridApplication;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class DemoOrientation {
	static AndroidDriver driver;
	
	  
	  @BeforeTest
	  public void beforeTest() throws MalformedURLException {
		  DesiredCapabilities cap = new DesiredCapabilities();
			 cap.setCapability("platformName", "Android");
			 cap.setCapability("platformVersion", "6.0");// fire adb command adb shell getprop ro.build.version.release
			 cap.setCapability("deviceName", "emulator-5554"); // fire adb get-serialno
			 cap.setCapability("appPackage", "io.appium.android.apis"); // fire dumpsys window windows | grep -E 'mCurrentFocus'
			 cap.setCapability("appActivity", "io.appium.android.apis.ApiDemos");// fire dumpsys window windows | grep -E 'mCurrentFocus'
			 cap.setCapability("noReset", true);
			 driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	  }
	  
	  @Test
	  public void f() throws InterruptedException {
		  System.out.println("current screen orientation is : +"+driver.getOrientation());
		  Thread.sleep(3000);
		  
		  driver.rotate(ScreenOrientation.LANDSCAPE);
		  System.out.println("current screen orientation is : +"+driver.getOrientation());
		  
		  Thread.sleep(3000);
		  System.out.println("current screen orientation is : +"+driver.getOrientation());
		  
		 // File scrfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 // FileUtils.copyFile(scrfile, new File("C:\\Screenshot\\") + "appLandscape.png");
		  
		  Thread.sleep(3000);
		  driver.rotate(ScreenOrientation.PORTRAIT);
		  System.out.println("current screen orientation is : +"+driver.getOrientation());
		  
		 // File scrfile1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  //FileUtils.copyFile(scrfile, new File("C:\\Screenshot\\") + "appPotrait.png");
		  
	
}
}

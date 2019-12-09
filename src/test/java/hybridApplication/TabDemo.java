package hybridApplication;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import junit.framework.Assert;

public class TabDemo {
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
		  driver.findElement(MobileBy.AndroidUIAutomator("text(\"Views\")")).click();
		  System.out.println("clicked on views ");
		  driver.findElement( MobileBy.AccessibilityId("Chronometer")).click();
		  
		  AndroidElement starttime = (AndroidElement) driver.findElementById("com.example.android.apis:id/chronometer");
		  Thread.sleep(20);
		WebElement start=  driver.findElementById("com.example.android.apis:id/start");
		WebElement stop=  driver.findElementById("com.example.android.apis:id/stop");
		
		TouchAction dragdrop =new TouchAction(driver);
		  dragdrop.tap(start)
		  .waitAction(Duration.ofMillis(12000))
		  .tap(stop)
		  .release()
		  .perform();
		  
		 String latesttime = starttime.getText();
		  
		 Assert.assertNotSame(latesttime,"Initial format: 00:00");
		
		  
		  
  }
}

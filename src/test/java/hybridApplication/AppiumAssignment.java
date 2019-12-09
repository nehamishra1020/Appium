package hybridApplication;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.PressesKeyCode;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class AppiumAssignment {
	
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
		  driver.findElement(MobileBy.AndroidUIAutomator("text(\"Date Widgets\")")).click();
		  driver.findElement(MobileBy.AndroidUIAutomator("text(\"2. Inline\")")).click();
		  
		  WebElement three = driver.findElement(MobileBy.AccessibilityId("3"));
		  three.click();
		  Thread.sleep(20000);
		  
		  WebElement fortyfive = driver.findElement(MobileBy.AccessibilityId("45"));
		  
		  TouchAction dragdrop =new TouchAction(driver);
		  dragdrop.longPress(three).moveTo(fortyfive).release().perform();
		  
		  ((PressesKeyCode)driver).pressKeyCode(AndroidKeyCode.BACK);
			 Thread.sleep(3000);
			 ((PressesKeyCode)driver).pressKeyCode(AndroidKeyCode.HOME);
			 Thread.sleep(3000);
	  }
}

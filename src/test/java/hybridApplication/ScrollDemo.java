package hybridApplication;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class ScrollDemo {
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
		  scrollToExactElement("Tabs");
		  driver.findElement(MobileBy.AndroidUIAutomator("text(\"Tabs\")")).click();
		  
		  
		  
}
	  
	  @SuppressWarnings("unchecked")
	public void scrollToExactElement(String str) {
          ((AndroidDriver<WebElement>) driver).findElement(MobileBy.AndroidUIAutomator(
                     "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""
                                + str + "\").instance(0))"));
    }

    public void scrollToElement(String str) {
          ((AndroidDriver<WebElement>) driver).findElement(MobileBy.AndroidUIAutomator(
                     "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
                                + str + "\").instance(0))"));
    }

}

package hybridApplication;

import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

public class MultipleActions {
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
	  public void f() {
		  driver.findElement(MobileBy.AndroidUIAutomator("text(\"Views\")")).click();
		  System.out.println("clicked on views ");
		  driver.findElement(MobileBy.AccessibilityId("Controls")).click();
		  System.out.println("clicked on controls ");
		  driver.findElement(MobileBy.AccessibilityId("2. Dark Theme")).click();
		  System.out.println("clicked on theme ");
		  driver.findElementById("com.example.android.apis:id/edit").sendKeys("Neha Mishra");
		  driver.hideKeyboard();
		  driver.findElementById("android:id/text1").click();
		  
		  List dropdown =driver.findElementsById("android:id/text1");
		  
		  for(int i=0; i<dropdown.size(); i++){
			  MobileElement ele =  (MobileElement) dropdown.get(i);
			  System.out.println(ele.getText());
			  
		  }
		  
		  driver.findElement(MobileBy.AndroidUIAutomator("text(\"Mars\")")).click();
		  
		  	  
		  
}
}

package hybridApplication;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DragandDrop {
	
	static AndroidDriver driver;
	
@BeforeTest
	
	public void beforeTest() throws MalformedURLException{
	
	File app= new File(System.getProperty("user.dir")+"\\Apps\\Drag-SortDemos.apk");
	DesiredCapabilities cap=new DesiredCapabilities();
	cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
	cap.setCapability("platformName", "Android");
	cap.setCapability("platformVersion", "6.0");
	cap.setCapability("deviceName", "emulator-5554");
	
	driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
}
	
  @Test
  public void f() throws InterruptedException {
	  
	  
	  driver.findElement(MobileBy.AndroidUIAutomator("text(\"Basic usage playground\")")).click();
	  System.out.println("clicked on basic usage playground");
	  Thread.sleep(2000);
	  WebElement el=(WebElement) driver.findElementsById("com.mobeta.android.demodslv:id/drag_handle").get(2);
	  WebElement el2=(WebElement) driver.findElementsById("com.mobeta.android.demodslv:id/drag_handle").get(5);
	  
	  TouchAction dragdrop =new TouchAction(driver);
	  dragdrop.longPress(el).moveTo(el2).release().perform();
	  System.out.println("element dropped successfully");
	  
	  
	  
	  
	  
  }
}

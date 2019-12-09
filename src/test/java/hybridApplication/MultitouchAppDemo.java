package hybridApplication;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class MultitouchAppDemo {
static AndroidDriver driver;
	
	@BeforeTest
	
	public void beforeTest() throws MalformedURLException{
		
		File app = new File(System.getProperty("user.dir")+"\\Apps\\MultiTouchTester.apk");
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "6.0");
		cap.setCapability("deviceName", "emulator-5554");
		
		driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	}
	
  @Test
  public void f() {
	  
	  System.out.println("Application installed");
	  
	  Dimension size;
	  
	  size =driver.manage().window().getSize();
	  
	  int x1 = (int) (size.width * 0.20);
	  int y1 = (int) (size.height * 0.20);
	  
	  int x2 = (int) (size.width * 0.80);
	  int y2 = (int) (size.height * 0.20);
	  
	  
	  int x3 = (int) (size.width * 0.20);
	  int y3 = (int) (size.height * 0.80);
	  
	  int x4 = (int) (size.width * 0.80);
	  int y4 = (int) (size.height * 0.80);
	  

	  int x5 = (int) (size.width /2);
	  int y5 = (int) (size.height /2);
	  
	  TouchAction a1=new TouchAction(driver).longPress(x1, y1).waitAction(Duration.ofSeconds(5));
	  TouchAction a2=new TouchAction(driver).longPress(x2, y2).waitAction(Duration.ofSeconds(5));
	  TouchAction a3=new TouchAction(driver).longPress(x3, y3).waitAction(Duration.ofSeconds(5));
	  TouchAction a4=new TouchAction(driver).longPress(x4, y4).waitAction(Duration.ofSeconds(5));
	  TouchAction a5=new TouchAction(driver).longPress(x5, y5).waitAction(Duration.ofSeconds(5));
	  

	  MultiTouchAction maction =new MultiTouchAction(driver);
	  maction.add(a1).add(a2).add(a3).add(a4).add(a5).perform();
	  
  }
}


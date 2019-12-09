package hybridApplication;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class InstallAppDemo {
	
	static AndroidDriver driver;
	
	@BeforeTest
	
	public void beforeTest() throws MalformedURLException{
		
		File app = new File(System.getProperty("user.dir")+"\\Apps\\ApiDemos-debug.apk");
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "6.0");
		cap.setCapability("deviceName", "emulator-5554");
		cap.setCapability("appPackage", "com.example.android.apis");
		cap.setCapability("appActivity", "com.example.android.apis.graphics.BitmapDecode");
		
		driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	}
	
  @Test
  public void f() {
	  
	  System.out.println("Application installed");
	  
	  
  }
}

package com.nativeApp;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Contacts {
	static AndroidDriver driver;
	
	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		DesiredCapabilities cap = new DesiredCapabilities();
		 cap.setCapability("platformName", "Android");
		 cap.setCapability("platformVersion", "6.0");// fire adb command adb shell getprop ro.build.version.release
		 cap.setCapability("deviceName", "emulator-5554"); // fire adb get-serialno
		 cap.setCapability("appPackage", "com.android.contacts"); // fire dumpsys window windows | grep -E 'mCurrentFocus'
		 cap.setCapability("appActivity", "com.android.contacts.activities.PeopleActivity");// fire dumpsys window windows | grep -E 'mCurrentFocus'
		 cap.setCapability("noReset", true);
		 
		 driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		 
		 driver.findElementByXPath("//android.widget.Button[@text='Create a new contact']").click();
		 driver.findElementByXPath("//android.widget.EditText[@text='Name']").sendKeys("Neha");
		 driver.findElementByXPath("//android.widget.EditText[@text='Phone']").sendKeys("0123456");
		// driver.findElementByXPath("//android.widget.EditText[@text='Email']").sendKeys("test@test.com");
		 driver.findElementById("com.android.contacts:id/menu_save").click();
		 driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		 driver.findElementById("com.android.contacts:id/cliv_name_textview").getText();
		
		 
		 driver.closeApp();


	}

}

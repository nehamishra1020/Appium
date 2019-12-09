package com.nativeApp;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class Canculater {
	
	static AndroidDriver driver;

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub		 
		 
			  
			DesiredCapabilities cap = new DesiredCapabilities();
			 cap.setCapability("platformName", "Android");
			 cap.setCapability("platformVersion", "6.0");// fire adb command adb shell getprop ro.build.version.release
			 cap.setCapability("deviceName", "emulator-5554"); // fire adb get-serialno
			 cap.setCapability("appPackage", "com.android.calculator2"); // fire dumpsys window windows | grep -E 'mCurrentFocus'
			 cap.setCapability("appActivity", "com.android.calculator2.Calculator");// fire dumpsys window windows | grep -E 'mCurrentFocus'
			 cap.setCapability("noReset", true);
			 
			 driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
			 
			 driver.findElementById("com.android.calculator2:id/digit_9").click();
			 driver.findElementById("com.android.calculator2:id/op_add").click();
			 driver.findElementById("com.android.calculator2:id/digit_2").click();
			 driver.findElementById("com.android.calculator2:id/result").getText();
			
			 
			 driver.closeApp();

	}

}

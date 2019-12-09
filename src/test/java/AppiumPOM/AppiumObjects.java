package AppiumPOM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AppiumObjects {
	
	public AppiumObjects(AndroidDriver driver){
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	
	@AndroidFindBy(id="txtUN")
	public WebElement username;
	
	@AndroidFindBy(id="txtPWD")
	public WebElement password;
	
	@AndroidFindBy(id="btnLogin")
	public WebElement login;
	

}

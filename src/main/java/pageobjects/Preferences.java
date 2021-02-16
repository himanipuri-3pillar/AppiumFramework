package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

//import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Preferences {

	public Preferences(AndroidDriver<AndroidElement> driver) {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='3. Preference dependencies']")
	public WebElement dependencies;
	

	@AndroidFindBy(id = "android:id/checkbox")
	public WebElement checkboxselect;
	
	@AndroidFindBy(xpath = "//android.widget.LinearLayout[2]/android.widget.RelativeLayout")
	public WebElement relativelayout;
	
	@AndroidFindBy(className = "\"android.widget.EditText")
	public WebElement entertext;
	
	@AndroidFindBy(id = "android:id/button1")
	public WebElement okbutton;
	

	
}

package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

//import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {

	public HomePage(AndroidDriver<AndroidElement> driver) {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Preference']")
	public WebElement Preferences;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Views']")
	public WebElement Views;

	public WebElement getViews() {
		System.out.println("Click on Views");
		return Views;
	}
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
	public WebElement baseokclick;

}

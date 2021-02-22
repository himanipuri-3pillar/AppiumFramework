package pageobjects;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.TouchAction;
//import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Expandable {

	public Expandable(AndroidDriver<AndroidElement> driver) {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Expandable Lists']")
	public WebElement Expandablelist;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='1. Custom Adapter']")
	public WebElement CustomAdapter;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='People Names']")
	public WebElement PeopleNames;

}

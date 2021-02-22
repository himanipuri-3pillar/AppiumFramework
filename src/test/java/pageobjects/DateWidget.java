package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DateWidget {

	public DateWidget(AndroidDriver<AndroidElement> driver) {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Date Widgets']")
	public WebElement datewidget;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='2. Inline']")
	public WebElement Inline;

	@AndroidFindBy(xpath = "//*[@content-desc='9']")
	public WebElement click9;

	@AndroidFindBy(xpath = "//*[@content-desc='15']")
	public WebElement click15;

	@AndroidFindBy(xpath = "//*[@content-desc='45']")
	public WebElement click45;
	

	
	

}

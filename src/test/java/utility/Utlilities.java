package utility;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Utlilities {

	AndroidDriver<AndroidElement> driver;
	
	
	public Utlilities(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}

	public void scrollToText(String text) {
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));");
	}

	public void longpress(WebElement e)

	{
		TouchAction t = new TouchAction(driver);
		t.longPress(longPressOptions().withElement(element(e)).withDuration(ofSeconds(2))).release().perform();
	}

	public void longpressswipeto(WebElement e1, WebElement e2)

	{
		TouchAction t = new TouchAction(driver);
		t.longPress(longPressOptions().withElement(element(e1)).withDuration(ofSeconds(2))).moveTo(element(e2)).release().perform();
	}

	public void tapoption(WebElement e) {
		TouchAction t = new TouchAction(driver);
		t.tap(tapOptions().withElement(element(e))).perform();
	}
}

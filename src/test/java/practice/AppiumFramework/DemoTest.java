package practice.AppiumFramework;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageobjects.DateWidget;
import pageobjects.Expandable;
import pageobjects.HomePage;
import pageobjects.Preferences;

public class DemoTest extends base {

	// @BeforeTest
	public void stopAllInstances() throws IOException {
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
	}

	@Test
	public void simpleClick() throws IOException, InterruptedException {

		service = startServer();
		AndroidDriver<AndroidElement> driver = capabilities("apiDemo");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
		HomePage h = new HomePage(driver);
		h.baseokclick.click();		
		h.Preferences.click();
		Preferences p = new Preferences(driver);
		p.dependencies.click();
		p.checkboxselect.click();
		p.relativelayout.click();
		p.entertext.sendKeys("Himani");
		p.okbutton.click();
		service.stop();

	}

	// @Test
	public void tappingAndLongpress() throws IOException, InterruptedException {

		service = startServer();
		AndroidDriver<AndroidElement> driver = capabilities("apiDemo");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
		HomePage h = new HomePage(driver);
		h.baseokclick.click();
		h.Views.click();
		// Long Press
		Expandable expobj1 = new Expandable(driver);
		Utlilities u = new Utlilities(driver);
		// Tapping on Expandable list
		u.tapoption(expobj1.Expandablelist);
		// Tapping on CustomAdapter
		u.tapoption(expobj1.CustomAdapter);
		// long pressing peopleNames
		u.longpress(expobj1.PeopleNames);
		// service.stop();

	}

	// @Test
	public void swipeTest() throws IOException, InterruptedException {

		service = startServer();
		AndroidDriver<AndroidElement> driver = capabilities("apiDemo");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
		// Swipetest
		HomePage h = new HomePage(driver);
		h.baseokclick.click();
		h.Views.click();
		DateWidget expobj1 = new DateWidget(driver);
		expobj1.datewidget.click();
		Thread.sleep(2000);
		expobj1.Inline.click();
		Thread.sleep(2000);
		expobj1.click9.click();
		Utlilities u = new Utlilities(driver);
		// Longpressing 45 and then swiping it to 15
		u.longpressswipeto(expobj1.click45, expobj1.click15);
		service.stop();

	}

}

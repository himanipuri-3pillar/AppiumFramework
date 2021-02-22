package practice.AppiumFramework;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageobjects.DateWidget;
import pageobjects.Expandable;
import pageobjects.HomePage;
import pageobjects.Preferences;
import utility.Utlilities;
import utility.base;
import org.apache.log4j.Logger;

public class DemoTest extends base {

	public static Logger log = Logger.getLogger("devpinoyLogger");
	
	@Test
	public void simpleClick() throws IOException, InterruptedException {
		
		log.debug("Appium Server Started");
		service = startServer();
		log.debug("Emulator Started");
		AndroidDriver<AndroidElement> driver = capabilities("apiDemo");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
		HomePage h = new HomePage(driver);
		log.debug("Required Manual Click for basokclick element");
		//The below element i.e baseokclick require manual click to proceed 
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

	@Test
	public void tappingAndLongpress() throws IOException, InterruptedException {
		
		log.debug("Appium Server Started");
		service = startServer();
		log.debug("Emulator Started");
		AndroidDriver<AndroidElement> driver = capabilities("apiDemo");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
		HomePage h = new HomePage(driver);
		//The below element i.e baseokclick require manual click to proceed 
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
		service.stop();

	}

	@Test
	public void swipeTest() throws IOException, InterruptedException {
		log.debug("Appium Server Started");
		service = startServer();
		log.debug("Emulator Started");
		AndroidDriver<AndroidElement> driver = capabilities("apiDemo");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
		// Swipetest
		HomePage h = new HomePage(driver);
		//The below element i.e baseokclick require manual click to proceed 
		h.baseokclick.click();
		h.Views.click();
		DateWidget expobj1 = new DateWidget(driver);
		expobj1.datewidget.click();
		expobj1.Inline.click();
		expobj1.click9.click();
		Utlilities u = new Utlilities(driver);
		// Longpressing 45 and then swiping it to 15
		u.longpressswipeto(expobj1.click45, expobj1.click15);
		service.stop();

	}

}

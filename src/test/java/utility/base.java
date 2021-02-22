package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class base {
	public static AppiumDriverLocalService service;
	public static AndroidDriver<AndroidElement> driver;
	private static String emulatorPath = "C:\\Users\\himani.puri\\AppData\\Local\\Android\\Sdk\\emulator\\emulator";

	public AppiumDriverLocalService startServer()

	{
		boolean flag = checkIfServerIsRunnning(4723);
		if (!flag) {
			service = AppiumDriverLocalService.buildDefaultService();
			service.start();

		}

		return service;

	}

	public static boolean checkIfServerIsRunnning(int port) {

		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);

			serverSocket.close();
		} catch (IOException e) {
			// If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}

	public static void startEmulator(String nameOfAVD) {
		System.out.println("Starting emulator for '" + nameOfAVD + "' ...");
		String[] aCommand = new String[] { emulatorPath, "-avd", nameOfAVD };
		try {
			Process process = new ProcessBuilder(aCommand).start();
			process.waitFor(180, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static AndroidDriver<AndroidElement> capabilities(String appName) throws IOException, InterruptedException {

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\resources\\global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		File f = new File("src/test/java");
		File fs = new File(f, (String) prop.get(appName));
		String device = (String) prop.get("device");
		System.out.print(device);
		if (device.contains("emulator")) {
			startEmulator(device);
		}
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}

	public static void getScreenshot(String s) throws IOException {
		File file1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file1, new File(System.getProperty("user.dir") + "\\screenshots\\" + s + ".png"));
	}

}

package base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.automation.testapp.configuration.TestAppConfiguration;
import com.automation.testapp.pages.HomePage;

import io.appium.java_client.android.AndroidDriver;

public class BaseTest {

	protected static RemoteWebDriver driver;
	protected static HomePage homePage;
	protected static TestAppConfiguration testAppConf;
	private ThreadLocal<RemoteWebDriver> webDriverTL = new ThreadLocal<RemoteWebDriver>();

	@BeforeTest(alwaysRun = true)
	@Parameters({ "deviceName_", "browserName", "platform", "version" })
	public void AndroidDriverSet(String device, String browser,
			String platform, String version) {
		setup(device, browser, platform, version);
	}

	public void openApp() {
		homePage = new HomePage(getRemoteWebDriver());
		homePage.allowStorage();
	}

	public void setup(String device, String browser, String platform,
			String version) {

		testAppConf = TestAppConfiguration.GetInstance();
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("deviceName", device);
		capabilities.setCapability("device", device);

		capabilities.setCapability(CapabilityType.VERSION, version);
		capabilities.setCapability("platformName", platform);
		capabilities.setCapability("appPackage", testAppConf.getAppPackage());
		capabilities.setCapability("appActivity", testAppConf.getAppActivity());

		try {
			driver = new AndroidDriver(new URL(testAppConf.getAppiumURL()),
					capabilities);
			webDriverTL.set(driver);
		} catch (MalformedURLException e) {
			System.out.println("Pleasr check the local Appium URL");
		}
	}

	public RemoteWebDriver getRemoteWebDriver() {
		return webDriverTL.get();
	}

}

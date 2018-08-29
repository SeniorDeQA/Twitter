package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class CapabilitiesIE {
	// Even if you have windows 64-bit version, please download IEDriverServer 32-bit version
	// All protected zones settings should be same (Disabled / Enabled)
	// Zoom Level should be 100%
	// Use Desired Capabilities class to set IE properties

	static final String RUTA_SELENIUM = "C://Users//dortiz//workspace//selenium_3.4.0";
	
	
	public static void main(String[] args) throws Exception {
		WebDriver driver;
		String baseURL = "https://letskodeit.teachable.com/pages/practice";
		
		DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
		caps.setCapability(InternetExplorerDriver.NATIVE_EVENTS, true);
		caps.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
		caps.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
		caps.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		
		System.setProperty("webdriver.ie.driver", RUTA_SELENIUM+"//iedriver.exe");
		driver = new InternetExplorerDriver(caps);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();//No lo coje
		driver.get(baseURL);
		
		driver.close();
		driver.quit();
	}

}



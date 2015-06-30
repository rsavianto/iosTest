package com.happyfresh.ios;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class SetUp {
	
	IOSDriver driver;
	
	@BeforeClass
    public void setUp() throws Exception {
		String appPath = System.getenv("IOS_APP_PATH");
		String appName = System.getenv("IOS_APP_NAME");
		String deviceName = System.getenv("IOS_DEVICE_NAME");
		String platformVersion = System.getenv("IOS_PLATFORM_VERSION");

		File appDir = new File(appPath);
        File app = new File(appDir, appName);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("platformVersion", platformVersion);
        capabilities.setCapability("app", app.getAbsolutePath());
        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}

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
//        File classpathRoot = new File(System.getProperty("user.dir"));

		File appDir = new File("./");

        //File appDir = new File("/Users/mohadzanegisetigung/Documents/ios/");

        File app = new File(appDir, "HappyFresh.app.zip");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium-version","1.4.0");
        capabilities.setCapability("deviceName","iPhone Simulator");
        capabilities.setCapability("platformVersion", "8.3");
        capabilities.setCapability("platformName", "ios");
        capabilities.setCapability("app", app.getAbsolutePath());
        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}

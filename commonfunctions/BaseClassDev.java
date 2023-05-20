package com.commonfunctions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

import com.pompages.FeedPageObjectsDev;
import com.pompages.HomepageDevObjects;
import com.pompages.NavigationDev;
import com.pompages.RegistrationDevObjects;
import com.pompages.TeamCreationPagesDev;
import com.testcases.RegisteredUserLoginTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClassDev {
	
	public static WebDriver wdriver;
	public static Actions act;
	public static AppiumDriver<MobileElement> driver;
	public static WebDriverWait wait;
	public static MobileElement mobileEle;
	public static Properties prop;
	public static RegisteredUserLoginTest registeredUserID;
	public static NavigationDev navLoc;
	public static FeedPageObjectsDev feedObj;
	public static RegistrationDevObjects regLoc;
	public static HomepageDevObjects homLoc;
	public static TeamCreationPagesDev contLoc;
	public static CommonActions commAct;

	@BeforeTest
	public void openApp() throws IOException {
		FileInputStream fis= new FileInputStream("config.properties");
		prop= new Properties();
		prop.load(fis);
		File f = new File("Resources");
		File fs= new File(f,"app-release (23).apk");
		DesiredCapabilities cap= new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "13.0");
		cap.setCapability("deviceName", "Surya3");
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		URL appiumServerURL;
		try {
			appiumServerURL = new URL("http://localhost:4723/wd/hub");
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		driver = new  AndroidDriver<MobileElement>(appiumServerURL,cap);
		System.out.println("Floc Dev Build is opened successfully....");
	}

}

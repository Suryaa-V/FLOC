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
import org.testng.annotations.BeforeSuite;

import com.pagesobjectsmodel.BottomNavigations;
import com.pagesobjectsmodel.ContestPageObjects;
import com.pagesobjectsmodel.HomePageObjects;
import com.pagesobjectsmodel.RegistrationLocators;
import com.testcases.RegisteredUserTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {
	public static WebDriver wdriver;
	public static Actions act;
	public static AppiumDriver<MobileElement> driver;
	public static WebDriverWait wait;
	public static Properties prop;
	public static RegistrationLocators regLoc;
	public static HomePageObjects homLoc;
	public static BottomNavigations navLoc;
	public static ContestPageObjects contLoc;
	public static CommonActions comAct;
	public static RegisteredUserTest registeredUserID;
	
	@BeforeSuite
	public void openApp() throws IOException {
		FileInputStream fis= new FileInputStream("config.properties");
		prop= new Properties();
		prop.load(fis);
		File f = new File("Resources");
		File fs= new File(f,"floc (7).apk");
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
		System.out.println("Floc is opened successfully....");
	}



}

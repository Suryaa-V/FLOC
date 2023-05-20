package com.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.commonfunctions.BaseClass;
import com.pagesobjectsmodel.RegistrationLocators;

import io.appium.java_client.MobileElement;

public class RegisteredUserTest extends BaseClass{
	
	// THIS PROGRAM IS TO TEST THE REGISTERED USERS LOGIN FLOW AND FUNCTIONALITY.
    // NOTE: WE HAVE TO TYPE THE OTP MANUALLY .
	@Test(priority = 1)
	public void userRegistration() throws InterruptedException {
		Thread.sleep(5000);
		regLoc= new RegistrationLocators();
		if (driver.findElement(By.id(regLoc.allowButton())).isDisplayed()) {
			driver.findElement(By.id(regLoc.allowButton())).click();
		}
		MobileElement nextButton1 = driver.findElement(By.xpath(regLoc.nextButton1()));
		if (nextButton1.isDisplayed()) {
			nextButton1.click();
			Thread.sleep(1500);	
			MobileElement nextButton2 = driver.findElement(By.xpath(regLoc.nextButton2()));
			if (nextButton2.isDisplayed()) {
				nextButton2.click();
				Thread.sleep(1500);
			}
			MobileElement playNowButton = driver.findElement(By.xpath(regLoc.playNowButton()));
			if (playNowButton.isDisplayed()) {
				playNowButton.click();
				Thread.sleep(3000);
				MobileElement phoneNumberTextField = driver.findElement(By.xpath(regLoc.phoneNumberTextField()));
				if (phoneNumberTextField.isDisplayed()) {
					System.out.println("PASS: Phonenumber textrfield is displayed");
					phoneNumberTextField.click();
					Thread.sleep(500);
					phoneNumberTextField.sendKeys(prop.getProperty("mobileNumber"));
					Thread.sleep(700);
					MobileElement otpButton = driver.findElement(By.xpath(regLoc.sendOtpButton()));
					otpButton.click();
					Thread.sleep(2500);
					driver.findElement(By.xpath(regLoc.otp(1))).click();
					Thread.sleep(20000);
					driver.findElement(By.xpath(regLoc.verifyButton())).click();	
					Thread.sleep(3000);
				}else {
					System.out.println("FAIL:Phone Number textfield is not displayed");
				}
			}else
				System.out.println("FAIL:Play Now button is not displayed");
		}else
			System.out.println("FAIL: NEXT button is not displayed");
	}
}

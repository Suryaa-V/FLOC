package com.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.commonfunctions.BaseClass;
import com.commonfunctions.CommonActions;
import com.pagesobjectsmodel.RegistrationLocators;

import io.appium.java_client.MobileElement;

public class NewUserCreation  extends BaseClass{

	// THIS PROGRAM IS TO TEST INVALID OTP FROM NEW USERS WHILE REGISTRATION.
	
	@Test(priority = 1)
	public void userRegistration() throws InterruptedException {
		Thread.sleep(5000);
		regLoc= new RegistrationLocators();
		if (driver.findElement(By.id(regLoc.allowButton())).isDisplayed()) {
			driver.findElement(By.id(regLoc.allowButton())).click();
		}
		MobileElement nextButton1 = driver.findElement(By.xpath(regLoc.nextButton1()));
		if (nextButton1.isDisplayed()) {
			System.out.println("PASS: NextButton is displayed and it is verified...");
			nextButton1.click();
			Thread.sleep(1500);
			MobileElement nextButton2 = driver.findElement(By.xpath(regLoc.nextButton2()));
			if (nextButton2.isDisplayed()) {
				System.out.println("PASS: NextButton2 is displayed and it is verified...");
				nextButton2.click();
				Thread.sleep(1500);
			}
			MobileElement playNowButton = driver.findElement(By.xpath(regLoc.playNowButton()));
			comAct= new CommonActions();
			if (playNowButton.isDisplayed()) {
				System.out.println("PASS: PlayNow is displayed and it is verified...");
				playNowButton.click();
				String randomNumber=comAct.randomMobileNumber();
				Thread.sleep(3000);
				MobileElement phoneNumberTextField = driver.findElement(By.xpath(regLoc.phoneNumberTextField()));
				if (phoneNumberTextField.isDisplayed()) {
					System.out.println("PASS: Phonenumber textfield is displayed and it is verified...");
					phoneNumberTextField.click();
					Thread.sleep(500);
					phoneNumberTextField.sendKeys(randomNumber);
					comAct.randomMobileNumber();
					Thread.sleep(700);
					MobileElement otpButton = driver.findElement(By.xpath(regLoc.sendOtpButton()));
					System.out.println("PASS: SendOTP Buttom is displayed and it is verified...");
					otpButton.click();
					Thread.sleep(3000);
					String arr[]= {"6","0","0","6","1","3"};
					for(int i=0;i<6;i++) {
						driver.findElement(By.xpath(regLoc.otp(i+1))).sendKeys(arr[i]);
					}
					Thread.sleep(900);
					driver.findElement(By.xpath(regLoc.verifyButton())).click();
					System.out.println("PASS: Verify Button is displayed and it is verified...");
					Thread.sleep(3000);
					if (driver.findElement(By.xpath(regLoc.invalidOtpMessage())).isDisplayed()) {
						System.out.println("PASS: Invalid OTP message is displayed and it is verified");
						Thread.sleep(1000);
						driver.findElement(By.xpath(regLoc.okButtonInvalidOTP())).click();
						System.out.println("ALL PASS !!!");
					}
				}else {
					System.out.println("FAIL:Phone Number textfield is not displayed");
				}
			}else
				System.out.println("FAIL:Play Now button is not displayed");
		}else
			System.out.println("FAIL: NEXT button is not displayed");
	}
}

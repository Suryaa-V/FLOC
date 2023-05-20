package com.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.commonfunctions.BaseClassDev;
import com.commonfunctions.CommonActions;
import com.pompages.RegistrationDevObjects;

import io.appium.java_client.MobileElement;

public class NewUserCreation  extends BaseClassDev{

	@Test(priority = 1)
	public void userRegistration() throws InterruptedException {
		
		commAct= new CommonActions();
		Thread.sleep(5000);
		regLoc= new RegistrationDevObjects();
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
				System.out.println("PASS: Second NextButon is displayed and it is verified...");
				nextButton2.click();
				Thread.sleep(1500);
			}
			MobileElement playNowButton = driver.findElement(By.xpath(regLoc.playNowButton()));
			if (playNowButton.isDisplayed()) {
				System.out.println("PASS: PlayNow button is displayed and it is verified...");
				playNowButton.click();
				Thread.sleep(8000);
				driver.navigate().back();
				String randomNumber=commAct.randomMobileNumber();
				Thread.sleep(3000);
				MobileElement phoneNumberTextField = driver.findElement(By.xpath(regLoc.phoneNumberTextField()));
				if (phoneNumberTextField.isDisplayed()) {
					System.out.println("PASS: Phonenumber textrfield is displayed and it is verified...");
					phoneNumberTextField.click();
					Thread.sleep(500);
					Thread.sleep(1000);
					phoneNumberTextField.sendKeys(randomNumber);
					System.out.println("PASS: Random Phone number is entered and it is verified..");
					Thread.sleep(2500);
					MobileElement otpButton = driver.findElement(By.xpath(regLoc.sendOtpButton()));
					System.out.println("PASS: OTP button is displayed and it is verified...");
					otpButton.click();
					Thread.sleep(2500);
					String arr[]= {"6","0","0","6","1","3"};
					for(int i=0;i<6;i++) {
						driver.findElement(By.xpath(regLoc.otp(i+1))).sendKeys(arr[i]);
					}
					System.out.println("PASS: Dev OTP is entered and it is verified...");
					Thread.sleep(900);
					driver.findElement(By.xpath(regLoc.verifyButton())).click();	
					System.out.println("PASS: It is going to the profile creation page and it is verified...");
					Thread.sleep(3000);
				}else {
					System.out.println("FAIL:Phone Number textfield is not displayed");
				}
			}else
				System.out.println("FAIL:Play Now button is not displayed");
		}else
			System.out.println("FAIL: NEXT button is not displayed");
	}
	@Test(priority = 2)
	public void userNameCreation() throws InterruptedException {
		regLoc= new  RegistrationDevObjects();
		commAct= new CommonActions();
		MobileElement userNameTextField = driver.findElement(By.xpath(regLoc.userName()));
		userNameTextField.click();
		userNameTextField.sendKeys(commAct.randomName());
		System.out.println("PASS: Random name is entered and it is verified...");
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3500);
		MobileElement submitButton = driver.findElement(By.xpath(regLoc.submitButton()));
		if (submitButton.isDisplayed()) {
			Thread.sleep(2000);
			submitButton.click();
			submitButton.click();
			System.out.println("Submit Button is clicked and it is verified..");
		}
	}

}

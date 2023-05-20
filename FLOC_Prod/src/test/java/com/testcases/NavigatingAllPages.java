package com.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.commonfunctions.BaseClass;
import com.commonfunctions.CommonActions;
import com.pagesobjectsmodel.BottomNavigations;

public class NavigatingAllPages extends BaseClass{
	
	// THIS PROGRAM IS TO TEST THE NAVIGATION OF ALL PAGES IA WORKING OR NOT
	// NOTE: IN PROD TESTING WE HAVE TO TYPE THE OTP MANUALLY.
	
	@Test(priority = 1)
	public void openFeedPage() throws InterruptedException {
		registeredUserID= new RegisteredUserTest();
		navLoc= new BottomNavigations();
		comAct= new CommonActions();
		registeredUserID.userRegistration();
		Thread.sleep(7000);
		for(int i=0;i<3;i++) {
			comAct.scrollDown(driver);
		}
		driver.findElement(By.xpath(navLoc.feedPage())).click();
		Thread.sleep(2500);
		for(int i=0;i<3;i++) {
			comAct.scrollDown(driver);
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath(navLoc.winnersPage())).click();
		Thread.sleep(3000);
		for(int i=0;i<3;i++) {
			comAct.scrollDown(driver);
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath(navLoc.walletsPage())).click();
		Thread.sleep(3000);
		for(int i=0;i<2;i++) {
			comAct.scrollDown(driver);
		}
	}
}

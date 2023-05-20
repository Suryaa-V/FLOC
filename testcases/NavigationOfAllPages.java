package com.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.commonfunctions.BaseClassDev;
import com.commonfunctions.CommonActions;
import com.pompages.FeedPageObjectsDev;
import com.pompages.NavigationDev;

public class NavigationOfAllPages extends BaseClassDev {
	
	@Test(priority = 1)
	public void openFeedPage() throws InterruptedException {
		commAct= new CommonActions();
		registeredUserID= new RegisteredUserLoginTest();
		navLoc= new NavigationDev();
		registeredUserID.userRegistration();
		Thread.sleep(7000);
		driver.findElement(By.xpath(navLoc.feedPage())).click();
		Thread.sleep(2500);
		for(int i=0;i<3;i++) {
			commAct.scrollDown(driver);
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath(navLoc.winnersPage())).click();
		Thread.sleep(3000);
		for(int i=0;i<3;i++) {
			commAct.scrollDown(driver);
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath(navLoc.walletPage())).click();
		Thread.sleep(3000);
		for(int i=0;i<2;i++) {
			commAct.scrollDown(driver);
		}
	}
}

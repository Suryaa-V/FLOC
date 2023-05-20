package com.commonfunctions;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;

import com.pompages.RegistrationDevObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.PointOption;

public class CommonActions extends BaseClassDev {
	public RegistrationDevObjects regLoc;
	public void cutButton() throws InterruptedException {
		Thread.sleep(1000);
		regLoc= new RegistrationDevObjects();
		if (driver.findElement(By.xpath(regLoc.cutButtonDev())).isDisplayed()) {
			driver.findElement(By.xpath(regLoc.cutButtonDev())).click();
			System.out.println("Dev is displayed");
		}else {
			System.out.println("Not displayed Dev");
		}
	}
	public void scrollDown(AppiumDriver<MobileElement> driver) {
        org.openqa.selenium.Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);
        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(LongPressOptions.longPressOptions().withPosition(PointOption.point(startX, startY))
                .withDuration(Duration.ofMillis(500)))
                .moveTo(PointOption.point(startX, endY))
                .release()
                .perform();
    }
	public String randomMobileNumber() throws InterruptedException {
		Thread.sleep(2000);
		 Random random = new Random();
	        StringBuilder sb = new StringBuilder();
	        // Generate the first digit (6, 7, or 9)
	        int firstDigit = random.nextInt(3);
	        sb.append(new int[]{6, 7, 9}[firstDigit]);
	        // Generate the remaining 9 digits
	        for (int i = 0; i < 9; i++) {
	            int digit = random.nextInt(10);
	            sb.append(digit);
	        }
	        return sb.toString();
         
	}
	public String randomName() {
		Random random = new Random();
        StringBuilder sb = new StringBuilder();
        String characters = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < 5; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            sb.append(randomChar);
        }
        return sb.toString();
	}

}

package com.Demo.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Demo.Pages.Login_Page;

public class TC_LoginTest extends BaseClass {

	@Test
	public void loginTest() throws Exception {

		Login_Page lp = new Login_Page(driver);

		lp.setUserName(username);
		logger.info("Entered username");
		lp.setPassword(password);
		logger.info("Entered Password");
		Thread.sleep(3000);
		lp.clickLogin();
		logger.info("Submitted");

		try {
			if (driver.getTitle().equalsIgnoreCase("Guru99 Bank Manager HomePage")) {
				Assert.assertTrue(true);
			} else {

				captureScreen(driver, "TC_LoginTest");
				Assert.assertFalse(false);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}

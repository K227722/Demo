package com.Demo.Test;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.Demo.Utilities.*;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class BaseClass {

	ReadConfig read = new ReadConfig();

	public String baseURL = read.getApplicationURL();
	public String username = read.getApplicationUserName();
	public String password = read.getApplicationpassword();
	public static WebDriver driver;
	public static Logger logger;
	Properties prop;

	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) throws Exception {

		logger = Logger.getLogger("Demo Banking");
		PropertyConfigurator.configure("Log4j.Properties");

		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", read.getChropath());
			driver = new ChromeDriver();
			Thread.sleep(3000);
			driver.get(baseURL);

		} else {
			System.out.println("Open IE Browser");
		}
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public void captureScreen(WebDriver driver, String tname) throws Exception {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshot/" + tname + ".png");
		FileHandler.copy(source, target);
		System.out.println("ScreenShot Captured");
	}
}

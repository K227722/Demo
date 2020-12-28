package com.Demo.Utilities;

import java.io.*;
import java.util.Properties;

public class ReadConfig {

	Properties prop;

	public ReadConfig() {

		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);

			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is" + e.getMessage());

		}

	}

	public String getApplicationURL() {
		String url = prop.getProperty("baseURL");
		return url;
	}

	public String getApplicationUserName() {
		String user = prop.getProperty("username");
		return user;
	}

	public String getApplicationpassword() {
		String pass = prop.getProperty("password");
		return pass;
	}

	public String getChropath() {
		String chromepath = prop.getProperty("chromepath");
		return chromepath;
	}

}

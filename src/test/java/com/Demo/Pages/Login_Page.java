package com.Demo.Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {
	
	WebDriver ldriver;
	
	public Login_Page (WebDriver rdriver){
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
		
		
	}
	

	@FindBy(name="uid")
	WebElement txtuesrname;
	
	@FindBy(name="password")
	WebElement txtpassword;
	
	
	@FindBy(name = "btnLogin")
	WebElement login;
	
	
	public void setUserName(String uname) 
	{
		txtuesrname.sendKeys(uname);
	}
	
	public void setPassword(String pwd) 
	{
		txtpassword.sendKeys(pwd);
	}
	
	public void clickLogin() 
	{
		login.click();
	}
}

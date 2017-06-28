package com.spicejet.util;

import org.openqa.selenium.WebDriver;

public class BrowserDriver {
	
	//public static WebDriver driver;
	public static synchronized WebDriver getCurrentDriver()
	{
//		driver=BrowserFactory.getBrowser();
//		return driver;
		return BrowserFactory.getBrowser();
	}

}

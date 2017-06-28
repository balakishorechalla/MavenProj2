package com.spicejet.util;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.spicejet.constants.Browsers;
import com.spicejet.constants.CukeConstants.TestData;

public class BrowserFactory {
	
	static String iePath;
	static String chromePath;
	static String ffPath;
	static String browserKey;
	public static Browsers browser;
	public static WebDriver driver;
	
	public static WebDriver getBrowser()
	{
		browserKey=TestData.BROWSERNAME;
		System.out.println("The browser key is "+browserKey);
		if(browserKey==null)
		{
			browser=Browsers.FF;
		}
		browser=Browsers.browserForName(browserKey);
		switch(browser)
		{
		case FF:
			driver= initiateFirefox();
			break;
		case CH:
			driver=initiateChrome();
			break;
		case IE:
			driver=initiateInternetExplorer();
			break;
			
			default:
				System.out.println("Please give the correct browser name");
			
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(250,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		return driver;
		
	}
	
	public static WebDriver initiateInternetExplorer()
	{
		iePath=TestData.IEPATH;
		File f=new File(iePath);
		DesiredCapabilities capabilities=DesiredCapabilities.internetExplorer();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "IE");
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		System.setProperty("webdriver.ie.driver",f.getAbsolutePath());
		return new InternetExplorerDriver(capabilities);
	}
	
	public static WebDriver initiateChrome()
	{
		chromePath=TestData.CHROME;
		System.out.println("The path is "+chromePath);
		File f=new File(chromePath);
		ChromeOptions options=new ChromeOptions();
		DesiredCapabilities capabilities=DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		System.setProperty("webdriver.chrome.driver",f.getAbsolutePath());
		return new ChromeDriver(capabilities);
	}
	
	public static WebDriver initiateFirefox()
	{
		//FirefoxProfile profile=new FirefoxProfile();
		//return new FirefoxDriver(profile);
		ffPath=TestData.FF;
		File f=new File(ffPath);
		System.setProperty("webdriver.gecko.driver", f.getAbsolutePath());
		DesiredCapabilities capabilities=DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		return new FirefoxDriver(capabilities);
	}

}

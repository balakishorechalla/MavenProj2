package com.spicejet.constants;

import java.io.FileInputStream;
import java.util.Properties;

public class CukeConstants {
	
	public static Properties testDataProps;
	
	
	static
	{
		try
		{
		testDataProps=new Properties();
		testDataProps.load(new FileInputStream("src\\test\\resources\\testdata.properties"));
		}catch(Exception e)
		{
			System.out.println("Give the correct path of the property file");
		}
	}
	
	public interface TestData
	{
		String BROWSERNAME=System.getProperty("Browser");
		String SCREENSHOTVALUE=System.getProperty("ScreenShotVal");
		String IEPATH=(String) testDataProps.get("IEPATH");
		String CHROME=(String) testDataProps.get("CHROMEPATH");
		String FF=(String) testDataProps.get("FFPATH");
		String XLFILEPATH=testDataProps.getProperty("xlfilePath");
		String HTMLPATH=testDataProps.getProperty("htmlFilePath");
		
	}
	
	public static void main(String args[])
	{
		System.out.println("The path is "+TestData.CHROME);
	}

}

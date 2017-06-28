package com.spicejet.util;

import java.io.File;
import java.util.List;

import org.junit.runner.Description;

import com.spicejet.constants.CukeConstants.TestData;

public class CreateFolders {
	public static Xls_Reader xls;
	public static int rowNum=1;
	
	private static File classFolder;
	public static File methodFolder;
	static
	{
		System.out.println("hi this is static block");
		xls=new Xls_Reader(TestData.XLFILEPATH);
	}
	
	public static void getTestDetails(final Description description)
	{
		/*System.setProperty("path", "D:\\JUnitHybridFW\\JUnitFWHybrid\\Screenshots\\"+methodName);
		System.out.println("****************"+System.getProperty("path"));
		File directory=new File(System.getProperty("path"));
		
		//File directory=new File("D:\\JUnitHybridFW\\JUnitFWHybrid\\Screenshots\\"+methodName);
		if(!directory.exists())
		{
			if(directory.mkdir())
			{
				System.out.println("Directory created");
			}
			else
			{
				System.out.println("Failed to create directory");
			}
		}*/
		
		
		System.out.println("The class name is "+description.getClassName());
		System.out.println("The test method name is "+description.getMethodName());
		String[] classNames=description.getClassName().replace('.', ' ').split(" ");
		System.out.println("The actual class name is "+classNames[classNames.length-1]);
		
		createClassFolder(classNames[classNames.length-1]);
		createMethodFolder(description.getMethodName());
		
		/*if(!classNames[classNames.length-1].trim().equalsIgnoreCase("ZyxTest"))
		{
		createClassFolder(classNames[classNames.length-1]);
		createMethodFolder(description.getMethodName());
		}*/
		/*String className=description.getClassName();
		System.out.println("cls name "+className);
		//System.out.println("The class name after splitting "+dotNames[dotNames.length-1]);
		System.out.println("The size is "+className.replace('.', ' ').split(" ").length);*/
		
		
	}
	
	public static void createClassFolder(String className)
	{
		//System.setProperty("path", "D:\\JUnitHybridFW\\JUnitFWHybrid\\Screenshots\\"+className);
		/*System.setProperty("path", "D:/JUnitHybridFW/JUnitFWHybrid/Screenshots/"+className);
		System.out.println("class folder path ********"+System.getProperty("path"));
		File classDir=new File(System.getProperty("path"));
		if(!classDir.exists())
		{
			if(classDir.mkdir())
			{
				System.out.println("The class folder created");
				
			}
			else
			{
				System.out.println("Failed to create class folder");
			}
		}
		else
		{
			System.out.println("The class folder already created");
		}*/
		
		classFolder=new File("Screenshots/"+className);
		if(!classFolder.exists())
		{
			classFolder.mkdir();
			System.out.println("The class folder "+className+" is created");
		}
		else
		{
			System.out.println("Class folder is already created");
		}
		
	}
	
	public static void createMethodFolder(String methodName)
	{
		//System.setProperty("path", System.getProperty("path")+"\\"+methodName);
		/*System.setProperty("path", System.getProperty("path")+"/"+methodName);
		System.out.println("The method folder is ************"+System.getProperty("path"));
		++rowNum;
		System.out.println("The row number is ****"+rowNum);
		xls.setCellData("TestDetails", "Scenario Name", rowNum, methodName);
		xls.setCellData("TestDetails", "Result", rowNum, "pass");
		xls.setCellData("TestDetails", "Folder Location", rowNum, System.getProperty("path"));
		
		File methodDir=new File(System.getProperty("path"));
		if(!methodDir.exists())
		{
			if(methodDir.mkdir())
			{
				System.out.println("The method folder created");
				
			}
			else
			{
				System.out.println("Failed to create method folder");
			}
		}
		else
		{
			System.out.println("The method folder already created");
		}*/
		
		methodFolder=new File(classFolder,methodName);
		if(!methodFolder.exists())
		{
			methodFolder.mkdir();
			System.out.println("The method folder is "+methodName+" is created");
		}
		else
		{
			System.out.println("The method folder"+methodName+" is already created");
		}
	}

}

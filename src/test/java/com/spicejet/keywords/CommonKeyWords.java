package com.spicejet.keywords;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.rules.TestName;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.spicejet.constants.CukeConstants;
import com.spicejet.constants.CukeConstants.TestData;
import com.spicejet.constants.Keyss;
import com.spicejet.util.BrowserDriver;
import com.spicejet.util.CreateFolders;

public class CommonKeyWords {
	static WebDriver driver;
	// WebDriver driver;

	static String pkg;
	public static Object currentObject;
	static Class pageObject;
	static int time=30;
	static boolean flag=true;
	static TestName tn;
	
	@Before
	public static void launchbrowser()
	{
	    CommonKeyWords.driver=BrowserDriver.getCurrentDriver();
	  //  driver=BrowserDriver.getCurrentDriver();

		System.out.println("Hi this is bala kishore");
	}
	
	/*public static void getMethodName()
	{
		tn=new TestName();
		System.out.println("The test method name is "+tn.getMethodName());
	}*/
	
	public static void onThePage(String page) throws Throwable
	{
		page=page.replaceAll(" ","")+"Page";
		System.out.println("The page name is "+page);
		if(TestData.SCREENSHOTVALUE.toLowerCase().matches("y"))
		{
			Thread.sleep(1500);
			takeScreenshot1(page);
		}
		else
		{
			System.out.println("Screenshots are not taking");
		}
		pkg=PackageInfo.getPackageName(page);
		pkg=pkg+"."+page;
		currentObject=PageFactory.initElements(CommonKeyWords.driver, Class.forName(pkg));
		initializeClass();
		/*tn=new TestName();
		System.out.println("The test method name is "+tn.getMethodName());*/
		
	}
	public static void initializeClass() throws ClassNotFoundException
	{
		pageObject=Class.forName(pkg);
		System.out.println("The current page object is "+pageObject.getName());
	}
	
	public static String getPageUrl(String page)
	{
		System.out.println("The property name is"+page+".url");
		return (String) CukeConstants.testDataProps.get(page+".url");
	}
	
	public static void loadPage(String url)
	{
		System.out.println("The url name is "+url);
		driver.get(url);
	}
	public static void navigateToThePage(String page)
	{
		loadPage(getPageUrl(page));
	}

	public static void quitBrowser()
	{
		//System.out.println("Calling quit method");
		System.out.println("before quit");
		CommonKeyWords.driver.quit();
		System.out.println("after quit");
	}
	
	public static WebElement getElement(String elementNm) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{
		elementNm=elementNm.substring(0,1).toLowerCase()+elementNm.substring(1);
		System.out.println("The current class name is "+pageObject.getName());
		Field f=pageObject.getField(elementNm);
		System.out.println("The element name is "+f);
		f.setAccessible(true);
		WebElement webElement=(WebElement) f.get(elementNm);
		return webElement;
	}
	
	public static void verifyBackgroundColor(String expectedColor,String elementNm) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{
		WebElement webElement=getElement(elementNm);
		elementWait_untilVisible(webElement);
		/*System.out.println("background color "+webElement.getAttribute("background"));
		System.out.println("Style of the element "+webElement.getAttribute("style"));
		System.out.println("background-color is "+webElement.getAttribute("background-color"));
		System.out.println("The css style is "+webElement.getCssValue("style"));
		System.out.println("The css color is "+webElement.getCssValue("color"));*/
		
		//System.out.println("The css color is "+webElement.getCssValue("background-color"));
		String actualColor=webElement.getCssValue("background-color").trim();
		Assert.assertEquals("The expected color is :"+expectedColor+" Actual color is :"+actualColor, expectedColor, actualColor);
		System.out.println("The expected color is :"+expectedColor+" Actual color is :"+actualColor);
		
	}
	
	public static void elementWait_untilVisible(WebElement webElement) throws  SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException
	{
		//WebElement webElement=getElement(elementNm);
		
		try
		{
			WebDriverWait wait=new WebDriverWait(CommonKeyWords.driver,time);
			wait.until(ExpectedConditions.visibilityOf(webElement));
		}catch(Exception e)
		{
			System.out.println("The webelement "+webElement+" not present");
		}
		
	}
	
	public static void elementWait_untilClickable(WebElement webElement) throws  SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException
	{
		//WebElement webElement=getElement(elementNm);
		
		try
		{
			WebDriverWait wait=new WebDriverWait(CommonKeyWords.driver,time);
			wait.until(ExpectedConditions.elementToBeClickable(webElement));
		}catch(Exception e)
		{
			System.out.println("The webelement "+webElement+" not present");
		}
		
	}
	
	public static void takeScreenshot1(String pageName) throws IOException
	{
		File screenShotFile=((TakesScreenshot)CommonKeyWords.driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(screenShotFile, new File(System.getProperty("path")+"\\"+pageName+".png"));
		
		FileUtils.copyFile(screenShotFile, new File(CreateFolders.methodFolder.getAbsolutePath()+"\\"+pageName+".png"));
	}
	
	public static void takeScreenshot(String methodName) throws Throwable
	{
		File dir=new File("D:\\JUnitHybridFW\\JUnitFWHybrid\\Screenshots\\"+methodName);
		if(!dir.exists())
		{
			if(dir.mkdir())
			{
				System.out.println("Directory is created");
			}
			else
			{
				System.out.println("failed to create directory");
			}
		}
	//	Thread.sleep(5000);
		File f=((TakesScreenshot)CommonKeyWords.driver).getScreenshotAs(OutputType.FILE);
		BufferedImage image=ImageIO.read(f);
		Graphics g=image.getGraphics();
		String text=" ";
		g.setColor(Color.red);
		g.setFont(g.getFont().deriveFont(30f));
		g.drawString("This is filed test case image", 200, 600);
		g.dispose();
		ImageIO.write(image, "png", new File(dir.getAbsolutePath()+"\\failed.png"));
	//	FileUtils.copyFile(f, new File(dir.getAbsolutePath()+"\\failed.png"));
		System.out.println("taken***************");
		

		
		
	}
	
	public static void verifyWebEleDisp(String elementNm) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{
		WebElement webElement=getElement(elementNm);
		elementWait_untilVisible(webElement);
		Assert.assertEquals("Expected :True but actual is",true, webElement.isDisplayed());
		System.out.println("webelement "+elementNm+" present");
	}
	
	public static void verifyWebEleNotDisp(String elementNm) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{
		WebElement webElement=getElement(elementNm);
		//elementWait_untilVisible(webElement);
		Assert.assertEquals(false, webElement.isDisplayed());
		System.out.println("webelement "+elementNm+" not present");
	}
	public static void verifyChkBoxStatus(String elementNm,String elementState)throws Throwable
	{
		WebElement webElement=getElement(elementNm);
		if(elementState.toLowerCase().equals("checked"))
		{
			Assert.assertTrue(webElement.isSelected());
		}
		else if(elementState.toLowerCase().equals("un checked"))
		{
			Assert.assertFalse(webElement.isSelected());
		}
	}
	
	public static void verifyRadioStatus(String elementNm,String elementValue,String elementState)throws Throwable
	{
		WebElement webElement=getElementFromGroup(elementNm,elementValue);
		if(elementState.toLowerCase().equals("selected"))
		{
			Assert.assertTrue(webElement.isSelected());
		}
		else if(elementState.toLowerCase().equals("not selected"))
		{
			Assert.assertFalse(webElement.isSelected());
		}
		
	}
	public static void verifyRadioBtnEnablOrNot(String elementNm,String elementValue,String elementState)throws Throwable
	{
		WebElement webElement=getElementFromGroup(elementNm,elementValue);
		if(elementState.toLowerCase().equals("enable"))
		{
			Assert.assertTrue(webElement.isEnabled());
		}
		else if(elementState.toLowerCase().equals("not enable"))
		{
			Assert.assertFalse(webElement.isEnabled());
		}
	}
	
	public static void verifyThatTxtDisp(String expectedValue)
	{
		String xpath="";
		xpath="//*[contains(text(),'"+expectedValue+"')]";
		WebElement webElement=driver.findElement(By.xpath(xpath));
		String actualVal=webElement.getText();
		Assert.assertTrue(actualVal.contains(expectedValue));
	}
	
	public static void verifyThatTxtNotDisp(String expectedValue)
	{
		String xpath="";
		xpath="//*[contains(text(),'"+expectedValue+"')]";
		WebElement webElement=driver.findElement(By.xpath(xpath));
		String actualVal=webElement.getText();
		Assert.assertFalse(actualVal.contains(expectedValue));
	}
	
	public static void verifyPageTitle(String expectedTitle)
	{
		String actualTitle=driver.getTitle();
		Assert.assertEquals("Expected title is "+expectedTitle+" but actual title is "+actualTitle,expectedTitle,actualTitle);
		System.out.println("Expected title is "+expectedTitle+" and actual title is "+actualTitle);
	}
	
	public static void verifyWebEleTxt(String elementNm,String expectedTxt)throws Throwable
	{
		WebElement webElement=getElement(elementNm);
		String actualTxt="";
		actualTxt=webElement.getText();
		try
		{
			Assert.assertEquals(expectedTxt,actualTxt);;
		}catch(Throwable e)
		{
			try
			{
				actualTxt=webElement.getAttribute("value");
				Assert.assertEquals("Expected value is "+expectedTxt+" and actual value is "+actualTxt,expectedTxt,actualTxt);;
				//System.out.println("Expected value is "+expectedTxt+" and actual value is "+actualTxt);
				
			}catch(Exception x)
			{
				System.out.println("please check the expected value "+expectedTxt);
			}
		}
		System.out.println("Expected value is "+expectedTxt+" and actual value is "+actualTxt);
		
	}
	
	public static void verifyDDValSelOrNot(String elementNm,String elementVal,String elementState)throws Throwable
	{
		WebElement webElement=getElement(elementNm);
		Select s=new Select(webElement);
		webElement=s.getFirstSelectedOption();
		
		if(elementState.toLowerCase().equals("selected"))
		{
			Assert.assertEquals("The expected value to be select "+elementVal+" but selected actual value is "+webElement.getText(), elementVal,webElement.getText());
			System.out.println("The expected value is "+elementVal+" and actual value is "+webElement.getText());
		}
		else if(elementState.toLowerCase().equals("not selected"))
		{
			Assert.assertNotEquals("The expected value not be selected is "+elementVal+" but actual value selected is "+webElement.getText(), elementVal,webElement.getText());
			System.out.println("The expected value not to be selected  is "+elementVal+" and actual value selected is "+webElement.getText());
		    
		}
	}
	
	public static void verifyDDValContainsOrNot(String elementNm,String elementValue,String elementState)throws Throwable
	{
		WebElement webElement=getElement(elementNm);
		boolean exist=false;
		List<String> arrayList = new ArrayList();
		Select option=new Select(webElement);
		List<WebElement> webElements=option.getOptions();
		/*for(WebElement webelement:webElements)
		{
			System.out.println(webelement.getText());
		}*/
		int i=0;
		for(WebElement webelement:webElements)
		{
			//System.out.println("The val is "+webelement.getText());
			arrayList.add(webelement.getText().trim());
		}
		int size=arrayList.size();
		if(elementState.equalsIgnoreCase("contains"))
		{
			for(String val:arrayList)
			{
				if(val.equalsIgnoreCase(elementValue))
				{
					exist=true;
					break;
				}
			}
		}
		
		else if(elementState.equalsIgnoreCase("not contains"))
		{
			for(i=0;i<arrayList.size();i++)
			{
				if(!arrayList.get(i).equalsIgnoreCase(elementValue))
				{
					if(i==size-1)
					{
						exist=true;
						break;
					}
				}
			}
		}
		
		if(elementState.equalsIgnoreCase("contains"))
		{
			if(exist==true)
			{
				//Assert.assertTrue(true);
				Assert.assertEquals("Expected :true but actual is :"+exist, true,exist);
				System.out.println("The dropdwon list contains the value "+elementValue);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		else if(elementState.equalsIgnoreCase("not contains"))
		{
			if(exist==true)
			{
				//Assert.assertTrue(true);
				Assert.assertEquals("Expected :true but actual is :"+exist, true,exist);
				System.out.println("The dropdwon list does not contains value "+elementValue);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
	}
	
	//select statements
	
	public static void selectDropDownValByIndex(String index,String elementNm)throws Throwable
	{
		WebElement webElement=getElement(elementNm);
		new Select(webElement).selectByIndex(Integer.parseInt(index));
	}
	
	public static void selectDropDownValue(String value,String elementNm)throws Throwable
	{
		WebElement webElement=getElement(elementNm);
		try
		{
			new Select(webElement).selectByVisibleText(value);
		}catch(Exception e)
		
		{
			try
			{
				new Select(webElement).selectByValue(value);
			}catch(Exception x)
			{
				System.out.println("Please the check the drop down value "+value);
			}
		}
	}
	
	public static void selectRadioBtn(String elementNm,String value)throws Throwable
	{
		WebElement webElement=getElementFromGroup(elementNm, value);
		webElement.click();
		Thread.sleep(5000);
	}
	
	public static void checkOrUncheck(String elementNm,String elementState)throws Throwable
	{
		WebElement webElement=getElement(elementNm);
		if(elementState.equalsIgnoreCase("check"))
		{
			if(webElement.isSelected())
			{
				System.out.println("The checkbox already checked");
			}
			else
			{
				webElement.click();
			}
		}
		else if(elementState.equalsIgnoreCase("uncheck"))
		{
			if(webElement.isSelected())
			{
				webElement.click();
			}
			else
			{
				System.out.println("The checkbox is already unchecked");
			}
		}
	}
	
	public static void enterText(String elementNm,String text)throws Throwable
	{
		WebElement webElement=getElement(elementNm);
		webElement.sendKeys(text);
		
	}
	public static void clickAlert(String value)
	{
		Alert alert=driver.switchTo().alert();
		if(value.equalsIgnoreCase("ok"))
		{
			alert.accept();
		}
		else if(value.equalsIgnoreCase("cancel"))
		{
			alert.dismiss();
		}
	}
	
	public static void verifyAlert(String alertValue)
	{
		Alert alert=driver.switchTo().alert();
		Assert.assertTrue(alert.getText().contains(alertValue));
	}
	public static void enterTxtIntoAlert(String text)
	{
		Alert alert=driver.switchTo().alert();
		alert.sendKeys(text);
	}
	public static void enterKey(String keyNm,String elementNm)throws Throwable
	{
		WebElement webElement=getElement(elementNm);
		//keyNm=keyNm.toUpperCase();
		Keyss key=Keyss.keyForName(keyNm);
		switch(key)
		{
		
		case ENTER:
			webElement.sendKeys(Keys.ENTER);
			break;
		case TAB:
			webElement.sendKeys(Keys.TAB);
			break;
		//we can add the keys latter
			default:
				System.out.println("please enter valid key");
			
		}
		
	}
	public static void mouseOver(String elementNm)throws Throwable
	{
		WebElement webElement=getElement(elementNm);
		Actions act=new Actions(driver);
		act.moveToElement(webElement).build().perform();
	}
	public static void verifyListOrder(String elementNm,String order)throws Throwable
	{
		WebElement webElement=getElement(elementNm);
		Select option=new Select(webElement);
		List<String> arrayList=new ArrayList();
		List<WebElement> webElements=option.getOptions();
		String status="";
		for(WebElement webelement:webElements)
		{
			arrayList.add(webelement.getText().trim());
		}
		for(int i=0;i<arrayList.size();i++)
			System.out.println(arrayList.get(i));
		//int i=0;
		if(order.equalsIgnoreCase("Ascending"))
		{
			for(int i=0;i<arrayList.size();i++)
			{
				if(arrayList.get(i).compareToIgnoreCase(arrayList.get(i+1))>1)
				{
					status="Ascending order";
					System.out.println("verified");
				}
				else
				{
					status="not ascending order";
					Assert.assertEquals("Expected :"+order+" but actual is "+status, "Ascending order",status);
					break;
				}
			}
		}
		else if(order.equalsIgnoreCase("Descending"))
		{
			for(int i=0;i<arrayList.size();i++)
			{
				if(arrayList.get(i).compareToIgnoreCase(arrayList.get(i+1))<1)
				{
					status="descending order";
				}
				else
				{
					status="not descending order";
					Assert.assertEquals("Expected :"+order+" but actual is "+status, "descending order",status);
					break;
				}
			}
		}
		
		System.out.println("The dropdown list is in "+status);
		
	}
	
		@SuppressWarnings("finally")
	public static WebElement getElementFromGroup(String elementNm,String elementValue)throws Throwable
	{
		String xpath="";
		WebElement webElement=null;
		WebElement webElements=getElement(elementNm);
		xpath="//*[@value='"+elementValue+"']";
		System.out.println("The xpath is "+xpath);
		try
		{
			webElement=webElements.findElement(By.xpath(xpath));
			//elementWait_untilClickable(webElement);
			return webElement;
		}catch(Exception x)
		{
			System.out.println("Element not found using @value attribute");
			try
			{
				xpath="//*[contains(text(),'"+elementValue+"')]";
				//*[contains(text(),'here')]
				System.out.println("The xpath is "+xpath);
				webElement=webElements.findElement(By.xpath(xpath));
				//elementWait_untilClickable(webElement);
				return webElement;
				
			}catch(Exception y)
			{
				System.out.println("element not found please check the value "+elementValue);
			}
		}
		finally
		{
			return webElement;
		}
	}
	
	public static void callPass()
	{
		if(flag==true)
		{
			System.out.println("The test case is passed");
			CommonKeyWords.quitBrowser();
			System.out.println("Closing browser at pass end");
		}
		else
		{
			flag=true;
			System.out.println("The flag value changed to false");
		}
		
	}
	public static void callFalse()
	{
		flag=false;
		System.out.println("The test was failed");
		CommonKeyWords.quitBrowser();
	}
	
	
}

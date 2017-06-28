package com.spicejet.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.TestName;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;

import com.spicejet.interfaces.RegressionTests;
import com.spicejet.interfaces.SmokeTests;
import com.spicejet.keywords.CommonKeyWords;
import com.spicejet.util.OutputFolder;


@RunWith(CustomBlockJUnit4ClassRunner.class)
public class SpiceTwoTest {
	
	@Rule
	public OutputFolder outputFolder=new OutputFolder();
	
	
	@Before
	public void start() throws ClassNotFoundException
	{
		System.out.println("start of spiceone test class");
		CommonKeyWords.launchbrowser();
		//CommonKeyWords.getMethodName();
	}	
	//@Category(SmokeTests.class)
	@Test
	public void checkverifyDDValContainsOrNot() throws Throwable
	{
		//methodName=tn.getMethodName();
		CommonKeyWords.navigateToThePage("matrimony");
		CommonKeyWords.onThePage("MatrimonyHome");
		CommonKeyWords.selectDropDownValByIndex("3","profileLst");
		Thread.sleep(5000);
	}	
	//@Category(SmokeTests.class)
	@Test
	public void checkselectDropDownValue() throws Throwable
	{
		CommonKeyWords.navigateToThePage("matrimony");
		CommonKeyWords.onThePage("MatrimonyHome");
		CommonKeyWords.selectDropDownValue("Friend","profileLst");
		Thread.sleep(5000);
	}
	//@Category(SmokeTests.class)
	@Test
	public void checkselectRadioBtn() throws Throwable
	{
		CommonKeyWords.navigateToThePage("fb");
		CommonKeyWords.onThePage("FBhome");
		CommonKeyWords.selectRadioBtn("gender","Male");
		Thread.sleep(5000);
	}	
	
	//@Category(SmokeTests.class)
	@Test
	public void checkcheckOrUncheck() throws Throwable
	{
		CommonKeyWords.navigateToThePage("matrimony");
		CommonKeyWords.onThePage("MatrimonyHome");
		CommonKeyWords.checkOrUncheck("chkBox","uncheck");
		Thread.sleep(5000);
	}
//	@Category(SmokeTests.class)
	@Test
	public void checkenterText() throws Throwable
	{
		CommonKeyWords.navigateToThePage("matrimony");
		CommonKeyWords.onThePage("MatrimonyHome");
		CommonKeyWords.enterText("nameTxt","BalaKishore");
		Thread.sleep(5000);
	}	
	
	@Category(SmokeTests.class)
	@Test
	public void checkenterKey() throws Throwable
	{
		//System.out.println("The test method name is "+tn.getMethodName());
		CommonKeyWords.navigateToThePage("fb");
		CommonKeyWords.onThePage("FBhome");
		CommonKeyWords.enterKey("tab","userNameTxt");
		Thread.sleep(5000);
	}
	
	@Category(SmokeTests.class)
	@Test
	public static void checkmouseOver() throws Throwable
	{
		//System.out.println("The test method name is "+tn.getMethodName());
		CommonKeyWords.navigateToThePage("fb");
		CommonKeyWords.onThePage("FBhome");
		CommonKeyWords.mouseOver("submitBtn");
		Thread.sleep(5000);
	}	

	@Category(SmokeTests.class)
	@Test
	public void checkverifyListOrder() throws Throwable
	{
		CommonKeyWords.navigateToThePage("matrimony");
		CommonKeyWords.onThePage("MatrimonyHome");
		CommonKeyWords.verifyListOrder("profileLst","Ascending");
		Thread.sleep(5000);
	}	
	

/*	@After
	public void end()
	{
		System.out.println("end of test one class");
		CommonKeyWords.quitBrowser();
	}*/


}

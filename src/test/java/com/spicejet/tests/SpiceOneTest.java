package com.spicejet.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import com.spicejet.interfaces.RegressionTests;
import com.spicejet.keywords.CommonKeyWords;
import com.spicejet.util.OutputFolder;

//The class name should end with Test and test method should not be static

@RunWith(CustomBlockJUnit4ClassRunner.class)
public class SpiceOneTest {
	
	@Rule
	public OutputFolder outputFolder=new OutputFolder();
	
	@Before
	public void start() throws ClassNotFoundException
	{
		System.out.println("start of spiceone test class");
		CommonKeyWords.launchbrowser();
		/*CommonKeyWords.navigateToThePage("spicejet");
		CommonKeyWords.onThePage("SpicejetHome");*/
	}
	
	//@Category(RegressionTests.class)
	@Test
	public void verifyColor() throws Throwable
	{
		System.out.println("verifyColor inner method ");
		CommonKeyWords.navigateToThePage("spicejet");
		CommonKeyWords.onThePage("SpicejetHome");
		CommonKeyWords.verifyBackgroundColor("transparent", "findFlightsBtn");
	}
	
	//@Category(RegressionTests.class)
	@Test
	public void verifyElements() throws Throwable
	{
		CommonKeyWords.navigateToThePage("spicejet");
		CommonKeyWords.onThePage("SpicejetHome");
		CommonKeyWords.verifyWebEleDisp("roundTripRadio");
		CommonKeyWords.verifyWebEleDisp("oneWayRadio");
		
	}
	
	@Category(RegressionTests.class)
	@Test
	public void elementBGColor() throws Throwable
	{
		CommonKeyWords.navigateToThePage("matrimony");
		Thread.sleep(8000);
		CommonKeyWords.onThePage("MatrimonyHome");
		CommonKeyWords.verifyBackgroundColor("transparent", "submitBtn");
	}
	
	//@Category(RegressionTests.class)
	@Test
	public void verifyElementDisplayed() throws Throwable
	{
		CommonKeyWords.navigateToThePage("matrimony");
		CommonKeyWords.onThePage("MatrimonyHome");
		CommonKeyWords.verifyWebEleDisp("nameTxt");
		
	}
	//@Category(RegressionTests.class)
	@Test
	public void verifyElementNotDisplayed() throws Throwable
	{
		CommonKeyWords.navigateToThePage("matrimony");
		CommonKeyWords.onThePage("MatrimonyHome");
		CommonKeyWords.verifyWebEleNotDisp("nameTxt");
		
	}
	
	//@Category(RegressionTests.class)
	@Test
	public void verifyChkBox() throws Throwable
	{
		CommonKeyWords.navigateToThePage("matrimony");
		CommonKeyWords.onThePage("MatrimonyHome");
		CommonKeyWords.verifyChkBoxStatus("chkBox", "checked");
		
	}
	
	//@Category(RegressionTests.class)
	@Test
	public void verifyRadioBtnNotSelected() throws Throwable
	{
		CommonKeyWords.navigateToThePage("fb");
		CommonKeyWords.onThePage("FBhome");
		CommonKeyWords.verifyWebEleDisp("gender");
		CommonKeyWords.verifyRadioStatus("gender", "Male","not selected");
	}
	
	//@Category(RegressionTests.class)
	@Test
	public void checkVerifyRadioBtnEnablOrNot() throws Throwable
	{
		CommonKeyWords.navigateToThePage("fb");
		CommonKeyWords.onThePage("FBhome");
		CommonKeyWords.verifyWebEleDisp("gender");
		CommonKeyWords.verifyRadioBtnEnablOrNot("gender", "Male","enable");
	}
	
	//@Category(RegressionTests.class)
	@Test
	public void checkVerifyTxtDisplay() throws Throwable
	{
		CommonKeyWords.navigateToThePage("fb");
		CommonKeyWords.onThePage("FBhome");
		CommonKeyWords.verifyThatTxtDisp("Create a new account");
	}
	
	//@Category(RegressionTests.class)
	@Test
	public void checkVerifyTxtNotDisplay() throws Throwable
	{
		CommonKeyWords.navigateToThePage("fb");
		CommonKeyWords.onThePage("FBhome");
		CommonKeyWords.verifyThatTxtNotDisp("Create a new account");
	}
	
	//@Category(RegressionTests.class)
	@Test
	public void checkverifyPageTitle() throws Throwable
	{
		CommonKeyWords.navigateToThePage("fb");
		CommonKeyWords.onThePage("FBhome");
		CommonKeyWords.verifyPageTitle("Facebook - Log In or Sign Up");
	}
	
	//@Category(RegressionTests.class)
	@Test
	public void checkverifyWebEleTxt() throws Throwable
	{
		CommonKeyWords.navigateToThePage("fb");
		CommonKeyWords.onThePage("FBhome");
		CommonKeyWords.verifyWebEleTxt("submitBtn", "Log In");
	}
	
	@Category(RegressionTests.class)
	@Test
	public void checkverifyDDValSelOrNot123() throws Throwable
	{
		CommonKeyWords.navigateToThePage("matrimony");
		CommonKeyWords.onThePage("MatrimonyHome");
		//CommonKeyWords.verifyDDValSelOrNot("profileLst", "Select Matrimony Profile for", "not selected");
		CommonKeyWords.verifyDDValSelOrNot("profileLst", "Select Matrimony Profile", "not selected");
	}
	
	//@Category(RegressionTests.class)
	@Test
	public void checkselectDropDownIndex() throws Throwable
	{
		CommonKeyWords.navigateToThePage("matrimony");
		CommonKeyWords.onThePage("MatrimonyHome");
		//CommonKeyWords.verifyDDValSelOrNot("profileLst", "Select Matrimony Profile for", "not selected");
		CommonKeyWords.selectDropDownValByIndex("1","profileLst");
	}


	
	@After
	public void end()
	{
		System.out.println("end of test one class");
		CommonKeyWords.quitBrowser();
	}

}

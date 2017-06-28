package com.matrimony.first;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MatrimonyHomePage {
	
	@FindBy(how=How.XPATH ,using=".//input[@type='submit']")
	public static WebElement submitBtn;
	
	@FindBy(how=How.ID,using="NAME")
	public static WebElement nameTxt;
	
	@FindBy(how=How.ID,using="NAME1")
	public static WebElement nameTxt1;
	
	@FindBy(how=How.ID,using="TERMS")
	public static WebElement chkBox;
	
	@FindBy(how=How.XPATH ,using="//*[contains(text(),'Gender')]")
	public static WebElement gender;
	
	@FindBy(how=How.ID,using="REGISTERED_BY")
	public static WebElement profileLst;
	
	//xpath="//*[contains(text(),'"+elementValue+"')]";

}

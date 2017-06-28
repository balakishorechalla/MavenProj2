package com.facebook.home;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FBhomePage {
	
	@FindBy(how=How.XPATH ,using="//*[contains(text(),'Birthday')]")
	public static WebElement gender;
	
	@FindBy(how=How.ID ,using="u_0_t")
	public static WebElement submitBtn;
	
	@FindBy(how=How.ID ,using="email")
	public static WebElement userNameTxt;

}

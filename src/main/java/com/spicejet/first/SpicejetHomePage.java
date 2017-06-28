package com.spicejet.first;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SpicejetHomePage {
	
	@FindBy(how=How.ID,using="ctl00_mainContent_btn_FindFlights")
	public static WebElement findFlightsBtn;
	
	@FindBy(how=How.ID,using="ctl00_mainContent_rbtnl_Trip_0")
	public static WebElement roundTripRadio;
	
	@FindBy(how=How.ID,using="ctl00_mainContent_rbtnl_Trip_1")
	public static WebElement oneWayRadio;
	
	
	
	
	
	
	

}

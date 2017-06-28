/*package com.spicejet.tests;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import com.spicejet.constants.Initialize;
import com.spicejet.interfaces.SmokeTests;
import com.spicejet.keywords.CommonKeyWords;

@RunWith(CustomBlockJUnit4ClassRunner.class)
public class ABCTest {
	@Before
	public void start()
	{
		CommonKeyWords.launchbrowser();
		Initialize it=new Initialize();
		it.initiate();
	}
	
	@Category(SmokeTests.class)
	@Test
	public void abcinitialize() throws Throwable
	{
		Initialize it=new Initialize();
		it.initiate();
		System.out.println("map initiated");
		Thread.sleep(2000);
	}

}
*/
package com.spicejet.tests;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import com.spicejet.html.CreateHtmlFile;
import com.spicejet.interfaces.RegressionTests;
import com.spicejet.interfaces.SmokeTests;
import com.spicejet.util.OutputFolder;

@RunWith(CustomBlockJUnit4ClassRunner.class)
public class ZyxTest {

	@Rule
	public OutputFolder outputFolder=new OutputFolder();
	
	@Before
	public void start()
	{
		System.out.println("starting");
	}
	
	@Category(RegressionTests.class)
		@Test
		public void zTest() throws IOException
		{
			System.out.println("This is last method");

			CreateHtmlFile chf=new CreateHtmlFile();
			chf.createReport();
		}
	@After
	public void last()
	{
		System.out.println("This is last statement");
	}
}

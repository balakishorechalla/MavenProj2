package com.spicejet.tests;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;



@RunWith(value=Parameterized.class)
public class TestRunnerTest {
	private int number;
	private boolean flag;

	public static Collection primeNumbers() {
		return Arrays.asList(new Object[][] 
				{ { 2, true }, { 6, false }, { 8, false }, { 3, true }, { 11, true } });
	}
	
	// Each parameter should be placed as an argument here
	// Every time runner triggers, it will pass the arguments
	public TestRunnerTest(int number,boolean flag)
	{
		this.number=number;
		this.flag=flag;
	}
	
	@Test
	public void testPrimeNumber()
	{
		System.out.println("The number is "+number);
		Assert.assertEquals(true, flag);
	}

}

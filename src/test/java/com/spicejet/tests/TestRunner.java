package com.spicejet.tests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class TestRunner {
	
	public static void main(String args[])
	{
		Result result=JUnitCore.runClasses(TestRunnerTest.class);
		System.out.println("finished all test cases");
		
	}

}

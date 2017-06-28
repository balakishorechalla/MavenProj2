package com.spicejet.tests;

import java.util.List;
import java.util.Map;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

import com.spicejet.keywords.CommonKeyWords;
import com.spicejet.util.CreateFolders;

public class CustomRunListener extends RunListener{
	
	public static Map<String,String> testResult;
	String result="passed";
	String methodName="unique";
	boolean flag=true;
	int i=1;
	
	
	
	/* public void testRunStarted(Description description) throws Exception {
	        System.out.println("Number of tests to execute: " + description.testCount());
	    }*/

	    public void testRunFinished(Result result) throws Exception {
	        System.out.println("Number of tests executed: " + result.getRunCount());
	        System.out.println("Total time taken :"+result.getRunTime());
	        System.out.println("failure count "+result.getFailureCount());
	        List<Failure> failedTests=result.getFailures();
	        for(int i=0;i<failedTests.size();i++)
	        {
	        	System.out.println("Failed TCN is :"+failedTests.get(i).getDescription().getMethodName());
	        	System.out.println("Failed TCN is :"+failedTests.get(i).getDescription());
	        	System.out.println("Failed TCN is :"+failedTests.get(i));
	        	/*String failedReasons[]=failedTests.get(i).toString().split(failedTests.get(i).getDescription().toString());
	        	System.out.println("failed reason is :"+failedReasons[0]);*/
	        	
	        	System.out.println("The failed message is :"+failedTests.get(i).getMessage());
	        	System.out.println("The exception is :"+failedTests.get(i).getException());
	        			
	        }
	        
	        
	        
	    }

	  /*  public void testStarted(Description description) throws Exception {
	        System.out.println("Starting: " + description.getMethodName());
	       // description.
	    }*/

	   // public void testFinished(Description description) throws Exception {
	    	//System.out.println("The method name is "+description.getMethodName());
	    //	CommonKeyWords.callPass();
	    	/*System.out.println("The value of i is :"+(i++));
	    	if(flag==false)
	    	{
	    		System.out.println("it was failed");
	    		flag=true;
	    	}
	    	else if(flag==true)
	    	{
	    		System.out.println("it was succeed ");
	    		//CommonKeyWords.quitBrowser();
	    	}*/
	       // System.out.println("test finished method : " + description.getMethodName());
	    	
	    	/* try {
					CommonKeyWords.takeScreenshot(description.getMethodName());
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					//System.out.println("Catch loop");
					e.printStackTrace();
				}
	    	System.out.println("********************"+result);
	        if(result.equals("passed"))
	        {
	        	System.out.println("passed method : " + description.getMethodName());
	        	CommonKeyWords.quitBrowser();
	        }
	        else if(result.equals("failed"))
	        {
	        	if(!methodName.equals(description.getMethodName()))
	        	{
	        	System.out.println("failed method : " + description.getMethodName());
	        	methodName=description.getMethodName();
	        	result="passed";
	        	}
	        }
	        */
	  //  }
	    public void testFailure(Failure failure)
	    {
	    	System.out.println("failure method");
	    	CreateFolders.xls.setCellData("TestDetails", "Result", CreateFolders.rowNum, "fail");
	    	CreateFolders.xls.setCellData("TestDetails", "FailedReason", CreateFolders.rowNum, failure.getMessage());
	    }

	   /* public void testFailure(Failure failure) {
	       // System.out.println("Failed: " + failure.getDescription().getMethodName());
	       // System.out.println("monitoring failure method");
	        try {
				CommonKeyWords.takeScreenshot(failure.getDescription().getMethodName());
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				System.out.println("Catch loop");
				e.printStackTrace();
			}
	        CommonKeyWords.callFalse();*/
	     //  System.out.println("Count is :"+failure.getDescription().testCount());
	       /* System.out.println("hitttin failed variable");
	        result="failed";*/
	        /*flag=false;
	        CommonKeyWords.quitBrowser();*/
	      /*  if(!methodName.equals(failure.getDescription().getMethodName()))
	        {
	        	CommonKeyWords.quitBrowser();
	        	methodName=failure.getDescription().getMethodName();
	        	
	        }
	        */
	       // System.out.println("monitoring failure method");
	 //   }

	  /*  public void testAssumptionFailure(Failure failure) {
	        System.out.println("Failed: " + failure.getDescription().getMethodName());
	    }

	    public void testIgnored(Description description) throws Exception {
	        System.out.println("Ignored: " + description.getMethodName());
	    }*/

}

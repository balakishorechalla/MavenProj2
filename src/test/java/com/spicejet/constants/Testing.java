package com.spicejet.constants;

import java.util.ArrayList;

public class Testing {
	//static ArrayList<String> arrayList;
	
	public static void main(String args[])
	{
		TestResults ts=new TestResults();
		/*arrayList=new ArrayList();
		arrayList.add("kishore");
		System.out.println(arrayList.get(0));*/
		ts.setMethodName("firstMethod");
		ts.setMethodName("bala");
		ts.setResult("pass");
		ts.setResult("fail");
		System.out.println(ts.getMethodName());
		System.out.println(ts.getMethodName());
	
	}

}

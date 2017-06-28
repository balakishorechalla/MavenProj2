package com.spicejet.dummypkg;

import com.spicejet.constants.CukeConstants.TestData;
import com.spicejet.util.Xls_Reader;

public class TestingXl {
	
	static Xls_Reader xls;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path=TestData.XLFILEPATH;
		System.out.println("The path of the xl file is "+path);
		xls=new Xls_Reader(path);
		System.out.println("The number of rows are "+xls.getRowCount("TestDetails"));
		System.out.println("The cell data is  "+xls.getCellData("TestDetails","Result", 2));
		System.out.println(xls.setCellData("TestDetails", "Result", 3, "fail"));

	}

}

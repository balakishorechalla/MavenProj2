package com.spicejet.html;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.spicejet.constants.CukeConstants.TestData;
import com.spicejet.util.Xls_Reader;

public class CreateHtmlFile {
	
	private String htmlFilePath=TestData.HTMLPATH;
	private File htmlFile;
	private BufferedWriter junitWriter;
	private String htmlStartTag="<!DOCTYPE html><html><body>";
	private String htmlHeader="<center><h1>Automation Test Results</h1>";
	private String tableHeader="<table style=width:80% border="+1+">";
	private String tableFirstRow="<tr style=background-color:orange><th>Test Case</th><th>Result</th></tr>";
	private String htmlEndTag="</table></body></html>";
	private Xls_Reader xlReader;
	public void createReport() throws IOException
	{
		xlReader=new Xls_Reader(TestData.XLFILEPATH);
		htmlFile=new File(htmlFilePath);
		junitWriter=new BufferedWriter(new FileWriter(htmlFile));
		junitWriter.write(htmlStartTag);
		junitWriter.write(htmlHeader);
		junitWriter.write(tableHeader);
		junitWriter.write(tableFirstRow);
		for(int i=2;i<=xlReader.getRowCount("TestDetails");i++)
		{
			if(xlReader.getCellData("TestDetails", "Result", i).trim().equalsIgnoreCase("pass"))
			{
				junitWriter.write("<tr style=background-color:green><td>"+xlReader.getCellData("TestDetails", "Scenario Name", i)+"</td><td bgcolor="+"#00FF00+"+"><a href="+xlReader.getCellData("TestDetails", "Folder Location", i).trim()+">"+xlReader.getCellData("TestDetails", "Result", i)+"</a></td></tr>");
			}
			else if(xlReader.getCellData("TestDetails", "Result", i).trim().equalsIgnoreCase("fail"))
			{
				junitWriter.write("<tr style=background-color:red><td>"+xlReader.getCellData("TestDetails", "Scenario Name", i)+"</td><td bgcolor="+"#FF0000+"+"><a href="+xlReader.getCellData("TestDetails", "Folder Location", i).trim()+">"+xlReader.getCellData("TestDetails", "Result", i)+"</a></td></tr>");
			}
			
		}
		junitWriter.write(htmlEndTag);
		junitWriter.close();
	}

	/*public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		CreateHtmlFile chf=new CreateHtmlFile();
		chf.createReport();
	}*/

}

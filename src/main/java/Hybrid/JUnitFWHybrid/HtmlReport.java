package Hybrid.JUnitFWHybrid;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class HtmlReport {
	
	static String htmlLocation="D:\\MavenProj1\\Spicejet\\TestReport\\JunitReport.html";
	static File junitFile;
	static BufferedWriter junitWriter;
	static String htmlStartTag="<!DOCTYPE html><html><body>";
	static String htmlHeader="<center><h1>Automation Test Results</h1>";
	static String tableHeader="<table style=width:80% border="+1+">";
	static String tablefirstRow="<tr style=background-color:orange><th>Test Case</th><th>Result</th><th>Time</th></tr>";
	static String htmlEndTag="</table></body></html>";
	
	public static void createReport() throws IOException
	{
		junitFile=new File(htmlLocation);
		junitWriter=new BufferedWriter(new FileWriter(junitFile));
		System.out.println("written");
		junitWriter.write(htmlStartTag);
		junitWriter.write(htmlHeader);
		junitWriter.write(tableHeader);
		junitWriter.write(tablefirstRow);
		
		for(HashMap<String,String> hm:XMLParser.nodeMap.values())
		{
			if(hm.get("result").equals("pass"))
			{
				junitWriter.write("<tr style=background-color:green><td>"+hm.get("TestCaseName")+"</td><td>"+hm.get("result")+"</td><td>"+hm.get("time")+"</td></tr>");
			}
			else if(hm.get("result").equals("fail"))
			{
				junitWriter.write("<tr style=background-color:red><td>"+hm.get("TestCaseName")+"</td><td>"+hm.get("result")+"</td><td>"+hm.get("time")+"</td></tr>");
			}
			//junitWriter.write("<tr><td>"+hm.get("TestCaseName")+"</td><td>"+hm.get("result")+"</td><td>"+hm.get("time")+"</td></tr>");
		}
		junitWriter.write(htmlEndTag);
		junitWriter.close();//we need to close the bufferedWriter otherwise we wont get the report
	}
	
	public static void main(String args[]) throws IOException
	{
		HtmlReport hr=new HtmlReport();
		hr.createReport();
	}

}

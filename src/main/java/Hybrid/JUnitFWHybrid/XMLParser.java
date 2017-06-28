package Hybrid.JUnitFWHybrid;



import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class XMLParser {
	
	static ArrayList xmlfiles;
	static File fxmlFile;
	static HashMap<String,String> hm;
	static HashMap<String,String> nhm;
	static HashMap<Integer,HashMap<String,String>> nodeMap;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//System.out.println(" the value is  "+Sample1.check);
		    xmlfiles=new ArrayList<String>();
		    hm=new HashMap<String,String>();
		    nodeMap=new HashMap<Integer,HashMap<String,String>>();
		    int k=1;
		    
		try{
			
			File folder=new File("target\\surefire-reports");
			File listOfFiles[]=folder.listFiles();
			for(int i=0;i<listOfFiles.length;i++)
			{
				String filename=listOfFiles[i].getName();
				if(filename.endsWith(".xml") || filename.endsWith(".XML"))
				{
					System.out.println("The filename is "+filename);
					xmlfiles.add(filename);
				}
			}
			
			for(int i=0;i<xmlfiles.size();i++)
			{
				fxmlFile=new File("target\\surefire-reports\\"+xmlfiles.get(i));
				DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder=dbFactory.newDocumentBuilder();
				Document doc=dBuilder.parse(fxmlFile);
				doc.getDocumentElement().normalize();
				System.out.println("Root element :"+doc.getDocumentElement().getNodeName());
				System.out.println("--------------------------------------");
				NodeList nList=doc.getElementsByTagName("testcase");
				for(int temp=0;temp<nList.getLength();temp++)
				{
					nhm=new HashMap<String,String>();
					Node nNode=nList.item(temp);
					System.out.println("\n current element "+nNode.getNodeName());
					if(nNode.getNodeType()==Node.ELEMENT_NODE)
					{
						Element eElement=(Element)nNode;
						System.out.println("The name of the method is  "+eElement.getAttribute("name"));
						System.out.println("The time taken by the method is  "+eElement.getAttribute("time"));
						hm.put("TestCaseName", eElement.getAttribute("name"));
						hm.put("time", eElement.getAttribute("time"));
						nhm.put("TestCaseName", eElement.getAttribute("name"));
						nhm.put("time", eElement.getAttribute("time"));
						
						if(eElement.hasChildNodes())
						{
							System.out.println("This is failure method");
							System.out.println("The failure reason is : " + eElement.getElementsByTagName("failure").item(0).getTextContent());
							hm.put("result", "fail");
							hm.put("reason", eElement.getElementsByTagName("failure").item(0).getTextContent());
							nhm.put("result", "fail");
						}
						else
						{
							hm.put("result", "pass");
							hm.put("reason", "");
							nhm.put("result", "pass");
						}
						
						
					}
					
					nodeMap.put(k++, nhm);
					
				}
				
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		HtmlReport.createReport();

	}

}

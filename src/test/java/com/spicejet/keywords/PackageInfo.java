package com.spicejet.keywords;

import java.util.HashMap;
import java.util.Map;

public enum PackageInfo {
	
	first("com.spicejet.first","SpicejetHomePage","SecondPage"),
	matrimony("com.matrimony.first","MatrimonyHomePage"),
	fb("com.facebook.home","FBhomePage");
	
	private String pkgName;
	private String classNames[];
	
	private static  Map<String,String> class_mapping=new HashMap<String,String>();
	
	private PackageInfo(String pkgName,String... classNames)
	{
		this.pkgName=pkgName;
		this.classNames=classNames;
	}
	
	static
	{
		for(PackageInfo p:PackageInfo.values())
		{
			String classes[]=p.classNames;
			for(int i=0;i<classes.length;i++)
			{
				class_mapping.put(classes[i], p.pkgName);
			}
		}
	}
	
	public static String getPackageName(String className)
	{
		return class_mapping.get(className);
	}
	
	
	

}

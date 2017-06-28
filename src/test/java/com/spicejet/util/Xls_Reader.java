package com.spicejet.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*FileInputStream
 * workbook
 * sheet
 * row
 * cell
 */

public class Xls_Reader {
	
	String fileName="";
	String path;
	FileInputStream fis;
	FileOutputStream fout;
	XSSFWorkbook workbook=null;
	XSSFSheet sheet=null;
	XSSFRow row=null;
	XSSFCell cell;
	public Xls_Reader(String path)
	{
		this.path=path;
		try
		{
			fis=new FileInputStream(path);
			workbook=new XSSFWorkbook(fis);
			sheet=workbook.getSheetAt(0);
			System.out.println("xl file exist and object created");
		}catch(Exception y)
		{
			System.out.println("xl file does not exist");
		}
	}

	public int getRowCount(String sheetNm)
	{
		int index=workbook.getSheetIndex(sheetNm);
		if(index==-1)
		{
			return 0;
		}
		else
		{
			sheet=workbook.getSheet(sheetNm);
			int number=sheet.getLastRowNum()+1;
			System.out.println("The number of rows in sheet is "+number);
			return number;
		}
	}
	public String getCellData(String sheetNm,String colNm,int rowNum)
	{
		rowNum=rowNum-1;
		if(rowNum<0)
			return "";
		
		int index=workbook.getSheetIndex(sheetNm);
		if(index==-1)
			return "";
		
		sheet=workbook.getSheet(sheetNm);
		row=sheet.getRow(0);
		
		int colNum=-1;
		
		for(int i=0;i<row.getLastCellNum();i++)
		{
			if(colNm.equalsIgnoreCase(row.getCell(i).getStringCellValue().trim()))
			{
				colNum=i; 
				break;
			}
				
		}
		
		if(colNum==-1)
			return "";
		
		sheet=workbook.getSheetAt(index);
		row=sheet.getRow(rowNum);
		if(row==null)
			return "";
		
		cell=row.getCell(colNum);
		
		if(cell==null)
			return "";
		else
		{
			return cell.getStringCellValue().trim();
		}
	}
	
	public boolean setCellData(String sheetNm,String colNm,int rowNum,String data)
	{
		rowNum=rowNum-1;
		if(rowNum<0)
			return false;
		
		int index=workbook.getSheetIndex(sheetNm);
		if(index==-1)
			return false;
		
		sheet=workbook.getSheetAt(index);
		int colNum=-1;
		row=sheet.getRow(0);
		
		for(int i=0;i<row.getLastCellNum();i++)
		{
			if(colNm.equalsIgnoreCase(row.getCell(i).toString().trim()))
			{
				colNum=i;
				break;
			}
		}
		
		if(colNum==-1)
			return false;
		
		row=sheet.getRow(rowNum);
		if(row==null)
			row=sheet.createRow(rowNum);
		
		cell=row.getCell(colNum);
		
		if(cell==null)
			cell=row.createCell(colNum);
		
		cell.setCellValue(data);
		
		try
		{
			fout=new FileOutputStream(path);
			workbook.write(fout);
			fout.close();
		}catch(Exception e)
		{
			return false;
		}
		
		return true;
	}

}

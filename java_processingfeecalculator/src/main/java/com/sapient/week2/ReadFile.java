package com.sapient.week2;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFile {
	public static List<ArrayList<String>> transaction=new ArrayList<ArrayList<String>>();
	public static List<String> n;
	
	@SuppressWarnings("deprecation")
	public static List<ArrayList<String>> read(){
	try{
        File file= new File("transactions.XLSX");//creating a instance of file
        FileInputStream fl= new FileInputStream(file);	//to input data in the form of byte stream
        //creating workbook instance
        XSSFWorkbook wb = new XSSFWorkbook(fl);
        XSSFSheet sheet = wb.getSheetAt(0);//creating a sheet object
        Iterator<Row> itr= sheet.iterator();// to iterate over excel file 
        itr.next(); 
        while( itr.hasNext()) {
	          Row row=itr.next();
	          Iterator<Cell> cellitr= row.cellIterator();
	          n=new ArrayList<String>();
	          while( cellitr.hasNext()) {
	          Cell cell =cellitr.next();
	          if(cell.getCellType() == Cell.CELL_TYPE_STRING)
	        	  n.add(cell.getStringCellValue());
	              else {
	            	  n.add(String.valueOf(cell.getNumericCellValue()));
	              }
	          
	    }
	   transaction.add((ArrayList<String>) n); 
	   }
        wb.close();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return transaction;
}}

package com.sapient.week2;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFile {
	public static HashMap<String, ArrayList<String>> transaction=new HashMap<String,ArrayList<String>>();
	public static ArrayList<String> n;
	
	public static HashMap<String, ArrayList<String>> read(){
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
	           n.add(cell.getStringCellValue());   
	    }
	   transaction.put(n.get(1), n); 
	   }
        wb.close();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return transaction;
}}

package com.sapient.week2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class SummaryReport {
	public static  List<ArrayList<String>> transaction=new  ArrayList<ArrayList<String>>();
	public static void main(String[] args) throws IOException {
               transaction=ProcessingRules.process(ReadFile.read());
               FileWriter f = new FileWriter("report.txt");
               f.write("ClientId  "+"Transaction Date  "+"Priority  "+"Processing Fee  "+"Transaction Type"+"\n");
               for (ArrayList<String> values : transaction) {
                   try {
					f.write(values.get(1)+"     	  " + values.get(4)+"	 		" + values.get(6)+"	 		" + values.get(7)+"         " + values.get(3)+"\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
               }
               f.close();       
	}
}

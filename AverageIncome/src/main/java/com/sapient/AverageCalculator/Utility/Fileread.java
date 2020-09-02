package com.sapient.AverageCalculator.Utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.sapient.AverageCalculator.Objectmodels.Currency;
import com.sapient.AverageCalculator.Objectmodels.Gender;
import com.sapient.AverageCalculator.Objectmodels.input;

public class Fileread {
	private static String row;
	public static Map<String,List<input>> read(String Inputfile){
		Map<String,List<input>> attributes = new TreeMap<String,List<input>>();
	try {
	BufferedReader csvReader = new BufferedReader(new FileReader(Inputfile));
	csvReader.readLine();
		while ((row = csvReader.readLine()) != null) {
			String key;
		    String[] data = row.split(",");
		    if(data[1].isEmpty()) {
		    	key = data[0];
		    }
		    else {
		    	key = data[1];
		    }
		    input n = new input(data[0], data[1],Double.parseDouble(data[4]),Currency.valueOf(data[3]), Gender.valueOf(data[2]));
		    
		    if(!attributes.containsKey(key)) {
		    	attributes.put(key, new ArrayList<input>());
		    }
		    attributes.get(key).add(n); 
		}
		csvReader.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return attributes;
}}

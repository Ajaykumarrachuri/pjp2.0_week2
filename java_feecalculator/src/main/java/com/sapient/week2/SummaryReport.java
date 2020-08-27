package com.sapient.week2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.collections.map.LinkedMap;
import org.apache.commons.collections.map.MultiKeyMap;


public class SummaryReport {
	public static HashMap<String, ArrayList<String>> transaction=new HashMap<String,ArrayList<String>>();;
	public static void main(String[] args) {
               transaction=ProcessingRules.process(ReadFile.read());
               
               MultiKeyMap multiKeyMap = MultiKeyMap.decorate(new LinkedMap());
               for (HashMap.Entry<String, ArrayList<String>> entry : transaction.entrySet()) {
                   String key = entry.getKey();
                   List<String> values = entry.getValue();
                   //System.out.println("Key = " + key);
                   System.out.println("Values = " + values.get(8));
               }
               
               
	}

}

package com.sapient.week2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProcessingRules {
	
	
       public static List<ArrayList<String>> process(List<ArrayList<String>> transaction) {
    	   for ( ArrayList<String> values : transaction) {
               if(values.get(6).contentEquals("Y")){
            	   values.add("500");
               }
               else if(values.get(3).contentEquals("SELL")||values.get(3).contentEquals("WITHDRAW")){
            	   values.add("100");
               }
               else if(values.get(3).contentEquals("BUY")||values.get(3).contentEquals("DEPOSIT")){
            	   values.add("50");
               }
           }
    	   Map<String,String> p=new HashMap<String,String>();
    	   p.put("BUY", "SELL");
    	   p.put("SELL","BUY");
    	   
    	   Comparator<ArrayList<String>> intraday = (a, b) -> {
   			if(a.get(1).equals(b.get(1)) && a.get(2).equals(b.get(2)) && a.get(3).equals(p.get(b.get(3)))&& (a.get(4) == b.get(4))) {
   				a.add(7,String.valueOf(Integer.parseInt(a.get(7))+10));
   				b.add(7,String.valueOf(Integer.parseInt(b.get(7))+10));
   				return (int) (Integer.parseInt(a.get(7))-Integer.parseInt(b.get(7)));
   			}
   			else {
   				return a.get(1).compareTo(b.get(1));
   			}
   		};
   		Collections.sort(transaction, intraday);  
    	   
		return transaction;  
      }
}

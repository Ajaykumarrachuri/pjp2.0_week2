package com.sapient.week2;

import java.util.ArrayList;
import java.util.HashMap;

public class ProcessingRules {
       public static HashMap<String, ArrayList<String>> process(HashMap<String, ArrayList<String>> transaction) {
    	   for (HashMap.Entry<String, ArrayList<String>> entry : transaction.entrySet()) {
               String key = entry.getKey();
               ArrayList<String> values = entry.getValue();
               if(values.get(6).contentEquals("Y")){
            	   values.add("500");
               }
               else if(values.get(4).contentEquals("Sell")||values.get(4).contentEquals("Withdraw")){
            	   values.add("100");
               }
               else if(values.get(4).contentEquals("Buy")||values.get(4).contentEquals("Deposit")){
            	   values.add("50");
               }
               transaction.put(key, values); 
           }
    	   
    	   
    	   
		return transaction;  
      }
}

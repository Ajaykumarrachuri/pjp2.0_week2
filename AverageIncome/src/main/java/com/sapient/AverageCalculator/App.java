package com.sapient.AverageCalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.sapient.AverageCalculator.Objectmodels.Gender;
import com.sapient.AverageCalculator.Objectmodels.input;
import com.sapient.AverageCalculator.Objectmodels.output;
import com.sapient.AverageCalculator.Utility.Fileread;
import com.sapient.AverageCalculator.Utility.Filewrite;
import com.sapient.AverageCalculator.Utility.currency;

public class App {


	public static void main(String[] args) {
		
		
		String Inputfile = "Sample input file Assignment.csv";
		String output = "output.csv";
		Map<String,List<input>> attributes = new TreeMap<String,List<input>>();
		attributes=Readinputstream(Inputfile);
		attributes=currency.classconversion(attributes);
		List<output> result = new ArrayList<output>();
		result=processaverage(attributes);
		System.out.println(result.get(3).getCalculatedaverage());
		Writeoutput(result,output);
	}
	
	private static Map<String, List<input>> Readinputstream(String inputfile) {
		return Fileread.read(inputfile);
	}

	private static void Writeoutput(List<output> result, String output) {
	       Filewrite.write(result,output);	
	}

	private static List<output> processaverage(Map<String, List<input>> attributes) {
		List<output> result = new ArrayList<output>();
		for(Map.Entry<String,List<input>> x: attributes.entrySet()) {
			double[] values= {0,0,0};
			int[] count= {0,0};
			x.getValue().stream().forEach((y) -> {
				if(y.getGender()==Gender.F) {
					count[0]+=1;
					values[0]+=y.getAverageincome();
				}
				else {
					count[1]+=1;
					values[1]+=y.getAverageincome();
				}
			});
		  result.add(new output(x.getKey(),Gender.F, BigDecimal.valueOf(values[0]/count[0]).setScale(2, RoundingMode.HALF_UP).doubleValue()));
		  result.add(new output(x.getKey(), Gender.M,BigDecimal.valueOf(values[1]/count[1]).setScale(2, RoundingMode.HALF_UP).doubleValue()));
		}
		return result;
	}
	

}

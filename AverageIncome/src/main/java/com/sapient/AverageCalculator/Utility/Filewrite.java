package com.sapient.AverageCalculator.Utility;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.sapient.AverageCalculator.Objectmodels.output;

public class Filewrite {

	public static void write(List<output> result, String output) {
		try {
			FileWriter csvWriter = new FileWriter(output);
			csvWriter.append("City/Country");
			csvWriter.append(",");
			csvWriter.append("Gender");
			csvWriter.append(",");
			csvWriter.append("AverageIncome(In USD)");
			csvWriter.append("\n");
			for (output rowData : result) {
			    csvWriter.append(String.join(",", rowData.getLocation(),rowData.getGender().name(),String.valueOf(rowData.getCalculatedaverage())));
			    csvWriter.append("\n");
			}

			csvWriter.flush();
			csvWriter.close();	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

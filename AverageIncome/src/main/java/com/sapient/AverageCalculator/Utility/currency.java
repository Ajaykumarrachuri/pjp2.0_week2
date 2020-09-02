package com.sapient.AverageCalculator.Utility;

import java.util.List;
import java.util.Map;

import com.sapient.AverageCalculator.Objectmodels.input;

public class currency {

	public static Map<String, List<input>> classconversion(Map<String, List<input>> attributes) {
		for(Map.Entry<String,List<input>> x: attributes.entrySet()) {
			x.getValue().stream().forEach((y) -> {
			switch(y.getCurrency()) {
			case HKD:
				y.setAverageincome(y.getAverageincome()/8);
				break;
			case GBP:
				y.setAverageincome(y.getAverageincome()/0.67);
				break;
			case INR:
				y.setAverageincome(y.getAverageincome()/66);
				break;
			case SGP:
				y.setAverageincome(y.getAverageincome()/1.5);
				break;
			default:
				break;
			}
			
			});
		}
			
		return attributes;
	}


}

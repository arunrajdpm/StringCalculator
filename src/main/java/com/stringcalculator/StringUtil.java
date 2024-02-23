package com.stringcalculator;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringUtil {
	
	public static Integer stringCalculator(String input) {
		
		if(input.isEmpty())
			return 0;
		
		 String delimiter = ",|\n";
		 
		 if (input.startsWith("//")) {
             int delimiterIndex = input.indexOf("\n");
             delimiter = input.substring(2, delimiterIndex);
             input = input.substring(delimiterIndex + 1);
         }
		
		String[] numsAsString = input.split(delimiter);
		
		String negativeNumbers = Arrays
	        	.stream(numsAsString)
	        	.filter(num -> Integer.parseInt(num)< 0)  	
	            .collect(Collectors.joining(","));
		
		if(!negativeNumbers.isEmpty())
			throw new RuntimeException("negative numbers not allowed " + negativeNumbers);
		
		
        return  Arrays
	    	        .stream(numsAsString)
	    	        .mapToInt(Integer::parseInt)
	    	        .sum();
    }

}

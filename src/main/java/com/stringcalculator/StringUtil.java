package com.stringcalculator;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringUtil {
	
	public static Integer stringCalculator(String input) {
		
		if(input.isEmpty())
			return 0;
		
		
		String[] numsAsString = input.split(",");
		
		
		String negativeNumbers = Arrays
        	.stream(numsAsString)
        	.mapToInt(Integer::parseInt)
        	.filter(num -> num < 0)
        	.mapToObj(String::valueOf)
            .collect(Collectors.joining(","));
		
		if(!negativeNumbers.isEmpty())
			throw new RuntimeException("negative numbers not allowed " + negativeNumbers);
		
		
        return  Arrays
	    	        .stream(numsAsString)
	    	        .mapToInt(Integer::parseInt)
	    	        .sum();
    }

}

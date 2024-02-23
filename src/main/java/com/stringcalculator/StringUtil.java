package com.stringcalculator;

import java.util.Arrays;

public class StringUtil {
	
	public static Integer stringCalculator(String input) {
		
		if(input.isEmpty())
			return 0;
		
		
		String[] numsAsString = input.split(",");
		
        return  Arrays
    	        .stream(numsAsString)
    	        .mapToInt(Integer::parseInt)
    	        .sum();
    }

}

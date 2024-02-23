package com.stringcalculator;

public class StringUtil {
	
	public static Integer stringCalculator(String input) {
		
		if(input.isEmpty())
			return 0;

        return Integer.parseInt(input);
    }

}

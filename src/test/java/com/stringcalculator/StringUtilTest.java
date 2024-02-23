package com.stringcalculator;
 
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
 
 

public class StringUtilTest {
	
	@Test
    public void testSimpleString() {
		
		 Assertions.assertEquals(1, StringUtil.stringCalculator("1"));
	}
}

package com.stringcalculator;
 
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


public class StringUtilTest {
	
	
	@ParameterizedTest
    @MethodSource("validateSimpleStrings")
    void limitReached_stringCalcutor(String input, Integer output) {
        Assertions.assertEquals(output, StringUtil.stringCalculator(input));
    }

    static Stream<Arguments> validateSimpleStrings() {
        return Stream.of(
                Arguments.of("1", 1),
                Arguments.of("2", 2)
        );
    }
    
    
    @Test
    void  testForEmptyString() {
    	Assertions.assertEquals(0, StringUtil.stringCalculator(""));
    }
    
    
    @Test
    void  testForMultipleString() {
    	Assertions.assertEquals(3, StringUtil.stringCalculator("1,2"));
    }
}

package com.stringcalculator;
 
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


public class StringUtilTest {
	
	
	@ParameterizedTest
    @MethodSource("validateSimpleStrings")
    void basic_stringCalcutor(String input, Integer output) {
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
    
    
    @ParameterizedTest
    @MethodSource("validateMultipleStrings")
    void validate_MultipleString(String input, Integer output) {
        Assertions.assertEquals(output, StringUtil.stringCalculator(input));
    }

    static Stream<Arguments> validateMultipleStrings() {
        return Stream.of(
                Arguments.of("1,2,3", 6),
                Arguments.of("2,4,8", 14)
        );
    }
    
    
    @ParameterizedTest
    @MethodSource("validateNegativeStrings")
    void validate_NegativeString(String input, String output) {
    	RuntimeException thrown = assertThrows(
    			RuntimeException.class,
    	           () -> StringUtil.stringCalculator(input),
    	           output
    	    );

    	assertTrue(thrown.getMessage().contains(output));
    }

    static Stream<Arguments> validateNegativeStrings() {
        return Stream.of(
                Arguments.of("-1", "negative numbers not allowed -1"),
                Arguments.of("-1,-2,-3", "negative numbers not allowed -1,-2,-3"),
                Arguments.of("-1,2,-3", "negative numbers not allowed -1,-3")
               
        );
    }
   
    
    @ParameterizedTest
    @MethodSource("validateNewLineDelimiterStrings")
    void validate_NewLineDelimiterString(String input, Integer output) {
        Assertions.assertEquals(output, StringUtil.stringCalculator(input));
    }

    static Stream<Arguments> validateNewLineDelimiterStrings() {
        return Stream.of(
                Arguments.of("1\n2,3", 6),
                Arguments.of("1\n2\n3", 6)
        );
    }
    
    
    
}

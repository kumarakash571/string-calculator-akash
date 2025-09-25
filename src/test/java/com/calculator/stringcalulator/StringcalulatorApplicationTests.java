package com.calculator.stringcalulator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StringcalulatorApplicationTests {

	private StringCalculator calc;
    
	@BeforeEach
	void setUp(){
		calc = new StringCalculator();
	}

	@Test
	void addEmptyString(){
		assertEquals(0, calc.add(""));
	}

	@Test
    void add_multipleNumbers() {
       assertEquals(15, calc.add("1,2,3,4,5"));
  }
    
   @Test
    void add_twoNumbers_commaSeparated() {
      assertEquals(6, calc.add("1,5"));
    }
	
	@Test
     void add_singleNumber_returnsNumber() {
        assertEquals(1, calc.add("1"));
     }

	 @Test
     void add_newlinesBetweenNumbers() {
        assertEquals(6, calc.add("1\n2,3"));
     }

	@Test
    void add_customDelimiter() {
        assertEquals(3, calc.add("//;\n1;2"));
    }

	
	@Test
    void add_negativeNumber_throwsException() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> calc.add("1,-2,3"));
        assertEquals("negative numbers not allowed -2", ex.getMessage());
    }
	

	@Test
    void add_multipleNegativeNumbers_listedInMessage() {
       IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                    () -> calc.add("-1,-2,3,-4"));
        assertEquals("negative numbers not allowed -1,-2,-4", ex.getMessage());
      }


}

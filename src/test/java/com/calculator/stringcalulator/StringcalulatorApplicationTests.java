package com.calculator.stringcalulator;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
	void contextLoads() {
	}

}

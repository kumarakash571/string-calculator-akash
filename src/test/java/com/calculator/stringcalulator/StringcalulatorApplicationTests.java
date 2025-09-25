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
	void contextLoads() {
	}

}

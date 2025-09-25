package com.calculator.stringcalulator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StringcalulatorApplicationTests {

	private StringcalulatorApplication calc;
    
	@BeforeEach
	void setUp(){
		calc = new StringcalulatorApplication();
	}

	@Test
	void contextLoads() {
	}

}

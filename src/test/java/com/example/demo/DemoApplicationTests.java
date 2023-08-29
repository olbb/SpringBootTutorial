package com.example.demo;

import com.example.demo.service.api.IUserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	IUserService userService;


	@Test
	@DisplayName("Integration test for App")
	void contextLoads() {
		assertFalse(userService.findAll().isEmpty());
		assertEquals("赵一", userService.findAll().get(0).getUserName());
	}

}

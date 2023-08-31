package com.example.demo;

import com.example.demo.service.api.IUserService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

	@Autowired
	IUserService userService;

	@Autowired
	MockMvc mockMvc;

	@Test
	@DisplayName("Integration test for App")
	void contextLoads() {
		assertFalse(userService.findAll().isEmpty());
		assertEquals("赵一", userService.findAll().get(0).getUserName());
	}

	@Test
	@DisplayName("Test findUser")
	void summary() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/user/summary/1").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.status").value("200"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.data.userName").value("赵一"));
		mockMvc.perform(MockMvcRequestBuilders.get("/user/summary/2").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.status").value("200"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.data.userName").value("张三"));
		mockMvc.perform(MockMvcRequestBuilders.get("/user/summary/9999").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.status").value("200"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.data", Matchers.nullValue()));

		mockMvc.perform(MockMvcRequestBuilders.get("/user/summary/-65535").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.status").value("200"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.data", Matchers.nullValue()));

		mockMvc.perform(MockMvcRequestBuilders.get("/user/summary/999999999999999999999").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is4xxClientError());

		mockMvc.perform(MockMvcRequestBuilders.get("/user/summary/str_test").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is4xxClientError());


	}

}

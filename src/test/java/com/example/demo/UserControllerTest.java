package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.service.api.IUserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * @author JuanLv created at 2023/8/29
 */
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    IUserService userService;

    @Test
    @DisplayName("Test findAll")
    void list() throws Exception {
        Mockito.when(userService.findAll()).thenReturn(
                Collections.singletonList(new User(1, "赵一"))
        );
        mockMvc.perform(MockMvcRequestBuilders.get("/user/list")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].userName").value("赵一"));
        verify(userService, times(1)).findAll();
    }

}

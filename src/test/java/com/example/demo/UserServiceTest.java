package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.service.UserServiceImp;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * @author JuanLv created at 2023/8/29
 */
@SpringBootTest
public class UserServiceTest {

    @Mock
    UserServiceImp userServiceImp;

    @Test
    public void findAll() {
        Mockito.when(userServiceImp.findAll()).thenReturn(
                Collections.singletonList(new User(1, "赵一"))
        );
        List<User> list = userServiceImp.findAll();
        verify(userServiceImp, times(1)).findAll();
    }

}

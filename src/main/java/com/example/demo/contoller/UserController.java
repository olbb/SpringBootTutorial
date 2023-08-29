package com.example.demo.contoller;

import com.example.demo.entity.User;
import com.example.demo.service.api.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author JuanLv created at 2023/8/29
 */
@RestController()
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/list")
    public List<User> users() {
        return userService.findAll();
    }
}

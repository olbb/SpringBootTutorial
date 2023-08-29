package com.example.demo.service.api;

import com.example.demo.entity.User;

import java.util.List;

/**
 * @author JuanLv created at 2023/8/29
 */
public interface IUserService {

    List<User> findAll();

}

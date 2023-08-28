package com.example.demo.dao;

import com.example.demo.beans.User;

import java.util.Collections;
import java.util.List;

/**
 * @author JuanLv created at 2023/8/28
 */
public class UserDaoImp {

    public UserDaoImp() {

    }

    public List<User> queryUserList() {
        return Collections.singletonList(new User("XiaoMing", "18"));
    }

}

package com.example.demo.service;


import com.example.demo.beans.User;
import com.example.demo.dao.UserDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author JuanLv created at 2023/8/28
 */
@Service
public class UserServiceImp {

    @Autowired
    private UserDaoImp mDao;

    public List<User> queryUserList() {
        return mDao.queryUserList();
    }
}

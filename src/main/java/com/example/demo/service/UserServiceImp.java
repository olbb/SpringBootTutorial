package com.example.demo.service;


import com.example.demo.beans.User;
import com.example.demo.dao.UserDaoImp;

import java.util.List;

/**
 * @author JuanLv created at 2023/8/28
 */
public class UserServiceImp {

    private UserDaoImp mDao;

    public UserServiceImp() {

    }

    public List<User> queryUserList() {
        return mDao.queryUserList();
    }

    public void setDao(UserDaoImp dao) {
        mDao = dao;
    }
}

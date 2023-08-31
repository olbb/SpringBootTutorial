package com.example.demo.service;


import com.example.demo.entity.User;
import com.example.demo.dao.UserDaoImp;
import com.example.demo.service.api.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author JuanLv created at 2023/8/28
 */
@Service
public class UserServiceImp implements IUserService {

    private UserDaoImp mDao;

    public UserServiceImp(UserDaoImp userDaoImp) {
        mDao = userDaoImp;
    }

    @Override
    public List<User> findAll() {
        return mDao.findAll();
    }

    @Override
    public User findUser(long id) {
        return mDao.findById(id).orElse(null);
    }
}

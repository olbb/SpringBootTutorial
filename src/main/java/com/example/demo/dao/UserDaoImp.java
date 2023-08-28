package com.example.demo.dao;

import com.example.demo.beans.User;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

/**
 * @author JuanLv created at 2023/8/28
 */
@Repository
public class UserDaoImp {

    public List<User> queryUserList() {
        return Collections.singletonList(new User("XiaoMing", "18"));
    }

}

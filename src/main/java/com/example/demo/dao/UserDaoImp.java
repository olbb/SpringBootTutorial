package com.example.demo.dao;

import com.example.demo.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author JuanLv created at 2023/8/28
 */
@Repository
public interface UserDaoImp extends JpaRepository<User, Integer> {

}

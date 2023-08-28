package com.example.demo;

import com.example.demo.aspect.LogAspect;
import com.example.demo.dao.UserDaoImp;
import com.example.demo.service.UserServiceImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author JuanLv created at 2023/8/25
 */
@Configuration
@EnableAspectJAutoProxy
public class TestConfig {

    public TestConfig() {
        System.out.println("TestConfig init success.");
    }

    // @Bean注解注册bean,同时可以指定初始化和销毁方法
    // @Bean(name="testBean",initMethod="start",destroyMethod="cleanup")
    //name属性相当于<bean>标签的id
    @Bean
    public UserDaoImp userDao() {
        return new UserDaoImp();
    }

    @Bean
    public UserServiceImp userService() {
        UserServiceImp userService = new UserServiceImp();
        userService.setDao(userDao());
        return userService;
    }

    @Bean
    public LogAspect logAspect() {
        return new LogAspect();
    }

}

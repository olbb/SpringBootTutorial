package com.example.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author JuanLv created at 2023/8/25
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.example.demo")
public class TestConfig {

}

package com.example.demo;

import java.util.Arrays;

import com.example.demo.service.UserServiceImp;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
//		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("com.example.demo");
//		UserServiceImp userServiceImp = ctx.getBean(UserServiceImp.class);
//		userServiceImp.queryUserList().forEach(System.out::println);

	}

	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
			System.out.println("Let's inspect the beans provided by Spring Boot:");
			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}
		};
    }

}

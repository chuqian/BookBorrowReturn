package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.controller"})
/*(exclude = {DataSourceAutoConfiguration.class})*/
@ComponentScan("com.controller")
@ComponentScan("com.service")
@ComponentScan("com.shiro")
@MapperScan("com.mapper")
public class BookBorrowReturnApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookBorrowReturnApplication.class, args);
		System.out.println("系统启动成功！");
		System.out.println("系统启动成功！");
		System.out.println("系统启动成功！");
		System.out.println("系统启动成功！");
		System.out.println("系统启动成功！");
	}

}


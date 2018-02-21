package com.jas.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 入口类
 *
 * @author Jas
 * @date 2018/02/18
 */
@SpringBootApplication(scanBasePackages = "com.jas")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}

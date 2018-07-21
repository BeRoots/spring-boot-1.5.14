package com.dsbackit.weblab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebLabApplication {

	public static void main(String[] args) {
		Object[] sources = {
			WebLabApplication.class,
			JpaConfig.class,
			MysqlConfig.class,
			ThymeleafConfig.class,
			InternationalizationConfig.class,
		};

		SpringApplication.run(sources, args);
	}
}
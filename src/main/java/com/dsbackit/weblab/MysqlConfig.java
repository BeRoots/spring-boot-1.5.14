package com.dsbackit.weblab;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MysqlConfig {
	 @Bean
	 public DataSource dataSource() {
		 // TomcatJdbc DataSource
		 DataSource dataSource = new DataSource();
		 // JDBC Configuration
		 dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		 dataSource.setUrl("jdbc:mysql://localhost:3306/ds-spring");
		 dataSource.setUsername("root");
		 dataSource.setPassword("");
		 // Initially opened connexions
		 dataSource.setInitialSize(5);
		 return dataSource;
	 }
}
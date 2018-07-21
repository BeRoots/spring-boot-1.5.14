package com.dsbackit.weblab;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration
public class ThymeleafConfig extends WebMvcConfigurerAdapter {
	 @Bean
	 public SpringResourceTemplateResolver templateResolver() {
		 SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
		 templateResolver.setPrefix("classpath:/templates/");
		 templateResolver.setSuffix(".html");
		 templateResolver.setTemplateMode("HTML5");
		 templateResolver.setCharacterEncoding("UTF-8");
		 templateResolver.setCacheable(true);
		 return templateResolver;
	 }
	 @Bean
	 SpringTemplateEngine templateEngine(SpringResourceTemplateResolver templateResolver) {
		 SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		 templateEngine.setTemplateResolver(templateResolver);
		 templateEngine.addDialect(new LayoutDialect());
		 return templateEngine;
	 }
}
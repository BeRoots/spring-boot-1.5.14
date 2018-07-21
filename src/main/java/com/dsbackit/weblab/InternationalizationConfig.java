package com.dsbackit.weblab;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
public class InternationalizationConfig extends WebMvcConfigurerAdapter {
	private static final String[] BASENAMES = {
		"i18n/messages.properties",
		"i18n/messages_en_GB.properties",
		"i18n/messages_fr_FR.properties",
	};
    @Bean
	 public MessageSource messageSource() {
		 ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		 messageSource.setBasenames(BASENAMES);
		 return messageSource;
	 }
	 @Bean
	 public LocaleChangeInterceptor localeChangeInterceptor() {
		 LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		 localeChangeInterceptor.setParamName("lang");
		 localeChangeInterceptor.setIgnoreInvalidLocale(true);
		 return localeChangeInterceptor;
	 }
	 @Override
	 public void addInterceptors(InterceptorRegistry registry) {
		 registry.addInterceptor(localeChangeInterceptor());
	 }
	 @Bean
	 public CookieLocaleResolver localeResolver() {
		 CookieLocaleResolver localeResolver = new CookieLocaleResolver();
		 localeResolver.setCookieName("lang");
		 localeResolver.setDefaultLocale(Locale.UK);
		 System.out.println("--------------");
		 System.out.println("--------------");
		 System.out.println(Locale.UK);
		 System.out.println("--------------");
		 System.out.println("--------------");
		 return localeResolver;
	 }
}
package com.br.luminous;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class LuminousApplication {

	public static void main(String[] args) {
		SpringApplication.run(LuminousApplication.class, args);
	}

	}

	//	@Bean
//	public WebMvcConfigurer configure() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry reg) {
//				reg.addMapping("/**")
//						.allowedMethods("GET", "POST", "DELETE", "PUT")
//						.allowedOriginPatterns("*")
//						.allowedOrigins("*");
//			}
//		};
//	}
//
//}

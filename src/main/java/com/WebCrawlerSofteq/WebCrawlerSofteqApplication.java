package com.WebCrawlerSofteq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class WebCrawlerSofteqApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(WebCrawlerSofteqApplication.class, args);
		Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
	}

}

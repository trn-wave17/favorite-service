package com.stackroute.favouriteservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.stackroute.favouriteservice.entity.Article;
import com.stackroute.favouriteservice.filter.JwtFilter;

@SpringBootApplication
public class FavouriteServiceApplication implements CommandLineRunner {

	@Bean
	public FilterRegistrationBean jwtFilter() {
		final FilterRegistrationBean bean = new FilterRegistrationBean<>();
		bean.setFilter(new JwtFilter());
		bean.addUrlPatterns("/api/*");
		return bean;
	}

	public static void main(String[] args) {
		SpringApplication.run(FavouriteServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Article entity = new Article();
	}

}

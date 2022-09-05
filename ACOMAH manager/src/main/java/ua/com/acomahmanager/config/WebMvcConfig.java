package ua.com.acomahmanager.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableAutoConfiguration
@ComponentScan
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("login");
		registry.addViewController("/home").setViewName("home");
		registry.addViewController("/login").setViewName("login"); 
		registry.addViewController("/403").setViewName("403");
		registry.addViewController("/utilities").setViewName("utilities");
		registry.addViewController("/tariffs").setViewName("tariffs");
		registry.addViewController("/bills").setViewName("bills");
		
		registry.addViewController("/users-management").setViewName("users-management");
		
		registry.addViewController("/create-bill").setViewName("create-bill");
		registry.addViewController("/create-message").setViewName("create-message");
		registry.addViewController("/create-tariff").setViewName("create-tariff");
		registry.addViewController("/create-utility").setViewName("create-utility");
		
	}
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/jsp/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
}

package by.itacademy.javaenterprise.knyazev.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import by.itacademy.javaenterprise.knyazev.spring.*;

@Configuration
@Import(value = SpringServiceConfig.class)
@EnableWebMvc
@ComponentScan(basePackages = {"by.itacademy.javaenterprise.knyazev.controllers"})
public class SpringMVCConfig {
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		return new InternalResourceViewResolver("/WEB-INF/views", ".jsp");		
	}	
}

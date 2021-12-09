package by.itacademy.javaenterprise.knyazev.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Import(value = {SpringPersistenceConfig.class})
@Configuration
@ComponentScan(basePackages = "by.itacademy.javaenterprise.knyazev.services")
public class SpringServiceConfig {

}

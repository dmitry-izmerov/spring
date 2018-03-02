package ru.demi.resources;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("ru.demi.resources")
@ImportResource("classpath:resources/resources.xml")
@PropertySource("classpath:resources/resources.properties")
public class Config {
}

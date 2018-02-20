package ru.demi.di;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("ru.demi.di")
public class Config {
	public TestBean testBean() {
		return null;
	}
}

package ru.demi.base;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		new SpringApplicationBuilder(App.class)
			.properties("spring.config.location=classpath:base/app-config.yml")
			.build()
			.run(args);
	}

	// enable thymeleaf-extras tags in templates
	@Bean
	public SpringTemplateEngine templateEngine(ITemplateResolver templateResolver, SpringSecurityDialect dialect) {
		final SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver);
		templateEngine.addDialect(dialect);
		return templateEngine;
	}

	// customize thymeleaf templates location
	@Bean
	public ITemplateResolver templateResolver() {
		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
		templateResolver.setPrefix("classpath:base/templates/");
		templateResolver.setSuffix(".html");
		templateResolver.setCacheable(false);
		templateResolver.setOrder(0);
		return templateResolver;
	}
}

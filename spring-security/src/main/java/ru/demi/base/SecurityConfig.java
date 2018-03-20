package ru.demi.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/css/**", "/index").permitAll()
				.antMatchers("/user/**").hasRole("USER")
				.and()
			.formLogin()
				.loginPage("/login")
				.failureUrl("/login-error");
	}

	@Autowired
	public void configureAuth(AuthenticationManagerBuilder builder) throws Exception {
		builder.inMemoryAuthentication()
			.passwordEncoder(NoOpPasswordEncoder.getInstance())
			.withUser("user")
				.password("pass")
				.roles("USER");
	}
}

package ru.demi.rest;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

@Data
public class User {

	public interface WithoutPassword {}

	@JsonView(User.WithoutPassword.class)
	private String id;
	@JsonView(User.WithoutPassword.class)
	private String name;
	private String password;
	@JsonView(User.WithoutPassword.class)
	private String email;
	@JsonView(User.WithoutPassword.class)
	private String phone;
}

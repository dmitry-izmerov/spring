package ru.demi.forminput;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserForm {

	@NotEmpty
	@Size(min = 4, max = 20)
	private String name;

	@NotNull
	@Min(18)
	private Integer age;

	@NotEmpty
	@Email
	private String email;
}

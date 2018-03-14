package ru.demi.forminput;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class WebController {

	@GetMapping("/results")
	public String showResults() {
		return "results";
	}

	@GetMapping("/")
	public String showForm(UserForm userForm) {
		return "form";
	}

	@PostMapping("/")
	public String checkPersonInfo(@Valid UserForm userForm, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "form";
		}

		return "redirect:/results";
	}
}

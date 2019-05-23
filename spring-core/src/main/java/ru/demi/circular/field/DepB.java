package ru.demi.circular.field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DepB {
	@Autowired
	private DepA depA;

	public DepA getDepA() {
		return depA;
	}
}

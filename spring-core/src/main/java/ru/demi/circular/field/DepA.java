package ru.demi.circular.field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DepA {
	@Autowired
	private DepB depB;

	public DepB getDepB() {
		return depB;
	}
}

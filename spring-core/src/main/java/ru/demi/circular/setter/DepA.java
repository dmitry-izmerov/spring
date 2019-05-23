package ru.demi.circular.setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DepA {
	private DepB depB;

	@Autowired
	public void setDepB(DepB depB) {
		this.depB = depB;
	}

	public DepB getDepB() {
		return depB;
	}
}

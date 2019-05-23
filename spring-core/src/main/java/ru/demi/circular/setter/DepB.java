package ru.demi.circular.setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DepB {
	private DepA depA;

	@Autowired
	public void setDepA(DepA depA) {
		this.depA = depA;
	}

	public DepA getDepA() {
		return depA;
	}
}

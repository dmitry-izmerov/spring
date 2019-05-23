package ru.demi.circular.lazy;

import org.springframework.stereotype.Component;

@Component
public class DepB {
	private DepA depA;

	public DepB(DepA depA) {
		this.depA = depA;
	}

	public DepA getDepA() {
		return depA;
	}
}

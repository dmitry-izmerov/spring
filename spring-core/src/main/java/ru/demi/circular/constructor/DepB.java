package ru.demi.circular.constructor;

import org.springframework.stereotype.Component;

@Component
public class DepB {
	private DepA depA;

	public DepB(DepA depA) {
		this.depA = depA;
	}
}

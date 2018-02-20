package ru.demi.circular.constructor;

import org.springframework.stereotype.Component;

@Component
public class DepA {
	private DepB depB;

	public DepA(DepB depB) {
		this.depB = depB;
	}
}

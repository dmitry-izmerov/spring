package ru.demi.circular.setter;

import org.springframework.stereotype.Component;

@Component
public class DepB {
	private DepA depA;

	public void setDepA(DepA depA) {
		this.depA = depA;
	}
}

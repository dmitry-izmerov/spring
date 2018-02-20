package ru.demi.circular.setter;

import org.springframework.stereotype.Component;

@Component
public class DepA {
	private DepB depB;

	public void setDepB(DepB depB) {
		this.depB = depB;
	}
}

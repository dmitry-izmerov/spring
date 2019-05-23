package ru.demi.circular.lazy;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class DepA {
	private DepB depB;

	public DepA(@Lazy DepB depB) {
		this.depB = depB;
	}

	public DepB getDepB() {
		return depB;
	}
}

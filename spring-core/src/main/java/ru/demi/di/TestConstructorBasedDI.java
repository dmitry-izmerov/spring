package ru.demi.di;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class TestConstructorBasedDI {
	private TestBean bean;

	public TestConstructorBasedDI(TestBean bean) {
		this.bean = bean;
	}

	public boolean isBeanSet() {
		return Objects.nonNull(bean);
	}
}

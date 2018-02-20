package ru.demi.di;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class TestSetterBasedDI {
	private TestBean bean;

	public void setBean(TestBean bean) {
		this.bean = bean;
	}

	public boolean isBeanSet() {
		return Objects.nonNull(bean);
	}
}

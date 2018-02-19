package ru.demi.logger;

import org.springframework.stereotype.Component;

@Component
public class URLEventLogger implements EventLogger {

	@Override
	public void logEvent(Event event) {
		// logging by url
	}
}

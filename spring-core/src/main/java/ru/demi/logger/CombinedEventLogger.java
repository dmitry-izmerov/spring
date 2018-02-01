package ru.demi.logger;

import java.util.Collection;

public class CombinedEventLogger implements EventLogger {
	private Collection<EventLogger> loggers;

	public CombinedEventLogger(Collection loggers) {
		this.loggers = loggers;
	}

	@Override
	public void logEvent(Event event) {
		loggers.forEach(logger -> logger.logEvent(event));
	}
}

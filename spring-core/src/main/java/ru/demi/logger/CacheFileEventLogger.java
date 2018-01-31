package ru.demi.logger;

import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger implements EventLogger {
	private int cacheSize;
	private List<Event> cache = new ArrayList<>(cacheSize);

	public CacheFileEventLogger(String fileName, int cacheSize) {
		super(fileName);
		this.cacheSize = cacheSize;
	}

	@PreDestroy
	private void preDestroy() {
		if (!cache.isEmpty()) {
			cache.forEach(super::logEvent);
		}
	}

	@Override
	public void logEvent(Event event) {
		cache.add(event);

		if (cache.size() == cacheSize) {
			cache.forEach(super::logEvent);
			cache.clear();
		}
	}
}

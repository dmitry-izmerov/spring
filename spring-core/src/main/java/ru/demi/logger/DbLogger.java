package ru.demi.logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DbLogger implements EventLogger {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void logEvent(Event event) {
		jdbcTemplate.update("INSERT INTO events (id, message) VALUES (?, ?)", event.getId(), event.getMessage());
	}
}

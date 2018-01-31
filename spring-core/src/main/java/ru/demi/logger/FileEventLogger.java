package ru.demi.logger;

import org.apache.commons.io.FileUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileEventLogger implements EventLogger {
	private String fileName;
	private File file;

	public FileEventLogger(String fileName) {
		this.fileName = fileName;
	}

	@PostConstruct
	private void postConstruct() throws IOException {
		file = new File(fileName);
		if (!file.canWrite()) {
			throw new IOException(String.format("Cannot write to file with name %s.", fileName));
		}
	}

	@Override
	public void logEvent(Event event) {
		try {
			FileUtils.writeStringToFile(file, String.format("%s%n", event.getMessage()), StandardCharsets.UTF_8, true);
		} catch (IOException e) {
			throw new RuntimeException("Writing to file failed.", e);
		}
	}
}

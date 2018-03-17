package ru.demi.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Collections;

@SpringBootApplication
public class App {
	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Bean
	public CommandLineRunner runner(UserRepository userRepository) {
		return args -> {
			// insert test data
			userRepository.save(new User("Bob", "Marley", "bpassm", "bob@mail.com", "+19131012020"));
			userRepository.save(new User("Vasya", "Abramov", "vasyapas", "vasab@mail.ru", "+79160173345"));
			userRepository.save(new User("Bjorn", "Davidson", "mypass", "bjdav@mail.no", "+478122300125"));
			userRepository.save(new User("Petya", "Abramov", "passpet", "petya@mail.ru", "+79190856187"));

			logHeader("Users found with findAll():");

			userRepository.findAll().forEach(this::logUser);

			userRepository.findById(1L)
				.ifPresent(user -> {
					logHeader("User found with findById():");
					logUser(user);
				});

			logHeader("Users found with findByLastName():");
			userRepository.findByLastName("Abramov").forEach(this::logUser);

			userRepository.findByEmail("bjdav@mail.no")
				.ifPresent(user -> {
					logHeader("User found with findByEmail():");
					logUser(user);
				});
		};
	}

	private void logHeader(String headline) {
		String line = String.join("", Collections.nCopies(110, "="));
		LOGGER.info(line);
		LOGGER.info(headline);
		LOGGER.info(line);
	}

	private void logUser(User user) {
		String line = String.join("", Collections.nCopies(110, "-"));
		LOGGER.info(user.toString());
		LOGGER.info(line);
	}
}

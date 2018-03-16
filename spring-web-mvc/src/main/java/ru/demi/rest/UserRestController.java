package ru.demi.rest;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

	private static AtomicLong idCounter = new AtomicLong();

	private Map<String, User> users = new HashMap<>();

	@PostConstruct
	private void postConstruct() {
		User user = new User();
		String nextId = getNextId();
		user.setId(nextId);
		user.setName("user");
		user.setPassword("paswrd");
		user.setEmail("email");
		user.setPhone("phone");
		users.put(nextId, user);
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@JsonView(User.WithoutPassword.class)
	public ResponseEntity<User> getUser(@PathVariable String id) {

		User user = users.get(id);

		if (Objects.isNull(user)) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(user);
	}

	@PutMapping
	@ResponseStatus(HttpStatus.CREATED)
	@JsonView(User.WithoutPassword.class)
	public User createUser(@RequestBody User user) {
		String nextId = getNextId();
		user.setId(nextId);
		users.put(nextId, user);
		return user;
	}

	@PostMapping("/{id}")
	@JsonView(User.WithoutPassword.class)
	public User changeUser(@PathVariable String id, @RequestBody User user) {
		user.setId(id);
		return users.computeIfPresent(id, (key, u) -> user);
	}

	@DeleteMapping("/{id}")
	@JsonView(User.WithoutPassword.class)
	public User deleteUser(@PathVariable String id) {
		return users.remove(id);
	}


	private String getNextId() {
		return String.valueOf(idCounter.incrementAndGet());
	}
}

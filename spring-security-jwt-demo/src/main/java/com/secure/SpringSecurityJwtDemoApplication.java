package com.secure;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.secure.Repository.UserRepository;
import com.secure.entity.User;

@SpringBootApplication
public class SpringSecurityJwtDemoApplication {

	@Autowired
	private UserRepository repository;

	@PostConstruct
	public void initUsers() {

		List<User> allusers = Stream.of(new User(1, "admin1", "admin1", "admin1@gmail.com"),
				new User(2, "admin2", "admin2", "admin2@gmail.com"),
				new User(3, "admin3", "admin3", "admin3@gmail.com"), new User(4, "ram", "ram", "ram@gmail.com")

		).collect(Collectors.toList());

		repository.saveAll(allusers);

	}

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtDemoApplication.class, args);
	}

}

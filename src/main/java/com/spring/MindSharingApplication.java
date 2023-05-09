package com.spring;

import com.spring.Repository.UserRepository;
import com.spring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class MindSharingApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(MindSharingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User("Jhon", "", "", "" , null, "", "", "");
		User user2 = new User("Mary", "", "", "" , null, "", "", "");
		userRepository.saveAll(Arrays.asList(user1, user2));

		userRepository.save(new User(
				"user",
				"$2a$10$NVM0n8ElaRgg7zWO1CxUdei7vWoPg91Lz2aYavh9.f9q0e4bRadue",
				"USER"));
		userRepository.save(new User(
				"admin",
				"$2a$10$8cjz47bjbR4Mn8GMg9IZx.vyjhLXR/SKKMSZ9.mP9vpMu0ssKi8GW",
				"ADMIN"));
	}
}

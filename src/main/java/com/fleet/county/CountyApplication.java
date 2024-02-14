package com.fleet.county;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fleet.county.entity.County;

import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import com.fasterxml.jackson.core.type.TypeReference;

@SpringBootApplication
@ComponentScan("com.fleet.county.*")
public class CountyApplication implements CommandLineRunner {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(CountyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<County> users = loadUsersFromJson();
		saveUsersToDatabase(users);
	}

	private List<County> loadUsersFromJson() throws IOException {
		InputStream inputStream = new ClassPathResource("data.json").getInputStream();
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(inputStream, new TypeReference<List<County>>() {
		});
	}

	private void saveUsersToDatabase(List<County> users) {
		for (County user : users) {
			jdbcTemplate.update("INSERT INTO county (name, fips, state) VALUES (?, ?, ?)", user.getName(),
					user.getFips(), user.getState());
		}
	}

}

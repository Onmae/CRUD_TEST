package com0.main;

import com0.main.domain.Basic;
import com0.main.domain.Profile;
import com0.main.repository.BasicRepository;
import com0.main.repository.ProfileRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(BasicRepository basicRepository, ProfileRepository profileRepository) {
		return (args) -> {
			basicRepository.save(Basic.builder()
					.name("홍길동")
					.label("CEO")
					.email("hone@gmail.com")
					.phone("010-123-4567")
					.build());

			basicRepository.save(Basic.builder()
					.name("장길산")
					.label("CFO")
					.email("jang@gmail.com")
					.phone("123-456-7890")
					.build());

			basicRepository.save(Basic.builder()
					.name("춘향이")
					.label("CTO")
					.email("chun@gmail.com")
					.phone("234-123-4567")
					.build());

			profileRepository.save(Profile.builder()
					.network("트위터")
					.username("@hong")
					.url("https://twitter/@home")
					.createdDate(LocalDateTime.now())
					.build());

			profileRepository.save(Profile.builder()
					.network("페이스북")
					.username("@hong")
					.url("https://twitter/@home")
					.createdDate(LocalDateTime.now())
					.build());

			profileRepository.save(Profile.builder()
					.network("트위터")
					.username("@hong")
					.url("https://twitter/@home")
					.createdDate(LocalDateTime.now())
					.build());
		};
	}
}
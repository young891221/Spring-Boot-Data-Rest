package com.community.rest;

import com.community.rest.domain.Book;
import com.community.rest.domain.Writer;
import com.community.rest.repository.BookRepository;
import com.community.rest.repository.WriterRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

@SpringBootApplication
public class RestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(BookRepository bookRepository, WriterRepository writerRepository) throws Exception {
		return (args) -> {
			Writer writer = writerRepository.save(Writer.builder()
					.name("havi")
					.age(30)
					.build());

			IntStream.rangeClosed(1, 10).forEach(index ->
					bookRepository.save(Book.builder()
							.title("Spring Boot Book"+index)
							.publishedAt(LocalDateTime.now())
							.writer(writer).build())
			);
		};
	}
}

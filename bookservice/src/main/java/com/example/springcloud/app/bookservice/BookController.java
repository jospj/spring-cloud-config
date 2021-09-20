package com.example.springcloud.app.bookservice;


import java.util.Arrays;
import java.util.List;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.springcloud.app.bookservice.dto.Book;

import lombok.extern.slf4j.Slf4j;

@RestController
@RefreshScope
@Slf4j
public class BookController {

	private List<Book> bookList = Arrays.asList(
			new Book(1L, "Baeldung goes to the market", "Tim Schimandle"),
			new Book(2L, "Baeldung goes to the park", "Slavisa")
			);

	@GetMapping("")
	public List<Book> findAllBooks() {
		log.info("Inside findAllBooks");
		return bookList;
	}

	@GetMapping("/{bookId}")
	public Book findBook(@PathVariable Long bookId) {
		log.info("Inside findBook for id {}",bookId);
		return bookList.stream().filter(b -> b.getId().equals(bookId)).findFirst().orElse(null);
	}
}

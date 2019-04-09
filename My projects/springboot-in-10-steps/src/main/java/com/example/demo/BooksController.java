package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksController {
		
	@GetMapping("/books") 
	public List<Book> getAllBooks() {
		//return Arrays.asList(new Book(1l, "Mastering Spring 5.0", "In28Minutes"));
		Book book1 = new Book(1234, "La voz de las espadas", "Joe Abercrombie");
		Book book2 = new Book(5678, "Juego de tronos", "George RR Martin");
		
		return Arrays.asList(book1, book2);
	}
	

}

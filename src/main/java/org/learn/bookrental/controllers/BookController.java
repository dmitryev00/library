package org.learn.bookrental.controllers;


import org.learn.bookrental.dto.BookInputDto;
import org.learn.bookrental.entitys.BookEntity;
import org.learn.bookrental.services.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/books")
public class BookController {

	BookService bookService;

	public BookController(BookService bookService)
	{
		this.bookService = bookService;
	}

	@GetMapping("/id/{id}")
	public BookEntity getById(@PathVariable Long id)
	{
		return bookService.getById(id);
	}

	@GetMapping()
	public List<BookEntity> getAllBooks()
	{
		return bookService.getAllBooks();
	}

	@GetMapping("/actual")
	public List<BookEntity> getAllActualBooks()
	{
		return bookService.getAllActual();
	}

	@PostMapping()
	public BookEntity addNewBook(@RequestBody BookInputDto request)
	{
		return bookService.putBook(request);
	}

	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable Long id)
	{
		bookService.deleteBook(id);
	}

	@GetMapping("/notactual")
	public List<BookEntity> getAllUnactualBooks()
	{
		return bookService.getAllUnactual();
	}

	@GetMapping("/name/{name}")
	public List<BookEntity> getBooksByName(@PathVariable String name)
	{
		return bookService.getBooksByName(name);
	}
}

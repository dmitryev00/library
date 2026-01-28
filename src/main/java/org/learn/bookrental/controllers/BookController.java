package org.learn.bookrental.controllers;


import org.learn.bookrental.dto.BookInputDto;
import org.learn.bookrental.dto.BookResponseDTO;
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
	public BookResponseDTO getById(@PathVariable Long id)
	{
		return bookService.getById(id);
	}

	@GetMapping()
	public List<BookResponseDTO> getAllBooks()
	{
		return bookService.getAllBooks();
	}

	@GetMapping("/actual")
	public List<BookResponseDTO> getAllActualBooks()
	{
		return bookService.getAllActual();
	}

	@PostMapping()
	public BookResponseDTO addNewBook(@RequestBody BookInputDto request)
	{
		return bookService.putBook(request);
	}

	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable Long id)
	{
		bookService.deleteBook(id);
	}

	@GetMapping("/notactual")
	public List<BookResponseDTO> getAllUnactualBooks()
	{
		return bookService.getAllUnactual();
	}

	@GetMapping("/name/{name}")
	public List<BookResponseDTO> getBooksByName(@PathVariable String name)
	{
		return bookService.getBooksByName(name);
	}
}

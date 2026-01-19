package org.learn.bookrental.services;


import org.learn.bookrental.dto.BookInputDto;
import org.learn.bookrental.entitys.BookEntity;
import org.learn.bookrental.repositories.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

	BookRepository bookRepository;

	public BookService(BookRepository bookRepository)
	{
		this.bookRepository = bookRepository;
	}

	public List<BookEntity> getAllBooks()
	{
		return bookRepository.findAll();
	}

	public BookEntity getById(Long id)
	{
		return getBookById(id);
	}

	public List<BookEntity> getAllActual()
	{
		return bookRepository.findAll().stream()
				.filter(book -> book.getStatus() == 1)
				.collect(Collectors.toList());
	}

	public BookEntity putBook(BookInputDto book)
	{
		BookEntity bookEntity = new BookEntity();
		bookEntity.setName(book.name());
		bookEntity.setEdition(book.edition());
		bookEntity.setAuthor(book.author());
		bookEntity.setStatus(1);
		return bookRepository.save(bookEntity);
	}

	@Transactional
	public void deleteBook(Long id) {
		if (!bookRepository.existsById(id)) {
			throw new IllegalArgumentException("Книга с ID " + id + " не найдена");
		}
		bookRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	public BookEntity getBookById(Long id) {
		return bookRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Книга с ID " + id + " не найдена"));
	}


	public List<BookEntity> getAllUnactual()
	{
		return bookRepository.findAll().stream()
				.filter(book -> book.getStatus() == 2)
				.collect(Collectors.toList());
	}


	public List<BookEntity> getBooksByName(String name)
	{
		return bookRepository.findByName(name);
	}
}

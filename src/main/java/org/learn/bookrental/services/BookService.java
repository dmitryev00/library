package org.learn.bookrental.services;


import org.learn.bookrental.dto.BookInputDto;
import org.learn.bookrental.dto.BookResponseDTO;
import org.learn.bookrental.entitys.BookEntity;
import org.learn.bookrental.mappers.BookMapper;
import org.learn.bookrental.repositories.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

	BookRepository bookRepository;

	public BookService(BookRepository bookRepository)
	{
		this.bookRepository = bookRepository;
	}

	public List<BookResponseDTO> getAllBooks()
	{
		List<BookEntity> bookEntities = bookRepository.findAll();
		return bookEntities.stream().map(
				BookMapper::toDto
		).collect(Collectors.toList());
	}

	public BookResponseDTO getById(Long id)
	{
		return getBookById(id);
	}

	public List<BookResponseDTO> getAllActual()
	{
		List<BookEntity> bookEntities = bookRepository.findAll().stream()
				.filter(book -> book.getStatus() == 1)
				.toList();
		return bookEntities.stream().map(
					BookMapper::toDto
					).collect(Collectors.toList());
	}

	public BookResponseDTO putBook(BookInputDto book)
	{
		BookEntity bookEntity = new BookEntity();
		bookEntity.setName(book.name());
		bookEntity.setEdition(book.edition());
		bookEntity.setAuthor(book.author());
		bookEntity.setStatus(1);
		BookEntity saved = bookRepository.save(bookEntity);
		return BookMapper.toDto(saved);
	}

	@Transactional
	public void deleteBook(Long id) {
		if (!bookRepository.existsById(id)) {
			throw new IllegalArgumentException("Книга с ID " + id + " не найдена");
		}
		bookRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	public BookResponseDTO getBookById(Long id) {
		BookEntity book = bookRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Книга с ID " + id + " не найдена"));
		return BookMapper.toDto(book);
	}


	public List<BookResponseDTO> getAllUnactual()
	{
		List<BookEntity> bookEntities = bookRepository.findAll().stream()
				.filter(book -> book.getStatus() == 2)
				.toList();

		return bookEntities.stream().map(
				BookMapper::toDto
				).collect(Collectors.toList());
	}


	public List<BookResponseDTO> getBooksByName(String name)
	{
		List<BookEntity> bookEntities = bookRepository.findByName(name);
		return bookEntities.stream().map(
				BookMapper::toDto
				).collect(Collectors.toList());
	}
}

package org.learn.bookrental.services;

import org.learn.bookrental.entitys.BookEntity;
import org.learn.bookrental.entitys.RentalEntity;
import org.learn.bookrental.repositories.BookRepository;
import org.learn.bookrental.repositories.RentalRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class RentalService {

	RentalRepository rentalRepository;
	BookRepository bookRepository;

	public RentalService(RentalRepository rentalRepository, BookRepository bookRepository, BookService bookService)
	{
		this.rentalRepository = rentalRepository;
		this.bookRepository = bookRepository;
	}

	@Transactional
	public void rentBook(String name)
	{
		if(name == null) throw new IllegalArgumentException("Book name cannot be null or empty");
		BookEntity book = bookRepository.findFirstByStatusAndName(1, name);
		book.setStatus(2);

		LocalDateTime rentedAt = LocalDateTime.now();
		LocalDateTime dueAt = rentedAt.plusDays(7);
		RentalEntity rent = new RentalEntity();
		rent.setBook(book);
		rent.setRentedAt(rentedAt);
		rent.setDueAt(dueAt);
		rent.setReturnedAt(null);
		rent.setUserId(12);
		rentalRepository.save(rent);
	}
}

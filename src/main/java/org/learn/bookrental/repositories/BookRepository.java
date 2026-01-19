package org.learn.bookrental.repositories;

import org.learn.bookrental.entitys.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
	List<BookEntity> id(Long id);

	List<BookEntity> findByName(String name);
}

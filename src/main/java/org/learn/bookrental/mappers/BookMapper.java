package org.learn.bookrental.mappers;

import org.learn.bookrental.dto.BookInputDto;
import org.learn.bookrental.dto.BookResponseDTO;
import org.learn.bookrental.entitys.BookEntity;


public class BookMapper {

	public static BookEntity toEntity(BookInputDto bookInputDto)
	{
		var entity = new BookEntity();
		entity.setName(bookInputDto.name());
		entity.setAuthor(bookInputDto.author());
		entity.setEdition(bookInputDto.edition());
		return entity;
	}

	public static BookResponseDTO toDto(BookEntity bookEntity)
	{
		return new BookResponseDTO(
				bookEntity.getId(),
				bookEntity.getName(),
				bookEntity.getAuthor(),
				bookEntity.getEdition(),
				bookEntity.getStatus()
		);
	}
}

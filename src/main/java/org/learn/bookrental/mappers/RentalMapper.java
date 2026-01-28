package org.learn.bookrental.mappers;

import org.learn.bookrental.dto.RentalResponseDTO;
import org.learn.bookrental.entitys.BookEntity;
import org.learn.bookrental.entitys.RentalEntity;

public class RentalMapper {

	public static RentalResponseDTO toDTO(RentalEntity rentalEntity)
	{
		return new RentalResponseDTO(
			rentalEntity.getId(),
			rentalEntity.getBook().getId(),
			rentalEntity.getUserId(),
			rentalEntity.getRentedAt(),
			rentalEntity.getDueAt(),
			rentalEntity.getReturnedAt()
		);
	}

	public static RentalEntity toEntity(RentalResponseDTO rentalResponseDTO, BookEntity bookEntity)
	{
		var entity = new RentalEntity();
		entity.setBook(bookEntity);
		entity.setUserId(rentalResponseDTO.userId());
		return entity;
	}
}

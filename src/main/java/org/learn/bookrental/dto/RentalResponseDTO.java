package org.learn.bookrental.dto;


import java.time.LocalDateTime;


public record RentalResponseDTO
		(
				Long id,
				Long bookId,
				Long userId,
				LocalDateTime rentedAt,
				LocalDateTime dueAt,
				LocalDateTime returnedAt
		) {
}

package org.learn.bookrental.dto;

public record BookResponseDTO(
		Long id,
		String name,
		String author,
		String edition,
		int status
) {
}

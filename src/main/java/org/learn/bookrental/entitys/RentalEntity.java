package org.learn.bookrental.entitys;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString(exclude = "book")
@Table(name = "rentals")
public class RentalEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "book_id")
	private BookEntity book;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "rented_at")
	private LocalDateTime rentedAt;

	@Column(name = "due_at")
	private LocalDateTime dueAt;

	@Column(name = "returned_at")
	private LocalDateTime returnedAt;
}

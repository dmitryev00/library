package org.learn.bookrental.entitys;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString(exclude = "rentals")
@Table(name = "books")
public class BookEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String author;
	private String edition;
	private int status;

	@OneToMany(mappedBy = "book")
	@JsonIgnore
	private List<RentalEntity> rentals = new ArrayList<>();

}

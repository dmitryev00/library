package org.learn.bookrental.controllers;


import org.learn.bookrental.dto.RentalResponseDTO;
import org.learn.bookrental.services.RentalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rent")
public class RentalController {

	RentalService rentalService;

	public RentalController(RentalService rentalService)
	{
		this.rentalService = rentalService;
	}


	@PostMapping("/{name}")
	public void rentBook(@PathVariable String name)
	{
		rentalService.rentBook(name);
	}

	@PostMapping("/return/{id}")
	public void returnBook(@PathVariable Long id)
	{
		rentalService.returnBook(id);
	}

	@GetMapping()
	public List<RentalResponseDTO> getAllRentals()
	{
		return rentalService.getAllRentals();
	}
}

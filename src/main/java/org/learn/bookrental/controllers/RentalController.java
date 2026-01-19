package org.learn.bookrental.controllers;


import org.learn.bookrental.services.RentalService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

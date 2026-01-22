package com.bridgelabz.springsecurity.addressbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.springboot.addressbook.dto.BookRequestDTO;
import com.bridgelabz.springboot.addressbook.dto.ResponseDTO;
import com.bridgelabz.springboot.addressbook.service.AddressBookAppService;

import jakarta.validation.Valid;

@RestController
public class AddressBookAppController {
	@Autowired
	private AddressBookAppService addressBookAppService;

	@PostMapping
	public ResponseDTO addbook(@Valid @RequestBody BookRequestDTO bookRequestDTO) {
		return addressBookAppService.addBook(bookRequestDTO);
	}

	@GetMapping("/{bookId}")
	public ResponseDTO getBookById(@PathVariable int bookId) {
		return addressBookAppService.getBookById(bookId);
	}

	@GetMapping
	public List<ResponseDTO> getAllBooks() {
		return addressBookAppService.getAllBooks();
	}

	@PutMapping
	public ResponseDTO updateBook(@RequestParam int bookId, @Valid @RequestBody BookRequestDTO bookRequestDto) {
		return addressBookAppService.updateBookById(bookId, bookRequestDto);
	}

	@DeleteMapping
	public String deleteBook(@RequestParam int bookId) {
		addressBookAppService.deleteBookById(bookId);
		return "Book deleted successfully";
	}

}

package com.bridgelabz.springsecurity.addressbook.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.springboot.addressbook.dto.BookRequestDTO;
import com.bridgelabz.springboot.addressbook.dto.ResponseDTO;

@Service
public interface IAddressBookAppService {
	ResponseDTO addBook(BookRequestDTO bookRequestDto);

	ResponseDTO getBookById(int bookId);

	List<ResponseDTO> getAllBooks();

	ResponseDTO updateBookById(int bookId, BookRequestDTO bookRequestDto);

	void deleteBookById(int bookId);

}

package com.bridgelabz.springsecurity.addressbook.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.springboot.addressbook.dto.BookRequestDTO;
import com.bridgelabz.springboot.addressbook.dto.ResponseDTO;
import com.bridgelabz.springboot.addressbook.exception.BookNotFoundException;
import com.bridgelabz.springboot.addressbook.model.Book;
import com.bridgelabz.springboot.addressbook.repository.AddressBookAppRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AddressBookAppService implements IAddressBookAppService {
	@Autowired
	private AddressBookAppRepository addressBookAppRepository;
	
	@Autowired
    private ModelMapper modelMapper;
	
	 @Override
	    public ResponseDTO addBook(BookRequestDTO bookRequestDto) {

	        Book book = modelMapper.map(bookRequestDto, Book.class);
	        Book savedBook = addressBookAppRepository.save(book);

	        return modelMapper.map(savedBook, ResponseDTO.class);
	    }
	 
	 @Override
	    public ResponseDTO getBookById(int bookId) {

	        Optional<Book> optionalBook = addressBookAppRepository.findById(bookId);

	        if (optionalBook.isPresent()) {
	            Book book = optionalBook.get();
	            return modelMapper.map(book, ResponseDTO.class);
	        } else {
	            throw new EntityNotFoundException("Book not found with id: " + bookId);
	        }
	    }
	 
	 @Override
	    public List<ResponseDTO> getAllBooks() {

	        List<Book> bookList = addressBookAppRepository.findAll();
	        List<ResponseDTO> responseList = new ArrayList<>();

	        for (int i = 0; i < bookList.size(); i++) {
	            Book book = bookList.get(i);
	            ResponseDTO dto = modelMapper.map(book, ResponseDTO.class);
	            responseList.add(dto);
	        }

	        return responseList;
	    }
	 
	 @Override
	    public ResponseDTO updateBookById(int bookId, BookRequestDTO bookRequestDto) {

	        Optional<Book> optionalBook = addressBookAppRepository.findById(bookId);

	        if (optionalBook.isPresent()) {
	            Book book = optionalBook.get();

	            modelMapper.map(bookRequestDto, book);
	            Book updatedBook = addressBookAppRepository.save(book);

	            return modelMapper.map(updatedBook, ResponseDTO.class);
	        } else {
	            throw new BookNotFoundException("Book not found with id: " + bookId);
	        }
	    }
	 
	 @Override
	    public void deleteBookById(int bookId) {

	        Optional<Book> optionalBook = addressBookAppRepository.findById(bookId);

	        if (optionalBook.isPresent()) {
	        	addressBookAppRepository.delete(optionalBook.get());
	        } else {
	            throw new BookNotFoundException("Book not found with id: " + bookId);
	        }
	    }

	 
	 

}

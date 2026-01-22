package com.bridgelabz.springsecurity.addressbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.springboot.addressbook.model.Book;

@Repository
public interface AddressBookAppRepository extends JpaRepository<Book, Integer> {

}

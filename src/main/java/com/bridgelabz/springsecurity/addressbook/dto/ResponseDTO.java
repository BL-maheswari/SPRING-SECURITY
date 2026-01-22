package com.bridgelabz.springsecurity.addressbook.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {
	
	private String bookName;
	private String bookAuthor;
	private String bookGenere;
	private int bookPrice;

	

}

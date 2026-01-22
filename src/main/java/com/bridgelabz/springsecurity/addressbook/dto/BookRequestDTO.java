package com.bridgelabz.springsecurity.addressbook.dto;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class BookRequestDTO {
	
	@NotBlank(message = "Book name must not be empty")
	private String bookName;
	
	@NotBlank(message = "Author name must not be empty")
    private String bookAuthor;

    
	@NotBlank(message = "Book genre must not be empty")
	private String bookGenere;
	
	@NotNull(message = "Book price is required")
    @Min(value = 1, message = "Book price must be greater than 0")
    private  int bookPrice;

}

package com.bl.jwtauthentication.model;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	 private String userID;
	    private String name;
	    private String password;
	
}

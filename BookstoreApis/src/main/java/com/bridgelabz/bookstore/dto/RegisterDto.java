package com.bridgelabz.bookstore.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@NoArgsConstructor
public class RegisterDto {
	
	public RegisterDto(String string, String string2, String string3, long l) {
		
	}

	private String name;
	
	private String email;
	
	private String password;
	
	private Long mobileNumber;




}

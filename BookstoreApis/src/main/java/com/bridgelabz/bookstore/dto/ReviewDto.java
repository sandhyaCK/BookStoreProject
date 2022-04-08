package com.bridgelabz.bookstore.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ReviewDto {

	@NotNull
	private Integer rating;
	
	@NotNull
	private String review;
}

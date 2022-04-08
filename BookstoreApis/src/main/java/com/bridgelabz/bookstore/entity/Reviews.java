package com.bridgelabz.bookstore.entity;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bridgelabz.bookstore.dto.ReviewDto;


import lombok.Data;


@Data
@Entity
@Table(name = "Reviews")

public class Reviews {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reviewId;
	private String review;
	private int rating;
	private LocalDateTime createdAt;
	

	@OneToOne
	@JoinTable(name="rating_review_user", joinColumns = @JoinColumn(name="ratingReviewId"),
	inverseJoinColumns = @JoinColumn(name="user_id"))
	private Users user;

//	public Reviews(ReviewDto review) {
//		this.rating = review.getRating();
//		this.review = review.getReview();
//	}

	
	 

}

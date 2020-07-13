package com.Spring.Repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.Spring.Bean.PassengerRating;

public interface PassengerRatingRepository extends CrudRepository<PassengerRating, String> {
	ArrayList<PassengerRating> findByPassengerId(String passengerId);
}

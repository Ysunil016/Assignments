package com.Spring.Repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.Spring.Bean.DriverRating;

public interface DriverRatingRepository extends CrudRepository<DriverRating, String> {
	ArrayList<DriverRating> findByDriverId(String driverId);
}

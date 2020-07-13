package com.Spring.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Spring.Bean.User;

public interface UserRepository extends CrudRepository<User, String> {

	List<User> findByUsername(String username);

}

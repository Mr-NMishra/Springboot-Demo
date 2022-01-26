package com.mishra.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mishra.entities.User;

public interface UserRepository extends CrudRepository<User, Integer>{

	@Query("select u from User u where u.email = :USER_EMAIL")
	public User getUserByUserName(@Param("USER_EMAIL") String email);
}

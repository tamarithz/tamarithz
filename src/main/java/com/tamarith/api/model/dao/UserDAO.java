package com.tamarith.api.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.tamarith.api.model.entity.User;

public interface UserDAO extends CrudRepository<User, Integer>{

	
}
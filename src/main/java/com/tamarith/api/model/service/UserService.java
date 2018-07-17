package com.tamarith.api.model.service;

import java.util.List;

import com.tamarith.api.model.entity.User;

public interface UserService {

		public List<User> getUsers();

		public void saveUser(User theUser);

		public User getUser(Integer theId);

		public void deleteUser(Integer theId);
}

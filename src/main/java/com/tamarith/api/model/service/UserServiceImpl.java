package com.tamarith.api.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tamarith.api.model.dao.UserDAO;
import com.tamarith.api.model.entity.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDAO;
	
	/**
	 * Método para obtener todos los empleados
	 */
	@Override
	@Transactional(readOnly=true)
	public List<User> getUsers() {
		return (List<User>) userDAO.findAll();
	}
	/**
	 * Método para guardar un empleado
	 */
	@Override
	@Transactional
	public void saveUser(User theUser) {
		userDAO.save(theUser);	
	}
	/**
	 * Método para obtener un empleado por su id
	 */
	@Override
	@Transactional(readOnly=true)
	public User getUser(Integer theId) {
		return userDAO.findById(theId).get();
	}

	/**
	 * Método para eliminar un empleado
	 * 
	 * TODO aviso antes de realizar esta acción: en vista (Angular)
	 */
	@Override
	@Transactional
	public void deleteUser(Integer theId) {
		userDAO.deleteById(theId);		
	}
}

package com.sapient.aem.service;

import com.sapient.aem.exception.UserException;
import com.sapient.aem.model.Role;
import com.sapient.aem.model.User;

public interface UserService {
	public abstract Boolean isValidUser(String userName,String password, Role role) throws UserException;
	public abstract Integer addUser(User user) throws UserException;
}

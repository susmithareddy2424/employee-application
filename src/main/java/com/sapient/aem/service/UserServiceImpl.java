package com.sapient.aem.service;

import com.sapient.aem.dao.UserDAO;
import com.sapient.aem.dao.UserDaoImpl;
import com.sapient.aem.exception.UserException;
import com.sapient.aem.model.Role;
import com.sapient.aem.model.User;

public class UserServiceImpl implements UserService{
	private UserDAO userDAO=  new UserDaoImpl();

	@Override
	public Boolean isValidUser(String userName, String password, Role role) throws UserException{
		try {
			return userDAO.isValidUser(userName, password, role);
		}catch(Exception e){
			throw new UserException(e.getMessage(),e);
		}
	}

	@Override
	public Integer addUser(User user) throws UserException{
		try {
			return userDAO.addUser(user);
		}catch(Exception e){
			throw new UserException(e.getMessage(),e);
		}
	}

}

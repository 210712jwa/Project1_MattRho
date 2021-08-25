package com.revature.service;

import com.revature.dao.ersUsersDAO;
import com.revature.dto.LoginDTO;
import com.revature.exception.BadParameterException;
import com.revature.exception.InvalidLoginException;
import com.revature.model.ERSUsers;

public class LoginService {
	private ersUsersDAO ersUserDao;
	
	public LoginService() {
		this.ersUserDao = new ersUsersDAO();
	}
	public ERSUsers login(LoginDTO loginDTO) throws BadParameterException, InvalidLoginException {
		if (loginDTO.getUsername().trim().equals("") && loginDTO.getPassword().trim().equals("")) {
			throw new BadParameterException("Username and password cannot be blank");
			
		}
		if (loginDTO.getUsername().trim().equals("")) {
			throw new BadParameterException("Username cannot be blank");
		}
		if (loginDTO.getPassword().trim().equals("")) {
			throw new BadParameterException("Password cannot be blank");
		}
		ERSUsers ersUser = ersUserDao.getUserByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());
		
		if (ersUser == null) {
			throw new InvalidLoginException("You provided incorrect credentials when attempting to log in");
		}
		return ersUser;
	}
}

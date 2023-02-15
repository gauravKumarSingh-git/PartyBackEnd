package com.party.service;

import com.party.dto.UserDTO;
import com.party.exception.PartyException;

public interface UserService {
	public String addUser(UserDTO user) throws PartyException;
	public String updateUser(UserDTO user) throws PartyException;
	public void deleteUser(int userId) throws PartyException;
	public UserDTO getUserById(int userId) throws PartyException;
}

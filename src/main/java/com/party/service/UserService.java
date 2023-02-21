package com.party.service;

import java.util.List;

import com.party.dto.UserDTO;
import com.party.exception.PartyException;

public interface UserService {
	public String addUser(UserDTO user) throws PartyException;
	public String updateUser(UserDTO user) throws PartyException;
	public void deleteUser(int userId) throws PartyException;
	public UserDTO getUserById(int userId) throws PartyException;
	public List<UserDTO> getUsers() throws PartyException;
	public UserDTO getUserByUserNameAndPassword(String userName, String password) throws PartyException;
}

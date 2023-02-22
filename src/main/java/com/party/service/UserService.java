package com.party.service;

import java.util.List;

import com.party.dto.UserDTO;
import com.party.entity.Users;
import com.party.exception.PartyException;

public interface UserService {
	/**
	 * To add user to database
	 * @param user
	 * @return String
	 * @throws PartyException
	 */
	public String addUser(UserDTO user) throws PartyException;
	
	/**
	 * To update user present in database
	 * @param user
	 * @return String
	 * @throws PartyException
	 */
	public String updateUser(UserDTO user) throws PartyException;
	
	/**
	 * To delete user present in database
	 * @param userId
	 * @throws PartyException
	 */
	public void deleteUser(int userId) throws PartyException;
	
	/**
	 * To get user based on id
	 * @param userId
	 * @return UserDTO
	 * @throws PartyException
	 */
	public UserDTO getUserById(int userId) throws PartyException;
	
	/**
	 * To get user based on userName,password
	 * @param userId
	 * @return UserDTO
	 * @throws PartyException
	 */
	
	public UserDTO getUserByUserNameAndPassword(String userName, String password) throws PartyException;
	
	/**
	 * To get all users
	 * @return
	 * @throws PartyException
	 */

	List<UserDTO> getUsers() throws PartyException;
	 
}

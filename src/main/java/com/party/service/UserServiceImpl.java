package com.party.service;

import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.party.dto.UserDTO;
import com.party.entity.Users;
import com.party.exception.PartyException;
import com.party.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	public static final Log LOGGER = LogFactory.getLog(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public String addUser(UserDTO user) throws PartyException {
		LOGGER.info(user);
		modelMapper.getConfiguration()
		  .setMatchingStrategy(MatchingStrategies.LOOSE);
		Users userEntity =  modelMapper.map(user, Users.class);
		Optional<Users> fromRepo = userRepository.findById(user.getUserId());
		if(fromRepo.isPresent()) {
			throw new PartyException("Service.EVENT_ALREADY_EXISTS");
		}
		userRepository.save(userEntity);
		return "Saved";
	}

	@Override
	public String updateUser(UserDTO user) throws PartyException {
		Optional<Users> fromRepo = userRepository.findById(user.getUserId());
		Users userFromRepo = fromRepo.orElseThrow(() -> new PartyException("Service.USER_NOT_FOUND"));
		userFromRepo.setUserName(user.getUserName());
		userFromRepo.setPassword(user.getPassword());
		
		return "Updated";
		
	}

	@Override
	public void deleteUser(int userId) throws PartyException {
		Optional<Users> fromRepo = userRepository.findById(userId);
		Users user = fromRepo.orElseThrow(() -> new PartyException("Service.USER_NOT_FOUND"));
		userRepository.delete(user);
		
	}

	@Override
	public UserDTO getUserById(int userId) throws PartyException {
		Optional<Users> fromRepo = userRepository.findById(userId);
		Users user = fromRepo.orElseThrow(() -> new PartyException("Service.USER_NOT_FOUND"));
		UserDTO userDTO = modelMapper.map(user, UserDTO.class);
		return userDTO;
	}

}


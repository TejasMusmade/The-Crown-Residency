package com.crown.services;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.crown.daos.IUserDao;
import com.crown.daos.IIdproofDao;
import com.crown.dtos.ChangePasswordDto;
import com.crown.dtos.Credentials;
import com.crown.dtos.DtoEntityConverter;
import com.crown.dtos.RoomsCategoryDto;
import com.crown.dtos.RoomsDto;
import com.crown.dtos.UserDto;
import com.crown.entities.Idproof;
import com.crown.entities.Rooms;
import com.crown.entities.User;
import com.crown.utils.SecurityConfig;

@Transactional
@Service
public class UserServices {

	@Autowired
	private IUserDao userDao;

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private DtoEntityConverter converter;


	public UserDto findUserById(int id) {
		User user=null;
		UserDto userDto=null;
		try {
			 user = userDao.findByUserId(id);
			 userDto = converter.UserEntityToUserDto(user);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return userDto;
	}

	public UserDto findUserByEmail(String email) {
		User user = null;
		UserDto userDto = null;
		try {
			user = userDao.findByEmail(email);
			userDto = converter.UserEntityToUserDto(user);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return userDto;
	}

	public UserDto findUserByEmailAndPassword(Credentials cred) {
		User dbuser = null;
		try {
			dbuser = userDao.findByEmail(cred.getEmail());
		}catch (Exception e) {
			e.printStackTrace();
		}
		String rawPassword = cred.getPassword();
		if (dbuser != null && passwordEncoder.matches(rawPassword, dbuser.getPassword())) {
			UserDto validUser = converter.UserEntityToUserDto(dbuser);
			validUser.setPassword("********");
			return validUser;
		}
		return null;
	}

	public UserDto saveUser(UserDto userdto) {
		
		if(userDao.findByEmail(userdto.getEmail())!=null) {
			return null;
		}
		
		String rawpassword = userdto.getPassword();
		String encodedPassword = passwordEncoder.encode(rawpassword);
		userdto.setPassword(encodedPassword);
		User userToBeSaved = converter.UserDtoToUserEntity(userdto);
		userToBeSaved.setIdproof(1);
		userToBeSaved.setRole("user");
		User savedUser=null;
		UserDto savedUserDto =null;
		try {
			savedUser = userDao.save(userToBeSaved);
			savedUserDto = converter.UserEntityToUserDto(savedUser);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		savedUserDto.setPassword("********");
		return savedUserDto;
	}

	public Map<String, Object> upadateUser(UserDto userdto) {
		if (userDao.existsById(userdto.getUserId())) {
			User updateUser = converter.UserDtoToUserEntity(userdto);
			User dbUser=null;
			try {
				dbUser =userDao.findByUserId(userdto.getUserId());
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			dbUser.setFirstName(updateUser.getFirstName());
			dbUser.setLastName(updateUser.getLastName());
			dbUser.setEmail(updateUser.getEmail());
			dbUser.setIdproof(updateUser.getIdproof());
			dbUser.setGender(updateUser.getGender());
			dbUser.setMobile(updateUser.getMobile());
			dbUser.setAddress(updateUser.getAddress());
			dbUser.setCity(updateUser.getCity());
			dbUser.setState(updateUser.getState());
			dbUser.setZipcode(updateUser.getZipcode());
			User UpadtedUser = userDao.save(dbUser);
			System.out.println(UpadtedUser);
			UserDto updatedDto = converter.UserEntityToUserDto(UpadtedUser);
			return Collections.singletonMap("updatedRows", 1);

		}
		return Collections.singletonMap("updatedRows", 0);
	}
	
	public Map<String, Object> upadateUserRole(int id,UserDto userdto) {
		if (userDao.existsById(id)) {
			System.out.println(userdto);
//			User updateUser = converter.UserDtoToUserEntity(userdto);
			User dbUser=null;
			try {
			dbUser =userDao.findByUserId(id);
			System.out.println(dbUser);
			}catch (Exception e) {
				e.printStackTrace();
			}
			int idproof=dbUser.getIdproof();
			
			dbUser.setIdproof(idproof);
			dbUser.setRole(userdto.getRole());
			User UpadtedUser = userDao.save(dbUser);
			System.out.println(UpadtedUser);
			UserDto updatedDto = converter.UserEntityToUserDto(UpadtedUser);
			return Collections.singletonMap("updatedRows", 1);

		}
		return Collections.singletonMap("updatedRows", 0);
	}

//	public Map<String, Object> upadateUserRole(int id,UserDto userdto) {
//		if (userDao.existsById(userdto.getUserId())) {
//			System.out.println(userdto);
////			User updateUser = converter.UserDtoToUserEntity(userdto);
//			User dbUser=null;
//			try {
//			dbUser =userDao.findByUserId(userdto.getUserId());
//			System.out.println(dbUser);
//			}catch (Exception e) {
//				e.printStackTrace();
//			}
//			int idproof=dbUser.getIdproof();
//			
//			dbUser.setIdproof(idproof);
//			dbUser.setRole(userdto.getRole());
//			User UpadtedUser = userDao.save(dbUser);
//			System.out.println(UpadtedUser);
//			UserDto updatedDto = converter.UserEntityToUserDto(UpadtedUser);
//			return Collections.singletonMap("updatedRows", 1);
//
//		}
//		return Collections.singletonMap("updatedRows", 0);
//	}
	
	
	public Map<String, Object> upadateUserPassword(ChangePasswordDto changePasswordDto) {
		if(userDao.findByUserId(changePasswordDto.getUserId()) != null) {
			int userId = changePasswordDto.getUserId();
			User user=null;
			try{
				user = userDao.findByUserId(userId);
			}catch (Exception e) {
				e.printStackTrace();
			}
			if(passwordEncoder.matches(changePasswordDto.getOldPassword(), user.getPassword())) {
				user.setPassword(passwordEncoder.encode(changePasswordDto.getNewPassword()));
				User userPasswordChanged = userDao.save(user);
				return Collections.singletonMap("updatedRows", 1);
			}

			return Collections.singletonMap("updatedRows", 0);
			
		}
		return Collections.singletonMap("updatedRows", 0);
	}

	public Map<String, Object> deleteUserById(int userId) {
		if (userDao.existsById(userId)) {
			userDao.deleteById(userId);
			return Collections.singletonMap("deletedRows", 1);
		}
		return Collections.singletonMap("deletedRows", 0);
	}

//	public List<User> findAllUsers() {
//		List<User> list = userDao.findAll();
//		return list;
//	}
//	
	
	public List<UserDto> findAllUsers(){
		List<User> usersList = null;
		List<UserDto> usersDtoList =null;
		try {
			usersList = userDao.findAll();
			System.out.println(usersList);
			usersDtoList = usersList.stream().map(User -> converter.UserEntityToUserDto(User)).collect(Collectors.toList());
			System.out.println(usersDtoList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (UserDto usersDto : usersDtoList) {
			usersDto.setPassword("********");
		}
		return usersDtoList;
	}
	
	public int findUsersCount(){
		int usersCount = userDao.findUserCount();
		System.out.println(usersCount);
		return usersCount;
	}

}

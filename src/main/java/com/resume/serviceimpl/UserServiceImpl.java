package com.resume.serviceimpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resume.dto.UserDto;
import com.resume.entity.User;
import com.resume.repository.UserRepository;
import com.resume.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDto registerUser(UserDto userDto) {
		User user=new User();
		BeanUtils.copyProperties(userDto, user);
		userRepository.save(user);
		return userDto;
	}

}

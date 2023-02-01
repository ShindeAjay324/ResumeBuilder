package com.resume.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.resume.entity.User;
import com.resume.MyUserDetails;
import com.resume.exception.UserNameNotFoundException;
import com.resume.repository.UserRepository;
@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userRepository.findByUserName(username);
		if (user==null) {
			throw new UserNameNotFoundException("user 404");
		}
		return new MyUserDetails(user);
	}

	
}

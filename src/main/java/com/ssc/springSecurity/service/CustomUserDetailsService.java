package com.ssc.springSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ssc.springSecurity.dto.CustomUserDetails;
import com.ssc.springSecurity.entity.UserEntity;
import com.ssc.springSecurity.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	// 이후 생성자 주입 방식으로 변경, final 키워드도 넣어주면 된다. 
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserEntity userData = userRepository.findByUsername(username);
		
		if(userData != null) {
			return new CustomUserDetails(userData);
		}
		
		return null;
	}
}

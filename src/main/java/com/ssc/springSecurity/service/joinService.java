package com.ssc.springSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ssc.springSecurity.dto.joinDTO;
import com.ssc.springSecurity.entity.UserEntity;
import com.ssc.springSecurity.repository.UserRepository;

@Service
public class joinService {
	
	// To-Do 현재 필드 주입방식에서 생성자 주입 방식으로 바꿀 것
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public void joinProcess(joinDTO joinDTO) {
		
		// 이미 동일한 username을 가진 회원이 있는지 검증
		
		
		UserEntity data = new UserEntity();
		
		data.setUsername(joinDTO.getUsername());
		data.setPassword(bCryptPasswordEncoder.encode(joinDTO.getPassword()));
		data.setRole("ROLE_ADMIN");
		
		userRepository.save(data);
	}
}

package com.ssc.springSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssc.springSecurity.dto.joinDTO;
import com.ssc.springSecurity.service.JoinService;

@Controller
public class JoinController {
	
	@Autowired
	private JoinService joinService; 
	
	@GetMapping("/join")
	public String joinP() {
		
		return "join";
	}
	
	@PostMapping("/joinProc")
	public String joinProcess(joinDTO JoinDTO) {
		
		joinService.joinProcess(JoinDTO);
		
		
		return "redirect:/login";
	}
}

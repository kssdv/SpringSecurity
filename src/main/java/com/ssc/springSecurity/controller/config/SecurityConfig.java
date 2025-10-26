package com.ssc.springSecurity.controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		// 깔대기 형태로 접근 권한 설정을 잘 해야한다. 
		http
				.authorizeHttpRequests((auth) -> auth
						.requestMatchers("/", "/login").permitAll() // main 페이지, 로그인 페이지 누구나 접근 가능하게 설정
						.requestMatchers("/admin").hasRole("ADMIN")
						.requestMatchers("/my/**").hasAnyRole("ADMIN", "USER") // ID가 오는 위치 (와일드 카드 **)
						.anyRequest().authenticated()
			);
		
		http
				.formLogin((auth) -> auth.loginPage("/login")
					.loginProcessingUrl("/loginProc")
					.permitAll()
			);
		
		http
				.csrf((auth) -> auth.disable()); // 개발 시에만 잠시 TOKEN OFF
		
		return http.build();
	}
}

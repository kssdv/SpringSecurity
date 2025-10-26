package com.ssc.springSecurity.dto;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ssc.springSecurity.entity.UserEntity;

public class CustomUserDetails implements UserDetails{
	
	private UserEntity userEntity;

	public CustomUserDetails(UserEntity userEntity) {
		
		this.userEntity = userEntity;
	}

	// 사용자의 특정한 권한에 대해 return 해주는 메소드 
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collection = new ArrayList<>();

        collection.add(new GrantedAuthority() {

            @Override
            public String getAuthority() {

                return userEntity.getRole();
            }
        });

        return collection;

	}

	@Override
    public String getPassword() {
        return userEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return userEntity.getUsername();
    }

// 만료 관련 부분이 없어서 일단 true로 설정하면 만료 없이 사용할 수 있다. 
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}

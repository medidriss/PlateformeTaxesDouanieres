package com.enit.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.enit.entites.User;

public class CustomUserDetails implements UserDetails {
    private User user;
    
	public CustomUserDetails(User user) {
		super();
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	return	AuthorityUtils.createAuthorityList(user.getRole().toString());
	}

	@Override
	public String getPassword() {
		
		return user.getPassword();
	}

	@Override
	public String getUsername() {
	return user.getUsername();
	}

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

	public User getUser() {
		return user;
	}



}

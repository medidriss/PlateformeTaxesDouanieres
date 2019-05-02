package com.enit.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.enit.dao.UserRepository;
import com.enit.entites.User;
@Service
public class CustomUserDetailsService implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 User user = userRepository.findUserByUsername(username);
	        if (user == null) {
	            throw new UsernameNotFoundException(username);
	        }
	        return new CustomUserDetails(user);
	}

}

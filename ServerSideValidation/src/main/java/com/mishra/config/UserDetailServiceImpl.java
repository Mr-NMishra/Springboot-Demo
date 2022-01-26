package com.mishra.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.mishra.dao.UserRepository;
import com.mishra.entities.User;

public class UserDetailServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		// fetching user from database
			User user= repository.getUserByUserName(username);
			if(user==null) {
				throw new UsernameNotFoundException("COuld not found user");
			}
			
			CustomUserDetail customUserDetail= new CustomUserDetail(user);
		return customUserDetail;
	}

}

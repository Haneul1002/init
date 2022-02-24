package com.init.resume.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.init.resume.main.mapper.UserMapper;
import com.init.resume.main.vo.CustomUserDetails;
import com.init.resume.main.vo.UserVO;


@Service("UserService")
/* 회원 정보 관련 작업 */
public class UserService implements UserDetailsService {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		CustomUserDetails users = userMapper.getUserById(username);
		if(users == null) {
			 throw new UsernameNotFoundException("username " + username + " not found");
		}
		System.out.println("**************Found user***************");
		System.out.println("id : " + users.getUsername());
		return users;
	}
	
	
	public void RegisterUser(UserVO userVO) {
				
		System.out.println("Befor Encoder : " + userVO.getPassword());
		String endcodedPassword = bcryptPasswordEncoder.encode(userVO.getPassword());
		System.out.println("After Encoder : " + endcodedPassword);
		System.out.println("Resister User Info : " + userVO);
        
		userVO.setPassword(endcodedPassword);	
		userMapper.RegisterUser(userVO);
		
	}
}
package com.init.resume.main.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.init.resume.main.vo.CustomUserDetails;
import com.init.resume.main.vo.UserVO;


@Mapper
public interface UserMapper {

	public void RegisterUser(UserVO userVO);
	
	public CustomUserDetails getUserById(String username);

}

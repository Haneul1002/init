package com.init.resume.main.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.init.resume.main.vo.FileAttachVO;
import com.init.resume.main.vo.ImageVO;
import com.init.resume.main.vo.UserInfoVO;

@Mapper
public interface UserInfoMapper {
	

    List<UserInfoVO> getAllUser(HashMap<String, Object> hashMap);

    int deleteUser(UserInfoVO user) throws Exception;

    int saveUser(UserInfoVO user) throws Exception;

    int updateUser(UserInfoVO user) throws Exception;

    int fileInsert(FileAttachVO file) throws Exception;

    int fileDelete(FileAttachVO file) throws Exception;

    int imgInsert(ImageVO img) throws Exception;

    int imgDelete(ImageVO img) throws Exception;
}

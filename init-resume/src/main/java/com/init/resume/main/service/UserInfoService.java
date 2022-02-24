package com.init.resume.main.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.init.resume.main.mapper.UserInfoMapper;
import com.init.resume.main.vo.FileAttachVO;
import com.init.resume.main.vo.ImageVO;
import com.init.resume.main.vo.UserInfoVO;

@Service("UserInfoService")
public class UserInfoService {
    
    @Autowired
    public UserInfoMapper userInfoMapper;

    public List<UserInfoVO> getAllUser(HashMap<String, Object> hashMap){
        return userInfoMapper.getAllUser(hashMap);
    }

    public int updateUser(UserInfoVO user)  throws Exception{
        return userInfoMapper.updateUser(user);
    }

    public int deleteUser(UserInfoVO user) throws Exception {
        return userInfoMapper.deleteUser(user);
    }

    public int saveUser(UserInfoVO user) throws Exception {
        return userInfoMapper.saveUser(user);
    }

    public int fileInsert(FileAttachVO file) throws Exception {
        return userInfoMapper.fileInsert(file);
    }

    public int fileDelete(FileAttachVO file) throws Exception {
        return userInfoMapper.fileDelete(file);
    }
    
    public int imgInsert(ImageVO img) throws Exception {
        return userInfoMapper.imgInsert(img);
    }

    public int imgDelete(ImageVO img) throws Exception {
        return userInfoMapper.imgDelete(img);
    }
}

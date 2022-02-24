package com.init.resume.main.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.init.resume.main.mapper.EducationMapper;
import com.init.resume.main.vo.EducationVO;

@Service("EducationService")
public class EducationService {
    
    @Autowired
    public EducationMapper educationMapper;

    public List<EducationVO> getAllEducation(HashMap<String, Object> hashMap){
        return educationMapper.getAllEducation(hashMap);
    }

    public int updateEducation(EducationVO education)  throws Exception{
        return educationMapper.updateEducation(education);
    }

    public int deleteEducation(EducationVO education) throws Exception {
        return educationMapper.deleteEducation(education);
    }

    public int saveEducation(EducationVO education) throws Exception {
        return educationMapper.saveEducation(education);
    }
}

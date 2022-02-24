package com.init.resume.main.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.init.resume.main.vo.EducationVO;

@Mapper
public interface EducationMapper {
    
    List<EducationVO> getAllEducation(HashMap<String, Object> hashMap);

    int deleteEducation(EducationVO education) throws Exception;

    int saveEducation(EducationVO education) throws Exception;

    int updateEducation(EducationVO education) throws Exception;
}

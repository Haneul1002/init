package com.init.resume.main.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.init.resume.main.vo.QualificationVO;

@Mapper
public interface QualificationsMapper {
    
    List<QualificationVO> getAllQualifications(HashMap<String, Object> hashMap);

    int deleteQualifications(QualificationVO qualifications) throws Exception;

    int saveQualifications(QualificationVO qualifications) throws Exception;

    int updateQualifications(QualificationVO qualifications) throws Exception;
}

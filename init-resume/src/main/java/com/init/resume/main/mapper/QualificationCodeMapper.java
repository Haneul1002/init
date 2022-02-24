package com.init.resume.main.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.init.resume.main.vo.QualificationCodeVO;



@Mapper
public interface QualificationCodeMapper {

    List<QualificationCodeVO> getAllQualification_code(HashMap<String, Object> hashMap);

    int deleteQualification_code(QualificationCodeVO qualification_code) throws Exception;

    int saveQualification_code(QualificationCodeVO qualification_code) throws Exception;

    int updateQualification_code(QualificationCodeVO qualification_code) throws Exception;
}

package com.init.resume.main.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.init.resume.main.mapper.QualificationCodeMapper;
import com.init.resume.main.vo.QualificationCodeVO;

@Service("QualificationCodeService")
public class QualificationCodeService {
    
    @Autowired
    public QualificationCodeMapper qualification_codeMapper;

    public List<QualificationCodeVO> getAllQualification_code(HashMap<String, Object> hashMap){
        return qualification_codeMapper.getAllQualification_code(hashMap);
    }

    public int updateQualification_code(QualificationCodeVO qualification_code)  throws Exception{
        return qualification_codeMapper.updateQualification_code(qualification_code);
    }

    public int deleteQualification_code(QualificationCodeVO qualification_code) throws Exception {
        return qualification_codeMapper.deleteQualification_code(qualification_code);
    }

    public int saveQualification_code(QualificationCodeVO qualification_code) throws Exception {
        return qualification_codeMapper.saveQualification_code(qualification_code);
    }
}

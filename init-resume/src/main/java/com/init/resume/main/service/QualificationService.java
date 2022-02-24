package com.init.resume.main.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.init.resume.main.mapper.QualificationsMapper;
import com.init.resume.main.vo.QualificationVO;

@Service("QualificationService")
public class QualificationService {
    
    @Autowired
    public QualificationsMapper qualificationsMapper;

    public List<QualificationVO> getAllQualifications(HashMap<String, Object> hashMap){
        return qualificationsMapper.getAllQualifications(hashMap);
    }

    public int updateQualifications(QualificationVO qualifications)  throws Exception{
        return qualificationsMapper.updateQualifications(qualifications);
    }

    public int deleteQualifications(QualificationVO qualifications) throws Exception {
        return qualificationsMapper.deleteQualifications(qualifications);
    }

    public int saveQualifications(QualificationVO qualifications) throws Exception {
        return qualificationsMapper.saveQualifications(qualifications);
    }
}

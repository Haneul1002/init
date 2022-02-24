package com.init.resume.main.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.init.resume.main.mapper.InstituteMapper;
import com.init.resume.main.vo.InstituteVO;

@Service("InstituteService")
public class InstituteService {
    
    @Autowired
    public InstituteMapper instituteMapper;

    public List<InstituteVO> getAllInstitute(HashMap<String, Object> hashMap){
        return instituteMapper.getAllInstitute(hashMap);
    }

    public int updateInstitute(InstituteVO institute)  throws Exception{
        return instituteMapper.updateInstitute(institute);
    }

    public int deleteInstitute(InstituteVO institute) throws Exception {
        return instituteMapper.deleteInstitute(institute);
    }

    public int saveInstitute(InstituteVO institute) throws Exception {
        return instituteMapper.saveInstitute(institute);
    }
}

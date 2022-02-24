package com.init.resume.main.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.init.resume.main.mapper.EduMatterMapper;
import com.init.resume.main.vo.EduMatterVO;

@Service("EduMatterService")
public class EduMatterService {
    
    @Autowired
    public EduMatterMapper eduMatterMapper;

    public List<EduMatterVO> getAllEduMatter(HashMap<String, Object> hashMap){
        return eduMatterMapper.getAllEduMatter(hashMap);
    }

    public int updateEduMatter(EduMatterVO eduMatter)  throws Exception{
        return eduMatterMapper.updateEduMatter(eduMatter);
    }

    public int deleteEduMatter(EduMatterVO eduMatter) throws Exception {
        return eduMatterMapper.deleteEduMatter(eduMatter);
    }

    public int saveEduMatter(EduMatterVO eduMatter) throws Exception {
        return eduMatterMapper.saveEduMatter(eduMatter);
    }
}

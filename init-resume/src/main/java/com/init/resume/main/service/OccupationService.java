package com.init.resume.main.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.init.resume.main.mapper.OccupationMapper;
import com.init.resume.main.vo.OccupationVO;

@Service("OccupationService")
public class OccupationService {
    
    @Autowired
    public OccupationMapper occupationMapper;


    public List<OccupationVO> getAllOccupation(HashMap<String, Object> hashMap){
        return occupationMapper.getAllOccupation(hashMap);
    }

    public int updateOccupation(OccupationVO occupation)  throws Exception{
        return occupationMapper.updateOccupation(occupation);
    }

    public int deleteOccupation(OccupationVO occupation) throws Exception {
        return occupationMapper.deleteOccupation(occupation);
    }

    public int saveOccupation(OccupationVO occupation) throws Exception {
        return occupationMapper.saveOccupation(occupation);
    }

}

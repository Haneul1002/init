package com.init.resume.main.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.init.resume.main.mapper.SpotMapper;
import com.init.resume.main.vo.SpotVO;

@Service("SpotService")
public class SpotService {
    
    @Autowired
    public SpotMapper spotMapper;

    public List<SpotVO> getAllSpot(HashMap<String, Object> hashMap){
        return spotMapper.getAllSpot(hashMap);
    }

    public int updateSpot(SpotVO spot)  throws Exception{
        return spotMapper.updateSpot(spot);
    }

    public int deleteSpot(SpotVO spot) throws Exception {
        return spotMapper.deleteSpot(spot);
    }

    public int saveSpot(SpotVO spot) throws Exception {
        return spotMapper.saveSpot(spot);
    }
}

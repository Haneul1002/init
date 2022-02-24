package com.init.resume.main.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.init.resume.main.mapper.AreaMapper;
import com.init.resume.main.vo.AreaVO;

@Service("AreaService")
public class AreaService {
    
    @Autowired
    public AreaMapper areaMapper;

    public List<AreaVO> getAllArea(HashMap<String, Object> hashMap){
        return areaMapper.getAllArea(hashMap);
    }

    public int updateArea(AreaVO area)  throws Exception{
        return areaMapper.updateArea(area);
    }

    public int deleteArea(AreaVO area) throws Exception {
        return areaMapper.deleteArea(area);
    }

    public int saveArea(AreaVO area) throws Exception {
        return areaMapper.saveArea(area);
    }
}

package com.init.resume.main.service;

import java.util.HashMap;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.init.resume.main.mapper.WorkMapper;
import com.init.resume.main.vo.WorkVO;

@Service("WorkService")
public class WorkService {
    
    @Autowired
    public WorkMapper workMapper;

    public List<WorkVO> getAllWork(HashMap<String, Object> hashMap){
        return workMapper.getAllWork(hashMap);
    }

    public int updateWork(WorkVO work)  throws Exception{
        return workMapper.updateWork(work);
    }

    public int deleteWork(WorkVO work) throws Exception {
        return workMapper.deleteWork(work);
    }

    public int saveWork(WorkVO work) throws Exception {
        return workMapper.saveWork(work);
    }
}

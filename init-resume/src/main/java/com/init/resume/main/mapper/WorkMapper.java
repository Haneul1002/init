package com.init.resume.main.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.init.resume.main.vo.WorkVO;

@Mapper
public interface WorkMapper {
    
    List<WorkVO> getAllWork(HashMap<String, Object> hashMap);

    int deleteWork(WorkVO work) throws Exception;

    int saveWork(WorkVO work) throws Exception;

    int updateWork(WorkVO work) throws Exception;
}

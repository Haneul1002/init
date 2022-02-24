package com.init.resume.main.mapper;

import java.util.HashMap;
import java.util.List;


import org.apache.ibatis.annotations.Mapper;

import com.init.resume.main.vo.OccupationVO;



@Mapper
public interface OccupationMapper {

    List<OccupationVO> getAllOccupation(HashMap<String, Object> hashMap);

    int deleteOccupation(OccupationVO occupation) throws Exception;

    int saveOccupation(OccupationVO occupation) throws Exception;

    int updateOccupation(OccupationVO occupation) throws Exception;

}


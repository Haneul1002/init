package com.init.resume.main.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.init.resume.main.vo.SpotVO;

@Mapper
public interface SpotMapper {

    List<SpotVO> getAllSpot(HashMap<String, Object> hashMap);

    int deleteSpot(SpotVO spot) throws Exception;

    int saveSpot(SpotVO spot) throws Exception;

    int updateSpot(SpotVO spot) throws Exception;
}

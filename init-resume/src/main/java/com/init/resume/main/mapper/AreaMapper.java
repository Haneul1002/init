package com.init.resume.main.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.init.resume.main.vo.AreaVO;

@Mapper
public interface AreaMapper {

    List<AreaVO> getAllArea(HashMap<String, Object> hashMap);

    int deleteArea(AreaVO area) throws Exception;

    int saveArea(AreaVO area) throws Exception;

    int updateArea(AreaVO area) throws Exception;
}

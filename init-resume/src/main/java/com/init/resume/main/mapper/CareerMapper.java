package com.init.resume.main.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.init.resume.main.vo.CareerVO;


@Mapper
public interface CareerMapper {
    
	
    List<CareerVO> getAllCareer(HashMap<String, Object> hashMap);

    int deleteCareer(CareerVO career) throws Exception;

    int saveCareer(CareerVO career) throws Exception;

    int updateCareer(CareerVO career) throws Exception;
}

package com.init.resume.main.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.init.resume.main.mapper.CareerMapper;
import com.init.resume.main.vo.CareerVO;

@Service("CareerService")
public class CareerService {
    
    @Autowired
    public  CareerMapper careerMapper;

    public List<CareerVO> getAllCareer(HashMap<String, Object> hashMap){
        return careerMapper.getAllCareer(hashMap);
    }

    public int updateCareer(CareerVO career)  throws Exception{
        return careerMapper.updateCareer(career);
    }

    public int deleteCareer(CareerVO career) throws Exception {
        return careerMapper.deleteCareer(career);
    }

    public int saveCareer(CareerVO career) throws Exception {
        return careerMapper.saveCareer(career);
    }
}

package com.init.resume.main.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.init.resume.main.vo.PrizeVO;

@Mapper
public interface PrizeMapper {
    
    List<PrizeVO> getAllPrize(HashMap<String, Object> hashMap);

    int deletePrize(PrizeVO prize) throws Exception;

    int savePrize(PrizeVO prize) throws Exception;

    int updatePrize(PrizeVO prize) throws Exception;
}

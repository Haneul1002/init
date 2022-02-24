package com.init.resume.main.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.init.resume.main.mapper.PrizeMapper;
import com.init.resume.main.vo.PrizeVO;

@Service("PrizeService")
public class PrizeService {
    
    @Autowired
    public PrizeMapper prizeMapper;

    public List<PrizeVO> getAllPrize(HashMap<String, Object> hashMap){
        return prizeMapper.getAllPrize(hashMap);
    }

    public int updatePrize(PrizeVO prize)  throws Exception{
        return prizeMapper.updatePrize(prize);
    }

    public int deletePrize(PrizeVO prize) throws Exception {
        return prizeMapper.deletePrize(prize);
    }

    public int savePrize(PrizeVO prize) throws Exception {
        return prizeMapper.savePrize(prize);
    }
}

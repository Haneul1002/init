package com.init.resume.main.mapper;

import java.util.HashMap;
import java.util.List;


import org.apache.ibatis.annotations.Mapper;

import com.init.resume.main.vo.EduMatterVO;

@Mapper
public interface EduMatterMapper {
    
    List<EduMatterVO> getAllEduMatter(HashMap<String, Object> hashMap);

    int deleteEduMatter(EduMatterVO eduMatter) throws Exception;

    int saveEduMatter(EduMatterVO eduMatter) throws Exception;

    int updateEduMatter(EduMatterVO eduMatter) throws Exception;
}

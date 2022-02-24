package com.init.resume.main.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.init.resume.main.vo.InstituteVO;

@Mapper
public interface InstituteMapper {

    List<InstituteVO> getAllInstitute(HashMap<String, Object> hashMap);

    int deleteInstitute(InstituteVO institute) throws Exception;

    int saveInstitute(InstituteVO institute) throws Exception;

    int updateInstitute(InstituteVO institute) throws Exception;
}

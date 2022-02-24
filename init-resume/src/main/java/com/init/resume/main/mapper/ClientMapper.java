package com.init.resume.main.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.init.resume.main.vo.ClientVO;


@Mapper
public interface ClientMapper {

    List<ClientVO> getAllClient(HashMap<String, Object> hashMap);

    int deleteClient(ClientVO client) throws Exception;

    int saveClient(ClientVO client) throws Exception;

    int updateClient(ClientVO client) throws Exception;
}

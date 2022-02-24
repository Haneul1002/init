package com.init.resume.main.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.init.resume.main.mapper.ClientMapper;
import com.init.resume.main.vo.ClientVO;

@Service("ClientService")
public class ClientService {
    
    @Autowired
    public ClientMapper clientMapper;

    public List<ClientVO> getAllClient(HashMap<String, Object> hashMap){
        return clientMapper.getAllClient(hashMap);
    }

    public int updateClient(ClientVO client)  throws Exception{
        return clientMapper.updateClient(client);
    }

    public int deleteClient(ClientVO client) throws Exception {
        return clientMapper.deleteClient(client);
    }

    public int saveClient(ClientVO client) throws Exception {
        return clientMapper.saveClient(client);
    }
}

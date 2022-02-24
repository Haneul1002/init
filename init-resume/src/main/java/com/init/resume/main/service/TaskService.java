package com.init.resume.main.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.init.resume.main.mapper.TaskMapper;
import com.init.resume.main.vo.TaskVO;

@Service("TaskService")
public class TaskService {
    
    @Autowired
    public TaskMapper taskMapper;

    public List<TaskVO> getAllTask(HashMap<String, Object> hashMap){
        return taskMapper.getAllTask(hashMap);
    }

    public int updateTask(TaskVO task)  throws Exception{
        return taskMapper.updateTask(task);
    }

    public int deleteTask(TaskVO task) throws Exception {
        return taskMapper.deleteTask(task);
    }

    public int saveTask(TaskVO task) throws Exception {
        return taskMapper.saveTask(task);
    }
}

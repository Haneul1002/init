package com.init.resume.main.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.init.resume.main.vo.TaskVO;

@Mapper
public interface TaskMapper {

    List<TaskVO> getAllTask(HashMap<String, Object> hashMap);

    int deleteTask(TaskVO task) throws Exception;

    int saveTask(TaskVO task) throws Exception;

    int updateTask(TaskVO task) throws Exception;

}


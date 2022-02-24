package com.init.resume.main.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.init.resume.main.service.TaskService;
import com.init.resume.main.vo.TaskVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class TaskController {

    int resultValue = 0;
    private TaskService TaskService = null;

    @Resource(name = "TaskService")
    public void setTaskService(TaskService TaskService) {
    this.TaskService = TaskService;
    }

    
    @RequestMapping(value = "/TaskList", method = RequestMethod.POST, produces = "application/text; charset=UTF-8")
    public @ResponseBody String getTaskList(
        HttpServletRequest request,HttpServletResponse response,
            @RequestParam boolean _search,
            @RequestParam long     nd,
            @RequestParam int       rows,
            @RequestParam int       page,
            @RequestParam String   sidx,
            @RequestParam String   sord
    ) throws JsonGenerationException, JsonMappingException,IOException {

        // System.err.println("search = " + _search + " : nd = " + nd + " : rows = " + rows +
        //                             " : pages = " + page + " : sidx = " + sidx  + " : sord =" + sord);

    HashMap<String,Object> params = new HashMap<String,Object>();
    int start =  ((page - 1) * rows ) + 1;
    int limit = (start + rows) -1;

    System.err.println("start = " + start + " : limit = " + limit);
    params.put("start", start );
    params.put("limit", limit);

    List<TaskVO> TaskList = TaskService.getAllTask(params);

    String value = "";

    if(!TaskList.isEmpty()){

        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> modelMap = new HashMap<String, Object>();
        // total = Total Page
        // record = Total Records
        // rows = list data
        // page = current page

        double total = (double) TaskList.get(0).getTotcnt() / rows;
        modelMap.put("total",(int) Math.ceil(total));
        modelMap.put("records", TaskList.get(0).getTotcnt());
        modelMap.put("rows", TaskList);
        modelMap.put("page", page);

        value = mapper.writeValueAsString(modelMap);
    }

    return value;
    }


    @RequestMapping (value="/TaskEdit",method=RequestMethod.POST)
    public String TaskSave (TaskVO task,@RequestParam Map<String,Object> param) throws Exception{
    	String oper = (String) param.get("oper");
        int id = Integer.parseInt(String.valueOf(param.get("id")));
    	task.setTask_nm(id);
        System.err.println(task.getRnum() + ":" +task.getTask_nm() + ":" +task.getName());


        

        
        if (oper.equals("edit")){
            resultValue =  TaskService.updateTask(task);
        } else if (oper.equals("del")){ 
            
            resultValue =   TaskService.deleteTask(task);
        } else if (oper.equals("add")){
            resultValue =   TaskService.saveTask(task);
        }

            

        return "resume/setting";
    }

    @RequestMapping (value="/TaskAdd",method=RequestMethod.POST)
    public String TaskSave (TaskVO task) throws Exception{


        resultValue =   TaskService.saveTask(task);;

        return "resume/setting";
    }

    @RequestMapping (value="/TaskUpdate",method=RequestMethod.POST)
    public String TaskEdit (TaskVO task) throws Exception{

        System.err.println(task.getRnum() + ":" +task.getTask_nm() + ":" +task.getName());

            resultValue =  TaskService.updateTask(task);

        return "resume/setting";
    }

}


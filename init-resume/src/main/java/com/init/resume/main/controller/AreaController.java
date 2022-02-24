package com.init.resume.main.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.init.resume.main.service.AreaService;
import com.init.resume.main.vo.AreaVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class AreaController {

    int resultValue = 0;
    private AreaService AreaService;

    @Autowired
    public void setAreaService(AreaService AreaService) {
    this.AreaService = AreaService;
    }

    
    @RequestMapping(value = "/AreaList", produces = "application/text; charset=UTF-8")
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

    List<AreaVO> AreaList = AreaService.getAllArea(params);

    String value = "";

    if(!AreaList.isEmpty()){

        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> modelMap = new HashMap<String, Object>();
        // total = Total Page
        // record = Total Records
        // rows = list data
        // page = current page

        double total = (double) AreaList.get(0).getTotcnt() / rows;
        modelMap.put("total",(int) Math.ceil(total));
        modelMap.put("records", AreaList.get(0).getTotcnt());
        modelMap.put("rows", AreaList);
        modelMap.put("page", page);

        value = mapper.writeValueAsString(modelMap);
    }

    return value;
    }

    @RequestMapping (value="/AreaEdit",method=RequestMethod.POST)
    public String TaskSave (AreaVO Area,@RequestParam Map<String,Object> param) throws Exception{

        
        System.err.println(Area.getRnum() + ":" +Area.getId() + ":" +Area.getName());


        String oper = (String) param.get("oper");
        String id = (String) param.get("id");

        
        if (oper.equals("edit")){
            resultValue =  AreaService.updateArea(Area);
        } else if (oper.equals("del")){
            Area.setId(id);
            resultValue =   AreaService.deleteArea(Area);
        } else if (oper.equals("add")){
            resultValue =   AreaService.saveArea(Area);
        }

            

        return "resume/setting";
    }

    @RequestMapping (value="/AreaAdd",method=RequestMethod.POST)
    public String CareerSave (AreaVO Area) throws Exception{


        resultValue =   AreaService.saveArea(Area);;

        return "resume/setting";
    }

    @RequestMapping (value="/AreaUpdate",method=RequestMethod.POST)
    public String TaskEdit (AreaVO Area) throws Exception{

        System.err.println(Area.getRnum() + ":" +Area.getId() + ":" +Area.getName());

            resultValue =  AreaService.updateArea(Area);

        return "resume/setting";
    }

//     @RequestMapping(value="/TaskDel", method = RequestMethod.POST, produces="application/json;charset=utf-8")
// 	public String TaskDelete (@RequestParam Map<String,Object> param) throws Exception {
// 		Area Area = new Area();

        
//         String id = (String)param.get("id");
//         Area.setTaskmc(id);
        
// 		resultValue =   AreaService.deleteTask(Area);

        
//         return "setting";
// }
}

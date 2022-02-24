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
import com.init.resume.main.service.InstituteService;
import com.init.resume.main.vo.InstituteVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class InstituteController {

    int resultValue = 0;
    private InstituteService InstituteService = null;

    @Resource(name = "InstituteService")
    public void setInstituteService(InstituteService InstituteService) {
    this.InstituteService = InstituteService;
    }

    
    @RequestMapping(value = "/InstituteList", method = RequestMethod.POST, produces = "application/text; charset=UTF-8")
    public @ResponseBody String getInstituteList(
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

    List<InstituteVO> InstituteList = InstituteService.getAllInstitute(params);

    String value = "";

    if(!InstituteList.isEmpty()){
        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> modelMap = new HashMap<String, Object>();
        // total = Total Page
        // record = Total Records
        // rows = list data
        // page = current page

        double total = (double) InstituteList.get(0).getTotcnt() / rows;
        modelMap.put("total",(int) Math.ceil(total));
        modelMap.put("records", InstituteList.get(0).getTotcnt());
        modelMap.put("rows", InstituteList);
        modelMap.put("page", page);

        value = mapper.writeValueAsString(modelMap);
    }

    return value;
    }

    @RequestMapping (value="/InstituteEdit",method=RequestMethod.POST)
    public String InstituteSave (InstituteVO Institute,@RequestParam Map<String,Object> param) throws Exception{

        
        System.err.println(Institute.getRnum() + ":" +Institute.getInstitute_nm() + ":" +Institute.getName());


        String oper = (String) param.get("oper");
        String id = (String) param.get("id");

        if (oper.equals("edit")){
            resultValue =  InstituteService.updateInstitute(Institute);
        } else if (oper.equals("del")){
            Institute.setInstitute_nm(id);
            resultValue =   InstituteService.deleteInstitute(Institute);
        } else if (oper.equals("add")){
            resultValue =   InstituteService.saveInstitute(Institute);
        }

        return "resume/setting";
    }

    @RequestMapping (value="/InstituteAdd",method=RequestMethod.POST)
    public String CareerSave (InstituteVO Institute) throws Exception{


        resultValue =   InstituteService.saveInstitute(Institute);

        return "resume/setting";
    }

    @RequestMapping (value="/InstituteUpdate",method=RequestMethod.POST)
    public String InstituteEdit (InstituteVO Institute) throws Exception{

        System.err.println(Institute.getRnum() + ":" +Institute.getInstitute_nm() + ":" +Institute.getName());

            resultValue =  InstituteService.updateInstitute(Institute);

        return "resume/setting";
    }

//     @RequestMapping(value="/InstituteDel", method = RequestMethod.POST, produces="application/json;charset=utf-8")
// 	public String InstituteDelete (@RequestParam Map<String,Object> param) throws Exception {
// 		Institute Institute = new Institute();

        
//         String id = (String)param.get("id");
//         Institute.setInstitutemc(id);
        
// 		resultValue =   InstituteService.deleteInstitute(Institute);

        
//         return "setting";
// }
}

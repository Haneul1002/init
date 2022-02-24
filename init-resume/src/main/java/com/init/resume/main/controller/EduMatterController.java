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
import com.init.resume.main.service.EduMatterService;
import com.init.resume.main.vo.EduMatterVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EduMatterController {
    
    
    int resultValue = 0;
    private EduMatterService eduMatterService = null;

    @Resource(name = "EduMatterService")
    public void setEduMatterService(EduMatterService eduMatterService) {
    this.eduMatterService = eduMatterService;
    }

    
    @RequestMapping(value = "{id}/detail/EduMatterList", method = RequestMethod.POST, produces = "application/text; charset=UTF-8")
    public @ResponseBody String getEduMatterList(
    HttpServletRequest request,HttpServletResponse response,
            @PathVariable String id,
            @RequestParam boolean _search,
            @RequestParam long     nd,
            @RequestParam int       rows,
            @RequestParam int       page,
            @RequestParam String   sidx,
            @RequestParam String   sord
    ) throws JsonGenerationException, JsonMappingException,IOException {

    HashMap<String,Object> params = new HashMap<String,Object>();
    int start =  ((page - 1) * rows ) + 1;
    int limit = (start + rows) -1;
    
    System.err.println("start = " + start + " : limit = " + limit);
    params.put("start", start );
    params.put("limit", limit);
    params.put("info_id", id);

    List<EduMatterVO> EduMatterList = eduMatterService.getAllEduMatter(params);
    
    String value = "";
    
    if(!EduMatterList.isEmpty()){
        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> modelMap = new HashMap<String, Object>();
        
        double total = (double) EduMatterList.get(0).getTotcnt() / rows;
        modelMap.put("total",(int) Math.ceil(total));
        modelMap.put("records", EduMatterList.get(0).getTotcnt());
        modelMap.put("rows", EduMatterList);
        modelMap.put("page", page);

        value = mapper.writeValueAsString(modelMap);
    }

    return value;
    }

    @RequestMapping (value="detail/EduMatterEdit",method=RequestMethod.POST)
    public String EduMatterEdit (EduMatterVO eduMatter,@RequestParam Map<String,Object> param) throws Exception{


        String oper = (String) param.get("oper");
        String id = (String) param.get("id");
        // System.err.println(param);
        // System.err.println(user);
        
        
    if (oper.equals("edit")){
        String date = (String) param.get("date");
        String[] arraydate = date.split("~");
        eduMatter.setStart_date(arraydate[0].trim());
        eduMatter.setEnd_date(arraydate[1].trim());
        resultValue =  eduMatterService.updateEduMatter(eduMatter);
    } else if (oper.equals("del")){
        eduMatter.setEdumatter_id(id);
        resultValue =   eduMatterService.deleteEduMatter(eduMatter);
    } else if (oper.equals("add")){
        String date = (String) param.get("date");
        String[] arraydate = date.split("~");
        eduMatter.setStart_date(arraydate[0].trim());
        eduMatter.setEnd_date(arraydate[1].trim());
        resultValue =   eduMatterService.saveEduMatter(eduMatter);
    }
    
    return "resume/setting";
    }

    @RequestMapping (value="detail/EduMatterAdd",method=RequestMethod.POST)
    public String EduMatterSave (EduMatterVO eduMatter) throws Exception{

        System.err.println(
            eduMatter.getCourse_name() + ":" +
            eduMatter.getInstitation()+ ":" +
            eduMatter.getEnd_date()+ ":" +
            eduMatter.getInfo_id()+ ":" +
            eduMatter.getStart_date()+ ":" +
            eduMatter.getEdumatter_id());

            resultValue =   eduMatterService.saveEduMatter(eduMatter);

        return "resume/setting";
    }

    @RequestMapping (value="detail/EduMatterUpdate",method=RequestMethod.POST)
    public String EduMatterEdit (EduMatterVO eduMatter) throws Exception{
        

            resultValue =  eduMatterService.updateEduMatter(eduMatter);

        return "resume/setting";
    }

//     @RequestMapping(value="detail/EduMatterDel", method = RequestMethod.POST, produces="application/json;charset=utf-8")
// 	public String EduMatterDelete (@RequestParam Map<String,Object> param) throws Exception {
// 		EduMatter eduMatter = new EduMatter();

        
//         String id = (String)param.get("id");
//         eduMatter.setMatter_ID(id);
        
// 		resultValue =   eduMatterService.deleteEduMatter(eduMatter);

        
//         return "index";
// }
}

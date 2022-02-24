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
import com.init.resume.main.service.QualificationService;
import com.init.resume.main.vo.QualificationVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class QualificationsController {
    
    
    int resultValue = 0;
    private QualificationService qualificationsService = null;

    @Resource(name = "QualificationService")
    public void setQualificationsService(QualificationService qualificationsService) {
    this.qualificationsService = qualificationsService;
    }

    
    @RequestMapping(value = "{id}/detail/QualificationsList", method = RequestMethod.POST, produces = "application/text; charset=UTF-8")
    public @ResponseBody String getQualificationsList(
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

    List<QualificationVO> QualificationsList = qualificationsService.getAllQualifications(params);
    
    String value = "";

    if(!QualificationsList.isEmpty()){
        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> modelMap = new HashMap<String, Object>();
        
        double total = (double) QualificationsList.get(0).getTotcnt() / rows;
        modelMap.put("total",(int) Math.ceil(total));
        modelMap.put("records", QualificationsList.get(0).getTotcnt());
        modelMap.put("rows", QualificationsList);
        modelMap.put("page", page);

        value = mapper.writeValueAsString(modelMap);
    }
    return value;
    }

    @RequestMapping (value="detail/QualificationsEdit",method=RequestMethod.POST)
    public String QualificationsEdit (QualificationVO qualifications,@RequestParam Map<String,Object> param) throws Exception{


        String oper = (String) param.get("oper");
        int id = Integer.parseInt(String.valueOf(param.get("id")));
        // System.err.println(param);
        // System.err.println(qualifications);
    if (oper.equals("edit")){
        resultValue =  qualificationsService.updateQualifications(qualifications);
    } else if (oper.equals("del")){
        qualifications.setQualifi_id(id);
        resultValue =   qualificationsService.deleteQualifications(qualifications);
    } else if (oper.equals("add")){
        resultValue =   qualificationsService.saveQualifications(qualifications);
    }
    
    return "resume/detail";
    }

    @RequestMapping (value="detail/QualificationsAdd",method=RequestMethod.POST)
    public String QualificationsSave (QualificationVO qualifications) throws Exception{


        // System.err.println(
        //     qualifications.getInfo_id() + ":" +
        //     qualifications.getIssuer()+ ":" +
        //     qualifications.getName()+ ":" +
        //     qualifications.getQualifi_ID()+ ":" +
        //     qualifications.getReg_date()+ ":" +
        //     qualifications.getReg_num());

            resultValue =   qualificationsService.saveQualifications(qualifications);

        return "resume/detail";
    }

    @RequestMapping (value="detail/QualificationsUpdate",method=RequestMethod.POST)
    public String QualificationsEdit (QualificationVO qualifications) throws Exception{
        
            resultValue =  qualificationsService.updateQualifications(qualifications);

        return "resume/detail";
    }

//     @RequestMapping(value="detail/QualificationsDel", method = RequestMethod.POST, produces="application/json;charset=utf-8")
// 	public String QualificationsDelete (@RequestParam Map<String,Object> param) throws Exception {
// 		Qualifications qualifications = new Qualifications();

        
//         String id = (String)param.get("id");
//         qualifications.setQualifi_ID(id);
        
// 		resultValue =   qualificationsService.deleteQualifications(qualifications);

        
//         return "index";
// }
}

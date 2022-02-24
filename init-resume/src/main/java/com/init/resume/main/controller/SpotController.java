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
import com.init.resume.main.service.SpotService;
import com.init.resume.main.vo.SpotVO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class SpotController {

    int resultValue = 0;
    private SpotService spotService  = null;

    @Resource(name = "SpotService")
    public void setSpotService(SpotService spotService) {
    this.spotService = spotService;
    }

    
    @RequestMapping(value = "/SpotList", method = RequestMethod.POST, produces = "application/text; charset=UTF-8")
    public @ResponseBody String getAllSpot(
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

    List<SpotVO> SpotList = spotService.getAllSpot(params);
    
    String value = "";

    if(!SpotList.isEmpty()){
        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> modelMap = new HashMap<String, Object>();
        // total = Total Page
        // record = Total Records
        // rows = list data
        // page = current page

        double total = (double) SpotList.get(0).getTotcnt() / rows;
        modelMap.put("total",(int) Math.ceil(total));
        modelMap.put("records", SpotList.get(0).getTotcnt());
        modelMap.put("rows", SpotList);
        modelMap.put("page", page);

        value = mapper.writeValueAsString(modelMap);
    }

    return value;
    }

    @RequestMapping (value="/SpotEdit",method=RequestMethod.POST)
    public String SpotSave (SpotVO spot,@RequestParam Map<String,Object> param) throws Exception{

        
        System.err.println(spot.getRnum() + ":" +spot.getSpot_nm() + ":" +spot.getName());


        String oper = (String) param.get("oper");
        int id = Integer.parseInt(String.valueOf(param.get("id")));


        if (oper.equals("edit")){
            resultValue =  spotService.updateSpot(spot);
        } else if (oper.equals("del")){
            spot.setSpot_nm(id);
            resultValue =   spotService.deleteSpot(spot);
        } else if (oper.equals("add")){
            resultValue =   spotService.saveSpot(spot);
        }

        return "resume/setting";
    }

    @RequestMapping (value="/SpotAdd",method=RequestMethod.POST)
    public String SpotSave (SpotVO spot) throws Exception{


        resultValue =   spotService.saveSpot(spot);

        return "resume/setting";
    }

    @RequestMapping (value="/SpotUpdate",method=RequestMethod.POST)
    public String SpotEdit (SpotVO spot) throws Exception{

        System.err.println(spot.getRnum() + ":" +spot.getSpot_nm() + ":" +spot.getName());

            resultValue =  spotService.updateSpot(spot);

        return "resume/setting";
    }

//     @RequestMapping(value="/ClientDel", method = RequestMethod.POST, produces="application/json;charset=utf-8")
// 	public String ClientDelete (@RequestParam Map<String,Object> param) throws Exception {
// 		Client client = new Client();

        
//         String id = (String)param.get("id");
//         client.setClientmc(id);
        
// 		resultValue =   clientService.deleteClient(client);

        
//         return "setting";
// }
}

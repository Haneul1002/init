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
import com.init.resume.main.service.ClientService;
import com.init.resume.main.vo.ClientVO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class ClientController {

    int resultValue = 0;
    private ClientService clientService = null;

    @Resource(name = "ClientService")
    public void setClientService(ClientService clientService) {
    this.clientService = clientService;
    }

    
    @RequestMapping(value = "/ClientList", method = RequestMethod.POST, produces = "application/text; charset=UTF-8")
    public @ResponseBody String getClientList(
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

    List<ClientVO> ClientList = clientService.getAllClient(params);

    String value = "";
    
    if(!ClientList.isEmpty()){
        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> modelMap = new HashMap<String, Object>();
        // total = Total Page
        // record = Total Records
        // rows = list data
        // page = current page

        double total = (double) ClientList.get(0).getTotcnt() / rows;
        modelMap.put("total",(int) Math.ceil(total));
        modelMap.put("records", ClientList.get(0).getTotcnt());
        modelMap.put("rows", ClientList);
        modelMap.put("page", page);

        value = mapper.writeValueAsString(modelMap);
    }

    return value;
    }

    @RequestMapping (value="/ClientEdit",method=RequestMethod.POST)
    public String ClientSave (ClientVO client,@RequestParam Map<String,Object> param) throws Exception{

    	String oper = (String) param.get("oper");
        int id = Integer.parseInt(String.valueOf(param.get("id")));
        client.setClient_nm(id);
    	
        System.err.println(client.getRnum() + ":" +client.getClient_nm() + ":" +client.getName()+ ":" +oper);


        if (oper.equals("edit")){
            resultValue =  clientService.updateClient(client);
        } else if (oper.equals("del")){
            resultValue =   clientService.deleteClient(client);
        } else if (oper.equals("add")){
            resultValue =   clientService.saveClient(client);
        }

        return "resume/setting";
    }

    @RequestMapping (value="/ClientAdd",method=RequestMethod.POST)
    public String CareerSave (ClientVO client) throws Exception{


        resultValue =   clientService.saveClient(client);

        return "resume/setting";
    }

    @RequestMapping (value="/ClientUpdate",method=RequestMethod.POST)
    public String ClientEdit (ClientVO client) throws Exception{

        System.err.println(client.getRnum() + ":" +client.getClient_nm() + ":" +client.getName());

            resultValue =  clientService.updateClient(client);

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

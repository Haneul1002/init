package com.init.resume.main.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.init.resume.main.service.DetailService;
import com.init.resume.main.vo.AreaVO;
import com.init.resume.main.vo.ClientVO;
import com.init.resume.main.vo.OccupationVO;
import com.init.resume.main.vo.QualificationCodeVO;
import com.init.resume.main.vo.TaskVO;


@Controller
public class MainController {
	
	private DetailService detailService = null;

    @Autowired
    public void setDetailService(DetailService detailService) {
    this.detailService = detailService;
    }


	@RequestMapping("/main")
    public String mainPage(Model model,Authentication auth, HttpSession session) throws Exception {   
		
		List<AreaVO> area = detailService.areaSelect();
        List<ClientVO> client = detailService.clientSelect(); 
        List<TaskVO> task = detailService.taskSelect();
        List<QualificationCodeVO> qualification_codeSelect = detailService.qualification_codeSelect();
        List<OccupationVO> occupation = detailService.occupationSelect();
        
        
		session.setAttribute("loginCheck",true);
		model.addAttribute("auth",auth);
		model.addAttribute("occupation", occupation);
        model.addAttribute("area", area);
        model.addAttribute("client", client);
        model.addAttribute("task", task);
        model.addAttribute("qualifi", qualification_codeSelect);
        
        
        return "resume/main";
    }
	
	@RequestMapping("/setting")
    public String settingPage(Model model,HttpSession session) throws Exception {   
		
        List<OccupationVO> occupation = detailService.occupationSelect();
        
        
		session.setAttribute("loginCheck",true);
		model.addAttribute("occupation", occupation);
		
        return "resume/setting";
    }
	
	@RequestMapping("/user")
    public String userPage() {   
        return "resume/detail";
    } 
}
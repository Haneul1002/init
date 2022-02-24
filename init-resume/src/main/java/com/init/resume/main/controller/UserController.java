package com.init.resume.main.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.init.resume.main.service.UserService;
import com.init.resume.main.vo.UserVO;

@RequestMapping("/users")
@Controller
public class UserController {
	
	private UserService userService = null;
	
	@Resource(name = "UserService")
    public void setCareerService(UserService userService) {
    this.userService = userService;
    }
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping("/login")
	public void loginPage( String error, String logout, Model model) {
		logger.info("로그인 페이지로 이동~");
		logger.info("err :" + error );
		logger.info("logout : " + logout );
		if(error != null) { 
			model.addAttribute("error","로그인 실패"); 
		} 
		if(logout != null) { 
			model.addAttribute("logout","로그아웃"); 
		}

	}

	@RequestMapping("/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/";
    }

	
	@RequestMapping(value= "/login-processing", method={RequestMethod.POST})
	public void loginProcessing(HttpSession session, String error) {
		logger.info("login-processing!");
		logger.info("err :" + error );
		session.setAttribute("loginCheck",true);
	}
	
	@RequestMapping("/member") 
	public void doMember() { 
		logger.info("멤버로그인~"); 
	} 
	
	@RequestMapping("/admin") 
	public void doAdmin() { 
    		logger.info("관리자로그인~"); 
	}
	
	@RequestMapping("/register") 
	public void doRegister() { 
		logger.info("회원가입 페이지~"); 
	}
	
	@RequestMapping(value="/registerAf", method={RequestMethod.POST})
	public String RegisterUser(UserVO userVO) {
		
		userService.RegisterUser(userVO);
		
		return "/main";
		
	}

}
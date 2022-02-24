package com.init.resume.main.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.init.resume.main.service.DetailService;
import com.init.resume.main.service.UserInfoService;
import com.init.resume.main.vo.FileAttachVO;
import com.init.resume.main.vo.ImageVO;
import com.init.resume.main.vo.UserInfoVO;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class UserInfoController {

    int resultValue = 0;

    private UserInfoService userInfoService = null;

    @Resource(name = "UserInfoService")
    public void setUserService(UserInfoService userInfoService) {
    this.userInfoService = userInfoService;
    }

    private DetailService detailService = null;

    @Resource(name = "DetailService")
    public void setDetailService(DetailService detailService) {
    this.detailService = detailService;
    }

    
    @RequestMapping(value = "/userList",  method = RequestMethod.POST, produces = "application/text; charset=UTF-8")
    public @ResponseBody String getUserList(
        HttpServletRequest request,HttpServletResponse response,
        @RequestParam HashMap<String,Object> param 
    ) throws JsonGenerationException, JsonMappingException,IOException {
        int            rows = Integer.parseInt(String.valueOf(param.get("rows")));
        int            page = Integer.parseInt(String.valueOf(param.get("page")));
        
        
    int start = ((page - 1) * rows ) + 1;
    int limit = (start + rows) -1;
    
    System.out.println("이건데"+param);

    //System.err.println("start = " + start + " : limit = " + limit);
    param.put("start", start);
    param.put("limit", limit);
    
    List<UserInfoVO> userExtList = userInfoService.getAllUser(param);
    String value;

    ObjectMapper mapper = new ObjectMapper();

    Map<String, Object> modelMap = new HashMap<String, Object>();
    // total = Total Page
    // record = Total Records
    // rows = list data
    // page = current page
    if(userExtList.size()!=0){
    double total = (double) userExtList.get(0).getTotcnt() / rows;
    
    modelMap.put("total",(int) Math.ceil(total));
    modelMap.put("records", userExtList.get(0).getTotcnt());
    }
    modelMap.put("rows", userExtList);
    modelMap.put("page", page);

    
    value = mapper.writeValueAsString(modelMap);

    System.out.println(value);
    return value;
    }

    @RequestMapping (value="/userEdit",method=RequestMethod.POST)
    public String userEdit (UserInfoVO member,@RequestParam Map<String,Object> param) throws Exception{


        String oper = (String) param.get("oper");
        String id = (String) param.get("id");

    if (oper.equals("edit")){
        resultValue =  userInfoService.updateUser(member);
    } else if (oper.equals("del")){
    	member.setId(id);
        resultValue =   userInfoService.deleteUser(member);
    } else if (oper.equals("add")){
        resultValue =   userInfoService.saveUser(member);
    }
    
    return "resume/main";
    }

    @RequestMapping (value="/userAdd",method=RequestMethod.POST)
    public String userSave (@ModelAttribute UserInfoVO user) throws Exception{

    	userInfoService.saveUser(user);

        return "resume/main";
    }

    @RequestMapping (value="/userUpdate",method=RequestMethod.POST)
    public String userUpdate (@ModelAttribute UserInfoVO user, @RequestPart MultipartFile attachFile, @RequestPart MultipartFile attachImg, HttpServletRequest request) throws IllegalStateException, IOException, Exception{
                      
    		System.out.println("UserUpdate :::::::"+ user);
            
            //파일
            String fileName = attachFile.getOriginalFilename();
            //이미지
            String imgName = attachImg.getOriginalFilename();

            String info_id = user.getInfo_id();
            //파일
            String fileNameExtension = FilenameUtils.getExtension(fileName).toLowerCase();
            File destinationFile;
            String destinationFileName;
            //이미지
            String imgNameExtension = FilenameUtils.getExtension(imgName).toLowerCase();
            File destinationImg;
            String destinationImgName;

            String fileurl = request.getSession().getServletContext().getRealPath("/resources/uploads");
            //String fileurl = "/home/init/gitrepo/resume/init/src/main/resources/static/uploads/";

            String imgurl = request.getSession().getServletContext().getRealPath("/resources/images");
            System.out.println("이미지url"+imgurl);
            //String imgurl = "/home/init/gitrepo/resume/init/src/main/resources/static/img/";
            FileAttachVO file = new FileAttachVO();
            ImageVO img = new ImageVO();
            if(!attachFile.isEmpty()){
	            do{
	                destinationFileName = RandomStringUtils.randomAlphanumeric(32) + "." + fileNameExtension;
	                destinationFile = new File(fileurl,destinationFileName);
	            } while(destinationFile.exists());
	            destinationFile.getParentFile().mkdirs();
	            attachFile.transferTo(destinationFile);
	            
	            file.setInfo_id(user.getInfo_id());
	            file.setFilename(destinationFileName);
	            file.setFileoriginname(fileName);
	            file.setFileurl(fileurl);
            }
            if(!attachImg.isEmpty()){
	            do{
	                destinationImgName = RandomStringUtils.randomAlphanumeric(32) + "." + imgNameExtension;
	                destinationImg = new File(imgurl,destinationImgName);
	            } while(destinationImg.exists());
	            destinationImg.getParentFile().mkdirs();
	            attachImg.transferTo(destinationImg);
	            
	            img.setInfo_id(user.getInfo_id());
	            img.setImgname(destinationImgName);
	            img.setImgoriginname(imgName);
	            img.setImgurl(imgurl);
            }

            
            String userTask = user.getTask();
            if(userTask==null){
            	user.setTask("0");
    		}
        	System.out.println("유저"+user);
            userInfoService.updateUser(user);

           String test = request.getParameter("photo");
           System.out.println("테스트"+test);
            

           ImageVO beforeAttach = detailService.imgSelect(user.getInfo_id());
           System.out.println("비포"+beforeAttach);
            System.out.println("iq"+img);
 
            if(beforeAttach==null){
            	if(!attachImg.isEmpty()){
            		userInfoService.imgInsert(img);
            	}
            	if(!attachFile.isEmpty()){
            		userInfoService.fileInsert(file);
            	}
            }else{
            	if(!attachImg.isEmpty()){
	                /*ImageVO beforeAttach = detailService.imgSelect(user.getInfo_id());*/
	                Path filePath = FileSystems.getDefault().getPath(beforeAttach.getImgurl(), beforeAttach.getImgname());
	                System.out.println("비포"+beforeAttach);
	                System.out.println("비포"+filePath);
	                Files.delete(filePath);
	                userInfoService.imgDelete(beforeAttach);
	                userInfoService.imgInsert(img);
            	}
                if(!attachFile.isEmpty()){
                	userInfoService.fileInsert(file);
                }
            }
            


        return "resume/detail";
    }
    @ResponseBody
    @RequestMapping(value = "fileDelete/{id}")
    public ModelAndView fileDelete(@PathVariable("id") int id, FileAttachVO fileAttach) throws Exception{
    	
    	
        fileAttach = detailService.fileSelect(id);
        System.out.println("파일"+fileAttach);
        Path filePath = FileSystems.getDefault().getPath(fileAttach.getFileurl(), fileAttach.getFilename());
        ModelAndView mav = new ModelAndView("jsonView");
        
        try {
            Files.delete(filePath);
            fileAttach.setId(id);
            userInfoService.fileDelete(fileAttach);
        } catch (IOException | SecurityException e) {
        	System.out.println("에러메세지:" + e.getMessage()); 
        	e.printStackTrace(); //예외정보 출력

        	
            return mav;
        }
        List<FileAttachVO> fileList = detailService.fileDetail(fileAttach.getInfo_id());
        mav.addObject("fileList", fileList);
        
        return mav;
    }
   /* @RequestMapping(value = "fileDelete/{id}")
    public String fileDelete(@PathVariable("id") int id, FileAttachVO fileAttach) throws Exception{
    	
    	
        fileAttach = detailService.fileSelect(id);
        System.out.println("파일"+fileAttach);
        Path filePath = FileSystems.getDefault().getPath(fileAttach.getFileurl(), fileAttach.getFilename());
        try {
            Files.delete(filePath);
            fileAttach.setId(id);
            userInfoService.fileDelete(fileAttach);
        } catch (IOException | SecurityException e) {
        	System.out.println("에러메세지:" + e.getMessage()); 
        	e.printStackTrace(); //예외정보 출력

        	
            return "index";
        }
        return "index";
    }*/

    
    

//     @RequestMapping(value="/userDel", method = RequestMethod.POST, produces="application/json;charset=utf-8")
// 	public String userDelete (@RequestParam Map<String,Object> param) throws Exception {
// 		UserExt user = new UserExt();

//         String id = (String)param.get("id");
//         user.setInfo_id(id);
//         System.out.println(user);

// 		resultValue =   userService.deleteUser(user);
        
//         return "index";
// }
}

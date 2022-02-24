package com.init.resume.main.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.init.resume.main.service.DetailService;
import com.init.resume.main.vo.AreaVO;
import com.init.resume.main.vo.ClientVO;
import com.init.resume.main.vo.FileAttachVO;
import com.init.resume.main.vo.InstituteVO;
import com.init.resume.main.vo.UserInfoVO;
import com.init.resume.main.vo.OccupationVO;
import com.init.resume.main.vo.QualificationCodeVO;
import com.init.resume.main.vo.SpotVO;
import com.init.resume.main.vo.TaskVO;




@Controller
public class DetailController {

    int resultValue = 0;
    private DetailService detailService = null;

    @Resource(name = "DetailService")
    public void setDetailService(DetailService detailService) {
    this.detailService = detailService;
    }
    
// 상세화면 조회
    @RequestMapping (value="{id}/detail",  method = RequestMethod.GET, produces = "application/text; charset=UTF-8")
    public String getDetail (@PathVariable("id") String Id, Model model) throws Exception{
    	
        List<UserInfoVO> value = detailService.getDetail(Id);
        List<FileAttachVO> fileAttachs = detailService.fileDetail(Id);
        List<TaskVO> task = detailService.taskSelect();
        List<ClientVO> client = detailService.clientSelect();
        List<InstituteVO> institute = detailService.instituteSelect();
        List<SpotVO> spot = detailService.spotSelect();
        List<QualificationCodeVO> qualification_codes = detailService.qualification_codeSelect();
        List<OccupationVO> occupation = detailService.occupationSelect();
        List<AreaVO> area = detailService.areaSelect();
        
        
        String[] areaArray = value.get(0).getArea().split(",");
        
        for(int i =0; i<areaArray.length; i ++) {
        	System.out.println(areaArray[i]);
        }
        
        
        UserInfoVO personal_info = new UserInfoVO();
        personal_info.setId(Id);
        personal_info.setName(value.get(0).getName());
        personal_info.setBirth(value.get(0).getBirth());
        personal_info.setPhone(value.get(0).getPhone());
        personal_info.setEmail(value.get(0).getEmail());
        personal_info.setCareer_age(value.get(0).getCareer_age());
        personal_info.setQualifi(value.get(0).getQualifi());
        personal_info.setOccupation(value.get(0).getOccupation());
        personal_info.setTask(value.get(0).getTask());
        personal_info.setAddress(value.get(0).getAddress());
        personal_info.setDetailaddress(value.get(0).getDetailaddress());
        personal_info.setImgname(value.get(0).getImgname());
    

        model.addAttribute("detailset", personal_info);
        model.addAttribute("detailArea", areaArray);
        model.addAttribute("area", area);
        model.addAttribute("file", fileAttachs);
        model.addAttribute("task", task);
        model.addAttribute("occupation", occupation);
        model.addAttribute("client", client);
        model.addAttribute("institute", institute);
        model.addAttribute("spot", spot);
        model.addAttribute("qualifi", qualification_codes);
        return "resume/detail";
    }
    
// 파일 다운로드
    @RequestMapping(value="fileDown/{file_id}")
    private void fileDown(@PathVariable("file_id") int file_id, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, Exception {
            
        // if (file_id == null) throw new RuntimeException("올바르지 않은 접근입니다.");

        FileAttachVO fileAttach = detailService.fileSelect(file_id);
        //|| "Y".equals(fileAttach.getDeleteYn())
        if (fileAttach == null ) {
            throw new RuntimeException("파일 정보를 찾을 수 없습니다.");
        }

        String uploadPath =  fileAttach.getFileurl();

        String filename = fileAttach.getFileoriginname();
        File file = new File(uploadPath, fileAttach.getFilename());

        try {
            byte[] data = FileUtils.readFileToByteArray(file);
            response.setContentType("application/octet-stream");
            response.setContentLength(data.length);
            response.setHeader("Content-Transfer-Encoding", "binary");
            response.setHeader("Content-Disposition", "attachment; fileName=\"" + java.net.URLEncoder.encode(filename, "UTF-8") + "\";");

            response.getOutputStream().write(data);
            response.getOutputStream().flush();
            response.getOutputStream().close();

        } catch (IOException e) {
            throw new RuntimeException("파일 다운로드에 실패하였습니다.");

        } catch (Exception e) {
            throw new RuntimeException("시스템에 문제가 발생하였습니다.");
        }
    }

}

package com.init.resume.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.init.resume.main.mapper.PdfMapper;
import com.init.resume.main.vo.AreaVO;
import com.init.resume.main.vo.CareerVO;
import com.init.resume.main.vo.ClientVO;
import com.init.resume.main.vo.EduMatterVO;
import com.init.resume.main.vo.EducationVO;
import com.init.resume.main.vo.FileAttachVO;
import com.init.resume.main.vo.ImageVO;
import com.init.resume.main.vo.InstituteVO;
import com.init.resume.main.vo.UserInfoVO;
import com.init.resume.main.vo.OccupationVO;
import com.init.resume.main.vo.PrizeVO;
import com.init.resume.main.vo.QualificationCodeVO;
import com.init.resume.main.vo.QualificationVO;
import com.init.resume.main.vo.SpotVO;
import com.init.resume.main.vo.TaskVO;
import com.init.resume.main.vo.WorkVO;

@Service("PdfService")
public class PdfService {
    
    @Autowired
    public PdfMapper pdfMapper;

    public List<UserInfoVO> getDetail(String member_id){
        return pdfMapper.getDetail(member_id);
    }

    public List<FileAttachVO> fileDetail(String member_id) throws Exception{
        return pdfMapper.fileDetail(member_id);
    }

    public FileAttachVO fileSelect(String member_id) throws Exception{
        return pdfMapper.fileSelect(member_id);
    }
    
    public ImageVO imgSelect(int info_id) throws Exception{
        return pdfMapper.imgSelect(info_id);
    }

    public List<TaskVO> taskSelect() throws Exception{
        return pdfMapper.taskSelect();
    }

    public List<OccupationVO> occupationSelect() throws Exception{
        return pdfMapper.occupationSelect();
    }

    public List<ClientVO> clientSelect() throws Exception{
        return pdfMapper.clientSelect();
    }

    public List<InstituteVO> instituteSelect() throws Exception{
        return pdfMapper.instituteSelect();
    }

    public List<SpotVO> spotSelect() throws Exception{
        return pdfMapper.spotSelect();
    }

    public List<WorkVO> workSelect(String member_id) throws Exception{
        return pdfMapper.workSelect(member_id);
    }

    public List<CareerVO> careerSelect(String member_id) throws Exception{
        return pdfMapper.careerSelect(member_id);
    }

    public List<QualificationVO> qualifiSelect(String info_id) throws Exception{
        return pdfMapper.qualifiSelect(info_id);
    }

    public List<EducationVO> educationSelect(String member_id) throws Exception{
        return pdfMapper.educationSelect(member_id);
    }

    public List<EduMatterVO> eduMatterSelect(String member_id) throws Exception{
        return pdfMapper.eduMatterSelect(member_id);
    }

    public List<PrizeVO> prizeSelect(String member_id) throws Exception{
        return pdfMapper.prizeSelect(member_id);
    }
    public List<QualificationCodeVO> qualification_codeSelect() throws Exception{
        return pdfMapper.qualification_codeSelect();
    }
    
    public List<AreaVO> areaSelect() throws Exception{
        return pdfMapper.areaSelect();
    }
    
    public CareerVO careerDay(String member_id) throws Exception{
        return pdfMapper.careerDay(member_id);
    }
    
    public WorkVO workDay(String member_id) throws Exception{
        return pdfMapper.workDay(member_id);
    }

}

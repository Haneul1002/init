package com.init.resume.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.init.resume.main.mapper.DetailMapper;
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

@Service("DetailService")
public class DetailService {
    
    @Autowired
    public DetailMapper detailMapper;

    public List<UserInfoVO> getDetail(String member_id){
        return detailMapper.getDetail(member_id);
    }

    public List<FileAttachVO> fileDetail(String member_id) throws Exception{
        return detailMapper.fileDetail(member_id);
    }

    public FileAttachVO fileSelect(int member_id) throws Exception{
        return detailMapper.fileSelect(member_id);
    }
    
    public ImageVO imgSelect(String member_id) throws Exception{
        return detailMapper.imgSelect(member_id);
    }

    public List<TaskVO> taskSelect() throws Exception{
        return detailMapper.taskSelect();
    }

    public List<OccupationVO> occupationSelect() throws Exception{
        return detailMapper.occupationSelect();
    }

    public List<ClientVO> clientSelect() throws Exception{
        return detailMapper.clientSelect();
    }

    public List<InstituteVO> instituteSelect() throws Exception{
        return detailMapper.instituteSelect();
    }

    public List<SpotVO> spotSelect() throws Exception{
        return detailMapper.spotSelect();
    }

    public List<WorkVO> workSelect(String member_id) throws Exception{
        return detailMapper.workSelect(member_id);
    }

    public List<CareerVO> careerSelect(String member_id) throws Exception{
        return detailMapper.careerSelect(member_id);
    }

    public List<QualificationVO> qualifiSelect(String member_id) throws Exception{
        return detailMapper.qualifiSelect(member_id);
    }

    public List<EducationVO> educationSelect(String member_id) throws Exception{
        return detailMapper.educationSelect(member_id);
    }

    public List<EduMatterVO> eduMatterSelect(String member_id) throws Exception{
        return detailMapper.eduMatterSelect(member_id);
    }

    public List<PrizeVO> prizeSelect(String member_id) throws Exception{
        return detailMapper.prizeSelect(member_id);
    }
    public List<QualificationCodeVO> qualification_codeSelect() throws Exception{
        return detailMapper.qualification_codeSelect();
    }
    
    public List<AreaVO> areaSelect() throws Exception{
        return detailMapper.areaSelect();
    }

}

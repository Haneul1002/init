package com.init.resume.main.mapper;

import java.util.List;


import org.apache.ibatis.annotations.Mapper;

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

@Mapper
public interface DetailMapper {
    
    List<UserInfoVO> getDetail(String member_id); 
    
    List<FileAttachVO> fileDetail(String member_id) throws Exception;

    FileAttachVO fileSelect(int member_id) throws Exception;
    
    ImageVO imgSelect(String member_id) throws Exception;

    List<TaskVO> taskSelect() throws Exception;

    List<OccupationVO> occupationSelect() throws Exception;

    List<ClientVO> clientSelect() throws Exception;

    List<InstituteVO> instituteSelect() throws Exception;

    List<SpotVO> spotSelect() throws Exception;

    List<WorkVO> workSelect(String member_id) throws Exception;

    List<CareerVO> careerSelect(String member_id) throws Exception;

    List<QualificationVO> qualifiSelect(String member_id) throws Exception;

    List<EducationVO> educationSelect(String member_id) throws Exception;

    List<EduMatterVO> eduMatterSelect(String member_id) throws Exception;

    List<PrizeVO> prizeSelect(String member_id) throws Exception;

    List<QualificationCodeVO> qualification_codeSelect() throws Exception;
    
    List<AreaVO> areaSelect() throws Exception;
}

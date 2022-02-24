<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>

<!-- 수정 모달 -->
    <div class="modal fade" id="updateDetials" tabindex="-1" aria-labelledby="updateModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">

                <div class="modal-header">
                    <h5 class="modal-title" id="updateModalLabel">수정</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>

                
                    <div class="modal-body">
                        <input type="hidden" id="info_id" name="info_id" value="${detailset.member_id}">
                        <!-- 근무경력 -->
                        <form name="workupdateForm" method="post">
                            <input type="hidden"  name="info_id" value="${detailset.member_id}">
                            <input type="hidden"    id="update_work_id"             name="id">
                            <table border="0" class="addTable work">
                                <colgroup>
                                    <col width="15%"/>
                                    <col width="75%"/>
                                </colgroup>
                                <tbody>
                                    <tr>
                                        <td>회사명</td>
                                        <td>
                                            <input type="text"      id="update_work_Company_Name"   name="company_name" class="form-control work" placeholder="회사이름">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>부서명</td>
                                        <td>
                                            <input type="text"      id="update_work_Department"     name="department"   class="form-control work" placeholder="부서">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>입사일</td>
                                        <td>
                                            <input type="text"      id="update_work_Start_date"     name="start_date"   class="form-control work" placeholder="입사일" onfocus="(this.type='date')" onblur="(this.type='text')" >
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>퇴사일</td>
                                        <td>
                                            <input type="text"      id="update_work_End_date"       name="end_date"     class="form-control work" placeholder="퇴사일" onfocus="(this.type='date')" onblur="(this.type='text')" >
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>직위</td>
                                        <td>
                                            <select name="spot_nm"  id="update_work_Spot" class ="form-select work">
                                                <option value="">직위 선택</option>
                                                <c:forEach var="spot" items="${spot}">
                                                	<option value="${spot.spot_nm}"><c:out value="${spot.name}"/></option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>직종</td>
                                        <td>
                                            <select name="occupation" id="update_work_Occupation" class ="form-select work">
                                                <option value="">직종 선택</option>
                                                <c:forEach var="occupation" items="${occupation}">
                                                	<option value="${occupation.occupation_nm}"><c:out value="${occupation.name}"/></option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>직무</td>
                                        <td>
                                            <select name="task" id="update_work_Task" class ="form-select work">
                                                <option value="">직무 선택</option>
                                                <c:forEach var="task" items="${task}">
                                                	<option value="${task.task_nm}"><c:out value="${task.name}"/></option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </form>
                        <!-- 기술경력 -->
                        <form name="careerupdateForm" method="post">
                            <input type="hidden"  name="info_id" value="${detailset.member_id}">
                            <input type="hidden"    id="update_career_id"           name="id" >
                            <table border="0" class="addTable career">
                                <colgroup>
                                    <col width="20%"/>
                                    <col width="80%"/>
                                </colgroup>
                                <tbody>
                                    <tr>
                                        <td>사업명</td>
                                        <td>
                                            <input type="text"      id="update_career_Project_name" name="project_name" class="form-control career" placeholder="사업명">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>시작일</td>
                                        <td>
                                            <input type="text"      id="update_career_Start_date"   name="start_date"   class="form-control career" placeholder="시작일" onfocus="(this.type='date')" onblur="(this.type='text')">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>종료일</td>
                                        <td>
                                            <input type="text"      id="update_career_End_date"     name="end_date"     class="form-control career" placeholder="종료일" onfocus="(this.type='date')" onblur="(this.type='text')">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>고객사</td>
                                        <td>
                                            <select name="client_nm" id="update_career_Client_name" class ="form-select career">
                                                <option value="">고객사 선택</option>
                                                <c:forEach var="client" items="${client}">
                                                	<option value="${client.client_nm}"><c:out value="${client.name}"/></option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>직종</td>
                                        <td>
                                            <select name="occupation" id="update_career_Occupation" class ="form-select career">
                                                <option value="">직종 선택</option>
                                                <c:forEach var="occupation" items="${occupation}">
                                                	<option value="${occupation.occupation_nm}"><c:out value="${occupation.name}"/></option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>직무</td>
                                        <td>
                                            <select name="task" id="update_career_Task" class ="form-select career">
                                                <option value="">직무 선택</option>
                                                <c:forEach var="task" items="${task}">
                                                	<option value="${task.task_nm}"><c:out value="${task.name}"/></option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </form>
                        <!-- 학력사항 -->
                        <form name="educationupdateForm" method="post">
                            <input type="hidden"  name="info_id" value="${detailset.member_id}">
                            <input type="hidden" id="update_edu_id"               name="id">
                            <table border="0" class="addTable education">
                                <colgroup>
                                    <col width="20%"/>
                                    <col width="80%"/>
                                </colgroup>
                                <tbody>
                                    <tr>
                                        <td>학교명</td>
                                        <td>
                                            <input type="text"   id="update_education_name"       name="name"       class="form-control education" placeholder="학교명">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>학과(전공)</td>
                                        <td>
                                            <input type="text"   id="update_education_department" name="department" class="form-control education" placeholder="학과(전공)">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>학위</td>
                                        <td>
                                            <input type="text"   id="update_education_degree"     name="degree"     class="form-control education" placeholder="학위">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>입학날짜</td>
                                        <td>
                                            <input type="text"   id="update_education_start_date" name="start_date" class="form-control education" placeholder="입학날짜"   onfocus="(this.type='date')" onblur="(this.type='text')">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>졸업날짜</td>
                                        <td>
                                            <input type="text"   id="update_education_end_date"   name="end_date"   class="form-control education" placeholder="졸업날짜"   onfocus="(this.type='date')" onblur="(this.type='text')" >
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </form>
                        <!-- 교육사항 -->
                        <form name="edumatterupdateForm" method="post">
                            <input type="hidden"            name="info_id" value="${detailset.member_id}">
                            <input type="hidden"            id="update_matter_id"                   name="id">
                            <table border="0" class="addTable edumatter">
                                <colgroup>
                                    <col width="20%"/>
                                    <col width="80%"/>
                                </colgroup>
                                <tbody>
                                    <tr>
                                        <td>과정명</td>
                                        <td>
                                            <input type="text"              id="update_edumatter_course_name"       name="course_name"          class="form-control edumatter" placeholder="과정명">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>학원</td>
                                        <td>
                                            <select name="institute_nm"     id="update_edumatter_institaion_mc"     class ="form-select edumatter">
                                                <option value="">학원 선택</option>
                                                <c:forEach var="institation" items="${institation}">
                                                	<option value="${institation.institute_nm}"><c:out value="${institation.name}"/></option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>수료번호</td>
                                        <td>
                                            <input type="text" id="update_edumatter_completion_number" name="completion_number"    class="form-control edumatter" placeholder="수료번호">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>시작일</td>
                                        <td>
                                            <input type="text" id="update_edumatter_start_date" name="start_date"   onfocus="(this.type='date')" onblur="(this.type='text')" class="form-control edumatter" placeholder="시작일">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>수료일</td>
                                        <td>
                                            <input type="text" id="update_edumatter_end_date"   name="end_date"     onfocus="(this.type='date')" onblur="(this.type='text')" class="form-control edumatter" placeholder="수료일">
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </form>
                        <!-- 자격증 -->
                        <form name="qualificationsupdateForm" method="post">
                            <input type="hidden"  name="info_id" value="${detailset.member_id}">
                            <input type="hidden"    id="update_qualifi_ID"      name="id">
                            <table border="0" class="addTable qualifications">
                                <colgroup>
                                    <col width="20%"/>
                                    <col width="80%"/>
                                </colgroup>
                                <tbody>
                                    <tr>
                                        <td>자격증명</td>
                                        <td>
                                            <select name="qualifi_nm" id="update_qualifi_nm" class ="form-select qualifications">
                                                <option value="">자격증 선택</option>
                                                <c:forEach var="qualifi" items="${qualifi}">
                                                	<option value="${qualifi.qualifi_nm}"><c:out value="${qualifi.qualifi_name}"/></option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>발급번호</td>
                                        <td>
                                            <input type="text"      id="update_qualifi_reg_num" name="reg_num"  class="form-control qualifications" placeholder="발급번호">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>취득일</td>
                                        <td>
                                            <input type="text"      id="update_qualfi_reg_date" name="reg_date" class="form-control qualifications" placeholder="취득일"    onfocus="(this.type='date')" onblur="(this.type='text')" >
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </form>
                        <!-- 상훈 -->
                        <form name="prizeupdateForm" method="post">
                            <input type="hidden"  name="info_id" value="${detailset.member_id}">
                            <input type="hidden"    id="update_prize_id"        name="id">
                            <table border="0" class="addTable prize">
                                <colgroup>
                                    <col width="20%"/>
                                    <col width="80%"/>
                                </colgroup>
                                <tbody>
                                    <tr>
                                        <td>상훈명</td>
                                        <td>
                                            <input type="text"      id="update_prize_name"      name="name"         class="form-control prize"  placeholder="상훈명">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>상훈기관</td>
                                        <td>
                                            <input type="text"      id="update_prize_agency"    name="agency"       class="form-control prize"  placeholder="상훈기관">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>근거</td>
                                        <td>
                                            <input type="text"      id="update_prize_evidence"  name="evidence"     class="form-control prize"  placeholder="근거">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>연 월 일</td>
                                        <td>
                                            <input type="text"      id="update_prize_reg_date"  name="reg_date"     class="form-control prize"  placeholder="연 월 일"  onfocus="(this.type='date')" onblur="(this.type='text')">
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </form>
                    </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" id="detail-update-btn" onclick="careerUpdate()">수정</button>
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
                </div>
            </div>
        </div>
    </div>

</body>
</html>
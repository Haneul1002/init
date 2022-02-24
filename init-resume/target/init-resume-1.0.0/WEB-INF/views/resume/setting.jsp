<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta id="_csrf" name="_csrf" content="${_csrf.token}"/>
<!-- default header name is X-CSRF-TOKEN -->
<meta id="_csrf_header" name="_csrf_header" content="${_csrf.headerName}"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>코드 세팅</title>
	<link rel="shortcut icon" href="/images/favicon.ico">
	<link rel="stylesheet" type="text/css" media="screen" href="/jquery-ui-1.12.1.custom/jquery-ui.min.css"/>
    <link rel="stylesheet" type="text/css" media="screen" href="/jqGrid/css/ui.jqgrid.css"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" media="screen" href="/css/main.css" />
    <link type="text/css" rel="stylesheet" href="/css/detailpage.css"/>
    
    
    <script src="/js/jquery-3.6.0.min.js" type="text/javascript"></script>
    <script src="/js/main.js" type="text/javascript"></script>
    <script src="/js/setting.js" type="text/javascript"></script>
    <!-- <script src="/jquery-ui-1.12.1.custom/jquery-ui.min.js" type="text/javascript"></script> -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>
    <script src="/jqGrid/js/jquery-1.7.2.min.js" type="text/javascript"></script>
    <script src="/jqGrid/js/i18n/grid.locale-kr.js" type="text/javascript"></script>
    <script src="/jqGrid/js/jquery.jqGrid.min.js" type="text/javascript"></script>
</head>
<body>

<jsp:include page="../layout/navbar.jsp"></jsp:include>

<div>
<ul class="nav nav-tabs m-3" id="pills-tab" role="tablist">
    <!-- 고객사 -->
    <li class="nav-item1" role="presentation">
        <button class="nav-link active" id="pills-client-tab" data-bs-toggle="pill" data-bs-target="#pills-client" type="button" role="tab" aria-controls="pills-client" aria-selected="true">고객사</button>
    </li>
    <!-- 교육기관 -->
    <li class="nav-item1" role="presentation">
        <button class="nav-link" id="pills-institute-tab" data-bs-toggle="pill" data-bs-target="#pills-institute" type="button" role="tab" aria-controls="pills-institute" aria-selected="false">교육기관</button>
    </li>
    <!-- 직위 -->
    <li class="nav-item1" role="presentation">
        <button class="nav-link" id="pills-spot-tab" data-bs-toggle="pill" data-bs-target="#pills-spot" type="button" role="tab" aria-controls="pills-spot" aria-selected="false">직위</button>
    </li>
    <!-- 직종 -->
    <li class="nav-item1" role="presentation">
        <button class="nav-link" id="pills-occupation-tab" data-bs-toggle="pill" data-bs-target="#pills-occupation" type="button" role="tab" aria-controls="pills-occupation" aria-selected="false">직종</button>
    </li> 
    <!-- 직무 -->
    <li class="nav-item1" role="presentation">
        <button class="nav-link" id="pills-task-tab" data-bs-toggle="pill" data-bs-target="#pills-task" type="button" role="tab" aria-controls="pills-task" aria-selected="false">직무</button>
    </li>   
    <!-- 지역 -->
    <li class="nav-item1" role="presentation">
        <button class="nav-link" id="pills-area-tab" data-bs-toggle="pill" data-bs-target="#pills-area" type="button" role="tab" aria-controls="pills-area" aria-selected="false">지역</button>
    </li>
    <!-- 자격증 -->
    <li class="nav-item1" role="presentation">
        <button class="nav-link" id="pills-qualifi-tab" data-bs-toggle="pill" data-bs-target="#pills-qualifi" type="button" role="tab" aria-controls="pills-qualifi" aria-selected="false">자격증</button>
    </li>
</ul>
<div class="tab-content m-3" id="pills-tabContent">
    <!-- 고객사 -->
    <div class="tab-pane fade show active" id="pills-client" role="tabpanel" aria-labelledby="pills-client-tab">
        <table id="clientList"></table>
        <div id="clientListPager"></div>
    </div>
    <!-- 교육기관 -->
    <div class="tab-pane fade" id="pills-institute" role="tabpanel" aria-labelledby="pills-institute-tab">
        <table id="instituteList"></table>
        <div id="instituteListPager"></div>
    </div>
    <!-- 직위 -->
    <div class="tab-pane fade" id="pills-spot" role="tabpanel" aria-labelledby="pills-spot-tab">
        <table id="spotList"></table>
        <div id="spotListPager"></div>
    </div>
    <!-- 직종 -->
    <div class="tab-pane fade" id="pills-occupation" role="tabpanel" aria-labelledby="pills-occupation-tab">
        <table id="occupationList"></table>
        <div id="occupationListPager"></div>
    </div>
    <!-- 직무 -->
    <div class="tab-pane fade" id="pills-task" role="tabpanel" aria-labelledby="pills-task-tab">
        <table id="taskList"></table>
        <div id="taskListPager"></div>
    </div>
    <!-- 지역 -->
    <div class="tab-pane fade" id="pills-area" role="tabpanel" aria-labelledby="pills-qualifi-tab">
        <table id="areaList"></table>
        <div id="areaListPager"></div>
    </div>
    <!-- 자격증 -->
    <div class="tab-pane fade" id="pills-qualifi" role="tabpanel" aria-labelledby="pills-qualifi-tab">
        <table id="qualifiList"></table>
        <div id="qualifiListPager"></div>
    </div>
    <div class="d-flex justify-content-end" style = "margin-top : 30px; margin-left : 15px; font-size : 12px;">
    <button type="button" class="btn btn-primary" id="option-add-btn">추가</button>
    </div>
</div>  


<!-- 추가 모달 -->
<div class="modal fade" id="addSetting" tabindex="-1" aria-labelledby="addSettingLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="addModalLabel">추가</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
                <div class="modal-body">
                    <!-- 고객사 -->
                    <form name="clientForm" method="post">
                    <table border="0" class="addTable client">
                        <colgroup>
                            <col width="20%"/>
                            <col width="80%"/>
                        </colgroup>
                        <tbody>
                            <tr>
                                <td>고객사</td>
                                <td>
                                    <input type="text" id="client_name" name="name" class="form-control client" placeholder="고객사">
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    </form>
                    <!-- 교육기관 -->
                    <form name="instituteForm" method="post">
                        <table border="0" class="addTable institute">
                            <colgroup>
                                <col width="20%"/>
                                <col width="80%"/>
                            </colgroup>
                            <tbody>
                                <tr>
                                    <td>교육기관명</td>
                                    <td>
                                        <input type="text" id="institute_name" name="name" class="form-control institute" placeholder="교육기관명">
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </form>
                    <!-- 직위 -->
                    <form name="spotForm" method="post">
                        <table border="0" class="addTable spot">
                            <colgroup>
                                <col width="20%"/>
                                <col width="80%"/>
                            </colgroup>
                            <tbody>
                                <tr>
                                    <td>직위명</td>
                                    <td>
                                        <input type="text" id="spot_name" name="name" class="form-control spot" placeholder="직위명">
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </form>
                    <!-- 직종 -->
                    <form name="occupationForm" method="post">
                        <table border="0" class="addTable occupation">
                            <colgroup>
                                <col width="20%"/>
                                <col width="80%"/>
                            </colgroup>
                            <tbody>
                                <tr>
                                    <td>직종명</td>
                                    <td>
                                        <input type="text" id="occupation_name" name="name" class="form-control occupation" placeholder="직종명">
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </form>
                    <!-- 직무 -->
                    <form name="taskForm" method="post">
                        <table border="0" class="addTable task">
                            <colgroup>
                                <col width="20%"/>
                                <col width="80%"/>
                            </colgroup>
                            <tbody>
                                <tr>
                                    <td>직무명</td>
                                    <td>
                                    	<select name="occupation" id="upper_task_nm" class ="form-select task" >
					                        <option value="">직종 선택</option>
					                        <c:forEach var="occupation" items="${occupation}">
					                        <option value="${occupation.occupation_nm}"><c:out value="${occupation.name}"/></option>
					                        </c:forEach>
					                    </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>직무명</td>
                                    <td>
                                        <input type="text" id="task_name" name="name" class="form-control task" placeholder="직무명">
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </form>
                    <!-- 지역 -->
                    <form name="areaForm" method="post">
                        <table border="0" class="addTable area">
                            <colgroup>
                                <col width="20%"/>
                                <col width="80%"/>
                            </colgroup>
                            <tbody>
                                <tr>
                                    <td>지역명</td>
                                    <td>
                                        <input type="text" id="arae_name" name="name" class="form-control area" placeholder="지역명">
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </form>
                    <!-- 자격증 -->
                    <form name="qualifiForm" method="post">
                        <table border="0" class="addTable qualifi">
                            <colgroup>
                                <col width="20%"/>
                                <col width="80%"/>
                            </colgroup>
                            <tbody>
                                <tr>
                                    <td>자격증명</td>
                                    <td>
                                        <input type="text" id="qualifi_name" name="qualifi_name" class="form-control qualifi" placeholder="자격증명">
                                    </td>
                                </tr>
                                <tr>
                                    <td>발행기관</td>
                                    <td>
                                        <input type="text" id="qualifi_issuer" name="issuer" class="form-control qualifi" placeholder="발행기관">
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </form>
                </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="option-save-btn">저장</button>
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
            </div>
        </div>
    </div>
</div>


<!-- 수정 모달 -->
<div class="modal fade" id="updateSetting" tabindex="-1" aria-labelledby="updateSettingLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="updateModalLabel">수정</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
                <div class="modal-body">
                    <!-- 고객사 -->
                    <form name="clientUpdateForm" method="post">
                        <input type="hidden" id="update_client_nm" name="client_nm">
                        <table border="0" class="addTable client">
                            <colgroup>
                                <col width="20%"/>
                                <col width="80%"/>
                            </colgroup>
                            <tbody>
                                <tr>
                                    <td>고객사</td>
                                    <td>
                                        <input type="text" id="update_client_name" name="name" class="form-control client" placeholder="고객사">
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </form>
                    <!-- 교육기관 -->
                    <form name="instituteUpdateForm" method="post">
                        <input type="hidden" id="update_institute_nm" name="institute_nm">
                        <table border="0" class="addTable institute">
                            <colgroup>
                                <col width="20%"/>
                                <col width="80%"/>
                            </colgroup>
                            <tbody>
                                <tr>
                                    <td>교육기관명</td>
                                    <td>
                                        <input type="text" id="update_institute_name" name="name" class="form-control institute" placeholder="교육기관명">
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </form>
                    <!-- 직위 -->
                    <form name="spotUpdateForm" method="post">
                        <input type="hidden" id="update_spot_nm" name="spot_nm">
                        <table border="0" class="addTable spot">
                            <colgroup>
                                <col width="20%"/>
                                <col width="80%"/>
                            </colgroup>
                            <tbody>
                                <tr>
                                    <td>직위명</td>
                                    <td>
                                        <input type="text" id="update_spot_name" name="name" class="form-control spot" placeholder="직위명">
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </form>
                    <!-- 직종 -->
                    <form name="occupationUpdateForm" method="post">
                        <input type="hidden" id="update_occupation_nm" name="occupation_nm">
                        <table border="0" class="addTable occupation">
                            <colgroup>
                                <col width="20%"/>
                                <col width="80%"/>
                            </colgroup>
                            <tbody>
                                <tr>
                                    <td>직종명</td>
                                    <td>
                                        <input type="text" id="update_occupation_name" name="name" class="form-control occupation" placeholder="직종명">
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </form>
                    <!-- 직무 -->
                    <form name="taskUpdateForm" method="post">
                        <input type="hidden" id="update_task_nm" name="task_nm">
                        <table border="0" class="addTable task">
                            <colgroup>
                                <col width="20%"/>
                                <col width="80%"/>
                            </colgroup>
                            <tbody>
                                <tr>
                                    <td>직종명</td>
                                    <td>
                                    	<select name="occupation" id="update_occupation" class ="form-select task" >
					                        <option value="">직종 선택</option>
					                        <c:forEach var="occupation" items="${occupation}">
					                        <option value="${occupation.occupation_nm}"><c:out value="${occupation.name}"/></option>
					                        </c:forEach>
					                    </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>직무명</td>
                                    <td>
                                        <input type="text" id="update_task_name" name="name" class="form-control task" placeholder="직무명">
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </form>  
                    <!-- 지역 -->
                    <form name="areaUpdateForm" method="post">
                    <input type="hidden" id="update_id" name="id">
                        <table border="0" class="addTable area">
                            <colgroup>
                                <col width="20%"/>
                                <col width="80%"/>
                            </colgroup>
                            <tbody>
                                <tr>
                                    <td>지역명</td>
                                    <td>
                                        <input type="text" id="update_area_name" name="name" class="form-control area" placeholder="지역명">
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </form>                  
                    <!-- 자격증 -->
                    <form name="qualifiUpdateForm" method="post">
                        <input type="hidden" id="update_qualifi_nm" name="qualifi_nm">
                        <table border="0" class="addTable qualifi">
                            <colgroup>
                                <col width="20%"/>
                                <col width="80%"/>
                            </colgroup>
                            <tbody>
                                <tr>
                                    <td>자격증명</td>
                                    <td>
                                        <input type="text" id="update_qualifi_name" name="qualifi_name" class="form-control qualifi" placeholder="자격증명">
                                    </td>
                                </tr>
                                <tr>
                                    <td>발급기관</td>
                                    <td>
                                        <input type="text" id="update_qualifi_issuer" name="issuer" class="form-control qualifi" placeholder="발급기관">
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </form>
                </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="option-update-btn">수정</button>
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
            </div>
        </div>
    </div>
</div>
</div>

</body>
</html>
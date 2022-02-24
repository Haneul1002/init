<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta id="_csrf" name="_csrf" content="${_csrf.token}"/>
<!-- default header name is X-CSRF-TOKEN -->
<meta id="_csrf_header" name="_csrf_header" content="${_csrf.headerName}"/>
<title>외주인력관리시스템</title>

	<link rel="shortcut icon" href="/images/favicon.ico">
	<link rel="shortcut icon" href="/images/favicon.ico">
	<link rel="stylesheet" type="text/css" media="screen" href="/jquery-ui-1.12.1.custom/jquery-ui.min.css"/>
    <link rel="stylesheet" type="text/css" media="screen" href="/jqGrid/css/ui.jqgrid.css"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" media="screen" href="/css/main.css" />
    <link type="text/css" rel="stylesheet" href="/css/maingrid.css"/>
    
    <script src="/js/html2canvas.js"></script>
				<script src="/js/jspdf.min.js"></script>
    <script src="/js/jquery-3.6.0.min.js" type="text/javascript"></script>
    <script src="/js/main.js" type="text/javascript"></script>
    <!-- <script src="/jquery-ui-1.12.1.custom/jquery-ui.min.js" type="text/javascript"></script> -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>
    <script src="/jqGrid/js/jquery-1.7.2.min.js" type="text/javascript"></script>
    <script src="/jqGrid/js/i18n/grid.locale-kr.js" type="text/javascript"></script>
    <script src="/jqGrid/js/jquery.jqGrid.min.js" type="text/javascript"></script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>

<jsp:include page="../layout/navbar.jsp"></jsp:include>
    <!-- 검색창-->
    

    <!-- jqGrid -->
    <div class="grid-container" style="padding: 15px;width:2000px; display:inline-block;">
    <form id="search_form" name="search_form" method="POST">
    <input type="hidden" name="imgsrc" value="${pageContext.request.contextPath}/resources/images/detail.png">
        <!-- <div style = "margin-top : 20px; margin-left : 15px; margin-right: 15px; font-size : 12px; display:inline-block;"> -->
          <button type="button" class="btn btn-primary" id="add-btn">추가</button>
<input type="hidden" id="Id" name="Id"/>
          <img >
          <!-- <button type="button" class = "btn btn-info btn-fill" id ="search" onclick="searchForm()" style = "width : 6%; float : right; margin-left : 30px;">
            검색창 ▼
          </button> -->
          <table class="searchTable" border="0" bgcolor="#D8D8D8" width="50px" style="float:center">
            <colgroup>
              <col width="3%"/>
              <col width="96%"/>
              <col width="1%"/>
              <%-- <col width="20%"/> --%>
            </colgroup>
            <tbody >
              <tr>
              		<td></td>
                <td class="searchTitle">이름</td>
              </tr>
              <tr>
              		<td></td>
              	 <td><input class="form-control" type="text" placeholder="이름" name="nameSearch"></td>
              </tr>
              <tr>
             			<td></td>
              <td class="searchTitle">직종</td>
              </tr>
              <tr>
                <td></td>
                <td>
                    <select name="occupation" id="search_occupation" class ="form-select" onchange='SearchoccupationSelected(this)'>
                        <option value="">직종 선택</option>
                        <c:forEach var="occupation" items="${occupation}">
                        <option value="${occupation.occupation_nm}"><c:out value="${occupation.name}"/></option>
                        </c:forEach>
                    </select>
                </td>
              </tr>
              <tr>
              <td></td>
              <td class="searchTitle">직무</td>
              </tr>
              <tr>
                <td></td>
                <td>
                    <select name="task" id="search_Task" class ="form-select" disabled>
                        <option class="Searchoccupation0" value="">직무 선택</option>
                        <c:forEach var="task" items="${task}">
                        <option class="Searchoccupation${task.occupation} searchtask" value="${task.task_nm}"><c:out value="${task.name}"/></option>
                        </c:forEach>
                    </select>
                </td>
              </tr>
              <tr>
              		<td></td>
              		<td class="searchTitle">경력(년도)</td>
              </tr>
              <tr>
                <td></td>
                <td>
                			<input type="checkbox" value="12"id="careerChecked" name="careerChecked"  onchange="SearchCareerChecked()" class="careerCheckBox form-check-input">
                  	<input type="number" name="careerStart" id="career0" class="form-control" placeholder="최소경력" style="width:110px; text-align: center; display:inline-flex;" disabled><label class="form-check-label" for="career0" style="font-weight:bold;">&nbsp;~&nbsp;</label>
                   <input type="number" name="careerEnd" id="career1" class="form-control" placeholder="최대경력" style="width:110px; text-align: center; display:inline-flex;" disabled><label class="form-check-label" for="career0" style="font-weight:bold;"></label><br/>
                  <!-- <input type="radio" name="careerRadio" id="career1" class="form-check-input" value="1"><label class="form-check-label" for="career1">1년 이상</label><br/>
                  <input type="radio" name="careerRadio" id="career3" class="form-check-input" value="3"><label class="form-check-label" for="career3">3년 이상</label><br/>
                  <input type="radio" name="careerRadio" id="career5" class="form-check-input" value="5"><label class="form-check-label" for="career5">5년 이상</label> -->
                </td>
              </tr>
              <tr>
             		 <td></td>
                <td class="searchTitle">자격증</td><br>
                
              </tr>
              <tr>
		              <td></td>
		              <td>
		              <div style="max-height:90px; overflow:auto;">
                  <c:forEach var="qualifi" items="${qualifi}">
                  		<div style="display:inline-block">           
				                    <input type="checkbox" value="${qualifi.qualifi_nm}" id="qualifi<c:out value='${qualifi.qualifi_nm}'/>" name="qualifi[]" class="qualifiCheckBox form-check-input">
				                    <label class="form-check-label" for="qualifi<c:out value='${qualifi.qualifi_nm}'/>"><c:out value="${qualifi.qualifi_name}"/></label>
                    </div><br/>
                  </c:forEach>
                  </div>
                </td>
              </tr>
              
              <tr>
             		 <td></td>
             		 <td class="searchTitle">근무가능지역</td>
              </tr>
              <tr>
                <td></td>
                <td>
                 <div style="max-height:90px; overflow:auto;">
                   <c:forEach var="area" items="${area}">
                	 	<input type="checkbox" value="${area.name}" id="area<c:out value="${area.id}"/>" name="area[]" class="areaCheckBox form-check-input">
                    	<label class="form-check-label" for="area<c:out value="${area.id}"/>"><c:out value="${area.name}"/></label>
                    	<br/>
                	</c:forEach>
                 </div>
                </td>
              </tr>
              <tr>
              		<td></td>
              		<td class="searchTitle">고객사</td>
              </tr>
              <tr>
                <td></td>
                <td>
                <div style="max-height:90px; overflow:auto;">
                	<c:forEach var="client" items="${client}">
                					<div style="display:inline-block">
					                    <input type="checkbox" value="${client.client_nm}" id="client<c:out value="${client.client_nm}"/>" name="client[]" class="clientCheckBox form-check-input">
					                    <label class="form-check-label" for="client<c:out value="${client.client_nm}"/>"><c:out value="${client.name}"/></label>
	                    </div>
	                    <br/>
                  	</c:forEach>
                 </div>
                </td>
              </tr>
              
              <tr>
              <td></td>
                <!-- <td></td> -->
                <td class="searchButtonSet">
                  <button type="button" class="btn btn-primary" onclick="searchUser()">검색</button>
                  <button type="button" class="btn btn-danger" onclick="searchReset()">초기화</button>
                </td>
              </tr>
            </tbody>
          </table>
          <table id="userList"style="float:left"></table>
      <div id="userListpager"></div>
        <!-- </div> -->
    </form>
      
    </div>
    <!-- 넘겨주는 값 저장하는 장소 -->
    <input type="hidden" id="param" name="param" value="data_1"/>

    <!-- 추가 모달 -->
    <div class="modal fade" id="addModal" tabindex="-1" aria-labelledby="addModalLabel" aria-hidden="true">
      <div class="modal-dialog modal-lg">
        <div class="modal-content">

          <div class="modal-header">
            <h5 class="modal-title" id="addModalLabel">추가</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>

        <form name="addForm" method="post">
          <div class="modal-body">
            <table class="detailTable" border="0">
              <colgroup>
                  <col width="30%"/>
                  <col width="70%"/>
              </colgroup>
              <tbody>
                  <tr>
                      <td>이름</td>
                      <td><input type="text"    id="info_name"      name="name"     class="form-control" placeholder="이름" ></td>
                  </tr>
                  <tr>
                      <td>생년월일</td>
                      <td><input type="date"    id="info_birth"     name="birth"    class="form-control" placeholder="생년월일" onfocus="(this.type='date')" onblur="(this.type='text')"></td>
                  </tr>   
                  <tr>
                      <td>휴대폰</td>
                      <td><input type="tel"     id="info_phone"     name="phone"    class="form-control" placeholder="휴대폰"></td>
                  </tr>
                  <tr>
                      <td>이메일</td>
                      <td><input type="email"   id="info_email"     name="email"    class="form-control" placeholder="이메일"></td>
                  </tr>
                  <tr>
                    <td>주소</td>
                    <td><input type="text"   id="info_address"     name="address"    class="form-control" placeholder="주소" onclick="AddressSearch()"></td>
                  </tr>
                  <tr>
                    <td>상세주소</td>
                    <td><input type="text"   id="info_detailaddress"     name="detailaddress"    class="form-control" placeholder="상세주소"></td>
                  </tr>
                  <tr>
                    <td>근무가능지역</td>
                    <td>
                        <c:forEach var="area" items="${area}">
                        	<input type="checkbox" id="info_area<c:out value='${area.id}'/>" name="area" class="form-check-input areaCheckBox" value="<c:out value='${area.name}'/>"/>
                        	<label class="form-check-label" for="info_area<c:out value='${area.id}'/>"><c:out value='${area.name}'/></label>
                        </c:forEach>
                    </td>
                  </tr>
              </tbody>
            </table>
          </div>
        </form>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
            <button type="button" class="btn btn-primary" id="user-add-btn" onClick="userAdd()">저장</button>
          </div>
        </div>
      </div>
    </div>

</body>
</html>
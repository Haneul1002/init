<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta id="_csrf" name="_csrf" content="${_csrf.token}"/>
<!-- default header name is X-CSRF-TOKEN -->
<meta id="_csrf_header" name="_csrf_header" content="${_csrf.headerName}"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${detailset.name}</title>

<link rel="stylesheet" type="text/css" media="screen" href="/jquery-ui-1.12.1.custom/jquery-ui.min.css"/>
<script src="/js/jquery-3.6.0.min.js" type="text/javascript"></script>
<script src="/js/html2canvas.js"></script>
<script src="/js/jspdf.min.js"></script>
<script src="/js/pdfsave.js"></script>


<script type="text/javaScript" language="javascript" defer="defer">
$(document).ready (function(){  
	var now=new Date();
	var year = now.getFullYear();
	var month = now.getMonth() + 1;   
	var date = now.getDate();      
	if((month+"").length < 2) {  // 월이 한자리 수인 경우 앞에 0을 붙여줘서 두자리로 만들어 준다.
	     month = "0" + month;
	    }
	 
	    if((date+"").length < 2) {       // 일이 한자리 수인 경우 앞에 0을 붙여준다.
	     date = "0" + date;
	    }
	today = year +"년&nbsp;&nbsp;&nbsp;" + month + "월&nbsp;&nbsp;&nbsp;" + date + "일";
	$('#today').append(today);
});
</script>    
</head>
<body>
<div style="width:1000px; margin:0 auto;">
	<button type="button" onclick="location.href='javascript:pdfSave();'">PDF 저장</button>
	<button type="button" onclick="location.href='javascript:history.back();'">뒤로가기</button>
</div>
<div id="pdfDiv" style="width:1000px; margin:0 auto;">
<br/>
<br/>
	<input type="hidden" id="user_name" name="user_name" value="${detailset.name}"/>
	<table border="1" width="990px" cellspacing="0" style="border:gray">
		<tr>
			<td rowspan="7"  width ="85" height="113" align="center">
			<c:if test="${detailset.imgname!=null}">
				<img alt="사진" src="${pageContext.request.contextPath}/resources/images/${detailset.imgname}" width="100%" height="auto">
			</c:if>
			<c:if test="${detailset.imgname==null}">
				(사 진)
			</c:if>
			</td>
			<th colspan="9" height="50"><font size="5">이  력  서</font></th>
		</tr>
		<tr>
			<th rowspan="1" width = "85" bgcolor="D5D5D5">성 명</th>
		
		
			<td width="120" align="center">${detailset.name}</td>
			<th  bgcolor="D5D5D5" width="90">생 년 월 일</th>
			<td width="240" align="center">${detailset.birth}</td>
			
		</tr>
			<tr>
			
		</tr>
		<tr>
			<th colspan="1" width="50"  bgcolor="D5D5D5">연 락 처</th>
			<td colspan="1"  align="center">${detailset.phone}</td>
			<th colspan="1" width = "50"  bgcolor="D5D5D5">이 메 일</th>
			<td colspan="1"  align="center">${detailset.email}</td>
		</tr>
		<tr>
			<th bgcolor="D5D5D5">주 소</th>
			<td colspan="8" align="center">${detailset.address}&nbsp;${detailset.detailaddress}</td>
		</tr>
		<tr>
			<th bgcolor="D5D5D5">직종 / 직무</th>
			<td colspan="8" align="center">${detailset.oname}&nbsp;/&nbsp;${detailset.tname}</td>
		</tr>
		<tr>
			<th colspan="1" width = "50"  bgcolor="D5D5D5">근무경력</th>
			<td colspan="1"  align="center">${workDay.work_year}&nbsp;${workDay.work_month}</td>
			<th colspan="1" width="50"  bgcolor="D5D5D5">기술경력</th>
			<td colspan="1"  align="center">${careerDay.career_year}&nbsp;${careerDay.career_month}</td>
		</tr>
	</table>
	<table border="1"width="990px" cellspacing="0" style="border:gray">
		<!-- -----------------------근무경력사항-------------------------------- -->
		<tr>	
			<th colspan="4" width = "790"  bgcolor="D5D5D5" >근 무 경 력</th>
		</tr>
		<tr>
			<th width="100" bgcolor="D5D5D5" >회사명</th>
			<th width="100" bgcolor="D5D5D5">근무기간</th>
			<th bgcolor="D5D5D5">담당업무</th>
			<th bgcolor="D5D5D5">부서 / 직위</th>
		</tr>
		<c:forEach var="work" items="${work}" varStatus="status">
			<tr>
				<td align="center" width="100">${work.company_name}</td>
				<td align="center" width="50">${work.start_date} ~ ${work.end_date}</td>
				<td align="center">${work.occupation} > ${work.task}</td>
				<td align="center">${work.department} / ${work.spot}</td>
			</tr>
		</c:forEach>
		<c:if test="${work[0].company_name==null}">
			<tr>
				<td height="20"></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</c:if>
		<!-- -----------------------자격증-------------------------------- -->
		<tr style="border-top:black">
			<th colspan = "4" bgcolor="D5D5D5" >기 술 자 격</th>
		</tr>
		<tr>
			<th width="100" bgcolor="D5D5D5">자격증명</th>
			<th width="120" bgcolor="D5D5D5">발급번호</th>
			<th width="100" bgcolor="D5D5D5">취득일</th>
			<th width="120" bgcolor="D5D5D5">발급기관</th>
		</tr>
		<c:forEach var="qual" items="${qual}" varStatus="status">
			<tr>
				<td align="center">${qual.name}</td>
				<td align="center">${qual.reg_num}</td>
				<td align="center">${qual.reg_date}</td>
				<td align="center">${qual.issuer}</td>
			</tr>
		</c:forEach>
		<c:if test="${qual[0].name==null}">
			<tr>
				<td height="20"></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</c:if>
		<!-- -----------------------학력사항-------------------------------- -->
		<tr style="border-top:black">
			<th colspan = "4" bgcolor="D5D5D5">학 력</th>
		</tr>
		<tr>
			<th width="100" bgcolor="D5D5D5">학교명</th>
			<th width="120" bgcolor="D5D5D5">학과(전공)</th>
			<th width="100" bgcolor="D5D5D5">학위</th>
			<th width="100" bgcolor="D5D5D5">수학기간</th>
		</tr>
		<c:forEach var="edu" items="${edu}" varStatus="status">
			<tr>
				<td align="center">${edu.name}</td>
				<td align="center">${edu.department}</td>
				<td align="center">${edu.degree}</td>
				<td align="center">${edu.start_date} ~ ${edu.end_date}</td>
			</tr>
		</c:forEach>
		<c:if test="${edu[0].name==null}">
			<tr>
				<td height="20"></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</c:if>
		<!-- -----------------------교육사항-------------------------------- -->
		<tr style="border-top:black">
			<th colspan = "4" bgcolor="D5D5D5">교 육</th>
		</tr>
		<tr>
			<th width="100" bgcolor="D5D5D5">과정명</th>
			<th width="120" bgcolor="D5D5D5">교육기관명</th>
			<th width="100" bgcolor="D5D5D5">수료번호</th>
			<th width="100" bgcolor="D5D5D5">기간</th>
		</tr>
		<c:forEach var="eduMatter" items="${eduMatter}" varStatus="status">
			<tr>
				<td align="center">${eduMatter.course_name}</td>
				<td align="center">${eduMatter.institation}</td>
				<td align="center">${eduMatter.completion_number}</td>
				<td align="center">${eduMatter.start_date} ~ ${eduMatter.end_date}</td>
			</tr>
		</c:forEach>
		<c:if test="${eduMatter[0].course_name==null}">
			<tr>
				<td height="20"></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</c:if>
		<!-- -----------------------상훈-------------------------------- -->
		<tr style="border-top:black">
			<th colspan = "4" bgcolor="D5D5D5">상 훈</th>
		</tr>
		<tr>
			<th width="100" bgcolor="D5D5D5">종류</th>
			<th width="120" bgcolor="D5D5D5">상훈기관</th>
			<th width="100" bgcolor="D5D5D5">연 월 일</th>
			<th width="100" bgcolor="D5D5D5">근거</th>
		</tr>
		<c:forEach var="prize" items="${prize}" varStatus="status">
			<tr>
				<td align="center">${prize.name}</td>
				<td align="center">${prize.agency}</td>
				<td align="center">${prize.reg_date}</td>
				<td align="center">${prize.evidence}</td>
			</tr>
		</c:forEach>
		<c:if test="${prize[0].name==null}">
			<tr>
				<td height="20"></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</c:if>
		<!-- -----------------------기술경력-------------------------------- -->
		<tr style="border-top:black">
			<th colspan = "4" bgcolor="D5D5D5">기 술 경 력</th>
		</tr>
		<!-- <tr>
			<th width="100" bgcolor="D5D5D5">사업명</th>
			<th width="120" bgcolor="D5D5D5">참여기간</th>
			<th width="100" bgcolor="D5D5D5">고객사</th>
			<th width="100" bgcolor="D5D5D5">업종</th>
		</tr> -->
		
			<tr>
				<!-- <th rowspan="3" width="10" bgcolor="D5D5D5">1</th> -->
				<th width="100" bgcolor="D5D5D5">사업명</th>
			<th width="120" bgcolor="D5D5D5">참여기간</th>
			<th width="100" bgcolor="D5D5D5">고객사</th>
			<th width="100" bgcolor="D5D5D5">직종 / 직무</th>
			</tr>
			<c:forEach var="career" items="${career}" varStatus="status">
			<tr>
				<td align="center">${career.project_name}</td>
				<td align="center">${career.start_date} ~ ${career.end_date}</td>
				<td align="center">${career.client_name}</td>
				<td align="center">${career.occupation} / ${career.task}</td>
			</tr>
		</c:forEach>
			
		<c:if test="${career[0].project_name==null}">
			<tr>
				<td height="20"></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</c:if>
		<!-- <tr>
			<th bgcolor="D5D5D5">참 고 사 항</th>
			<td colspan="5"></td>
		</tr> -->
		<tr>
			<td colspan="6">
				<p style = "text-align:center" >위 기재 사항은 사실과 틀림이 없습니다. </p>
				<br/>
				<br/>
				<p style = "text-align:center" id="today" ></p>
				<br/>
				<p style = "text-align:center; font-size:30px;" >주식회사 인아이티</p>
			</td>
		</tr>
	</table>
</div>
</body>
</html>
</body>
</html>
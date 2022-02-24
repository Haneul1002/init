<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>외주인력관리시스템</title>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    
</head>
<body>
	<div style="text-align : center; width : 300px; margin : auto; margin-top : 260px;">
		<h2>외주인력관리시스템</h2>
		<h2>${error}</h2> 
		<h2>${logout}</h2> 
		<form action="${pageContext.request.contextPath}/users/login-processing" method="post"> 
			<div>
				<label for="id" class="form-lable">아이디</label>
				<input type="text" class="form-control" name="id" id="id" placeholder="아이디"/>
			</div> 
			<div> 
				<label for="password" class="form-lable">비밀번호</label>
				<input type="password" class="form-control" name="password" id="password" placeholder="비밀번호"/>
			</div> 
			<div style="margin-top : 15px;">
				<button type="submit" class="btn btn-primary">로그인</button>
				
			</div>
			<div style="margin-top : 15px;">
				<button type="button" name="register" class="btn btn-secondary" onclick="location.href='/users/register'" >회원가입</button>
			</div> 
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
			
		</form>
	</div>
</body>
</html>
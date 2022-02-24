<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!-- 네비바-->	    
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark"> 
        
        <a class="navbar-brand mx-3" href="/">외주인력관리시스템</a> 

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar"> 
            <span class="navbar-toggler-icon"></span>
        </button> 
        <div class="collapse navbar-collapse" id="collapsibleNavbar"> 


            <ul class="navbar-nav navbar-dark"> 	            
	            <li class="nav-item active">
	                <sec:authorize access="hasAuthority('ROLE_ADMIN')">
	                   	<a class="nav-link mx-2" href="/setting">코드 설정</a> 
	                </sec:authorize>
	            </li>   
            </ul>   
        </div>
		    <sec:authorize access="isAnonymous()">
		        <button type="button" class="btn btn-primary mx-3" onclick="location.href = '/users/login';">로그인</button>
		    </sec:authorize>
		    <sec:authorize access="isAuthenticated()">
		    		<button type="button" class="btn btn-danger mx-3" onclick="location.href = '/users/logout';">로그아웃</button>
		    </sec:authorize>
    </nav>
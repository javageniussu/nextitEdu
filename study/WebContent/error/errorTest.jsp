<%@page import="kr.or.nextit.function.service.impl.ComCodeServiceImpl"%>
<%@page import="kr.or.nextit.function.service.ComCodeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<c:import url="/inc/lib.jsp"></c:import>
</head>
<body>
	
	<c:import url="/inc/navbar.jsp"></c:import>	
	<div class="container">
	
	<%
	//try {
		ComCodeService codeService =new ComCodeServiceImpl();
	
		/* codeService.getErrorTest("aaa111"); */
		//codeService.getErrorTest2("이름2");
		codeService.getBizErrorTest("김현슈");
	//} catch (Exception ex) {
	//	out.println(ex.getMessage());
	//}
	%>
		
	</div>
</body>
</html>
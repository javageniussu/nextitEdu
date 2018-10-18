<%@ page languagkr.or.nextit.function.service.ComCodeVo=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="kr.or.nextit.function.MemberUjava.util.* page import="kr.or.nkr.or.nextit.function.MemberUtil
	request.setCharactekr.or.nextit.function.service.*l utils request.setCharacterEncoding("UTF-8"); 

	MemberUtil utils = new MemberUtil();/EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<jsp:include page="/inc/lib.jsp"></jsp:include>
</head>
<body>

	<jsp:include page="/inc/navbar.jsp"></jsp:include>

	<div class="container">

	<form action="/04/memberProc.jsp" method="post">
		<table class="table">
			<tbody>
				<tr>
					<td>아이디</td>
					<td> 
						<input type="text" name="userId" class="form-control"> 
					</td>
				</tr>
				<tr>
					<td>이름</td>
					<td> 
						<input type="text" name="userName" class="form-control"> 
					</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td> 
						<input type="password" name="userPw" class="form-control"> 
					</td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td> 
						<input type="text" name="userHp" class="form-control"> 
					</td>
				</tr>
				<tr>
					<td>성별</td>
					<td> 
					<%
 						List<CommCodeVo> items = List<CommCodeVo> items = utils.getSexItems();
 								/* for(CommCodeVo item : items) {
 									out.println(item.getKey());
 									out.println(item.getValue());
 								} */Sex"> 
 									<%for(CommCodeVo item : itemfor(ComCodeVo item : items) {=item.getKey()
 					%>"><%=item.geitem.getKey()option>item.getValue()				</select> 
					}					</td>
				</tr>
				<tr>
					<td>취미</td>
					<td> 
						<%
						List<CommCodeVo> List<ComCodeVo> hobby = utils.getHobbyItems();
						
						for(ComCodeVo item : hobby) {name="userHobby" value="<%=item.getKey()%>"> 
						<%=item.getValue()%> <br>
						<%} %> 
						
					</td>
				</tr>
				<tr>
					<td>e-mail</td>
					<td> 
						<input type="email" name="userEmail"> 
					</td>
				</tr>
				<tr>
					<td colspan="2"> 
						<button type="submit">가입</button> 
					</td>
				</tr>
				
			</tbody>
		</table>
</form>

	</div>

</body>
</html>
<%@page import="vo.MemberMoneyVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vo.MemberVo"%>
<%@ page import="dao.MemberDao"%>
<%@ page import="java.util.ArrayList"%>    
    
<%
	MemberDao dao = new MemberDao();
	ArrayList<MemberMoneyVo> list = dao.memberMoneyList();
%>   
   
<jsp:include page="master/header.jsp"/>    
    
<section>
	<div class="container">
		<p class="title">회원매출조회</p>

<%
	if(!list.isEmpty()) {
%>			
	<table>
		<tr>
			<td>회원번호</td>
			<td>회원성명</td>
			<td>회원전화</td>
			<td>회원주소</td>
		</tr>
<%
	for(MemberMoneyVo member:list) { %>
		<tr>
			<td><%=member.getCustno() %></td>
			<td><%=member.getCustname() %></td>
			<td><%=member.getGrade() %></td>
			<td><%=member.getPrice() %></td>
			
		</tr>
<% }
%>	
	</table>
<%}
	else{ %>

	<p style="text-align: center">등록된 매출 정보가 없습니다</p>	
<% 
	}
%>	
	
	</div>
</section> 
    
<jsp:include page="master/footer.jsp"/>
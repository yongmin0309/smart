
<%@page import="vo.MentoVo"%>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="master/header.jsp"/>

<section>
		<div class="container">
			<p class="title">회원목록조회/수정</p>
<%
	ArrayList<MentoVo> list = (ArrayList<MentoVo>)request.getAttribute("list");
	if(!list.isEmpty()) {
%>		

	<table>
		<tr>
			<td>참가번호</td>
			<td>참가자명</td>
			<td>생년월일</td>
			<td>점수</td>
			<td>등급</td>
			<td>멘토</td>
		</tr>
		
<%
	for(MentoVo mento : list) {
		request.setAttribute("mento", mento);
%>			
	<tr>	
					<td>${mento.serial_no }</td>
					<td>${mento.artist_name }</td>
					<td>${mento.artist_birth }</td>
					<td>${mento.point }</td>
					<td>${mento.point_rank }</td>
					<td>${mento.mento_name }</td>
	</tr>
<%
	}
%>						
	</table>
<%
	}else{
%>		
	<p style="text-align: cneter"> 등록된 회원 정보가 없습니다</p>
<%
	}
%>
		</div>
</section>


<jsp:include page ="master/footer.jsp"/>

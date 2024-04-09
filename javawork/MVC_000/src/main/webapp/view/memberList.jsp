
<%@ page import="vo.MemberVo" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="master/header.jsp"/>

<section>
		<div class="container">
			<p class="title">회원목록조회/수정</p>
<%
	ArrayList<MemberVo> list = (ArrayList<MemberVo>)request.getAttribute("list");
	if(!list.isEmpty()) {
%>		

	<table>
		<tr>
			<td>참가자번호</td>
			<td>참가자명</td>
			<td>생년월일</td>
			<td>성별</td>
			<td>특기</td>
			<td>소속사</td>
		</tr>
		
<%
	for(MemberVo member : list) {
		request.setAttribute("member", member);
%>			
	<tr>
	
				<td>${member.artist_id}</td>
				<td>${member.artist_name }</td>
				<td>${member.artist_birth }</td>
				<td>${member.artist_gender }</td>
				<td>${member.talent }</td>
				<td>${member.agency }</td>									
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

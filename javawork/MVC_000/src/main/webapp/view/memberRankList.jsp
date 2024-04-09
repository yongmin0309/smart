<%@page import="vo.MemberRankVo"%>

<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="master/header.jsp"/>

<section>
		<div class="container">
			<p class="title">회원목록조회/수정</p>
<%
	ArrayList<MemberRankVo> list = (ArrayList<MemberRankVo>)request.getAttribute("list");
	if(!list.isEmpty()) {
%>		

	<table>
		<tr>
			<td>참가번호</td>
			<td>합산점수</td>
			<td>평균</td>
			<td>등위</td>
		</tr>
		
<%
	for(MemberRankVo mbrank : list) {
		request.setAttribute("mbrank", mbrank);
%>			
	<tr>	
					<td>${mbrank.artist_name }</td>
					<td>${mbrank.point_sum }</td>
					<td>${mbrank.point_avg }</td>
					<td>${mbrank.point_rk }</td>
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
<%@page import="vo.CourseVo"%>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="master/header.jsp"/>

<section>
		<div class="container">
			<p class="title">회원목록조회/수정</p>
<%
	ArrayList<CourseVo> list = (ArrayList<CourseVo>)request.getAttribute("list");
	if(!list.isEmpty()) {
%>		

	<table>
		<tr>
			
			<td>과목코드</td>
			<td>과목명</td>
			<td>학점</td>
			<td>담당강사</td>
			<td>요일</td>
			<td>시작시간</td>
			<td>종료시간</td>
			<td>삭제</td>
		</tr>
		
<%
	for(CourseVo course : list) {
		request.setAttribute("course", course);
%>			
	<tr>
	
		<td><a href="/courseUpdate?id=${course.id }">${course.id }</a></td>
											<td>${course.name }</td>
											<td>${course.credit }</td>
											<td>${course.lecturer }</td>
											<td>${course.week }</td>
											<td>${course.start_hour }</td>
											<td>${course.end_hour }</td>	
		<td><a href="/courseDelete?id=${course.id }">삭제</a></td>													
		</tr>
<%
	}
%>						
	</table>
<%
	}else{
%>		
	<p style="text-align: center"> 등록된 회원 정보가 없습니다</p>
<%
	}
%>
		</div>
</section>


<jsp:include page ="master/footer.jsp"/>
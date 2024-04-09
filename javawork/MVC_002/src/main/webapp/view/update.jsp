<%@page import="vo.CourseVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="master/header.jsp"/>

<section>
<div class="container">
	<p class="title">교과목 수정</p>
	<% CourseVo course = (CourseVo)request.getAttribute("course"); %>
	<form action="/courseUpdate" method="post" name="frm">
			<table width="600px">
				<tr>
					<td>과목코드</td>
					<td><input type = "text" value="${course.id}" name="id" id="id" ></td>
				</tr>
				
				<tr>
					<td>과목명</td>
					<td><input type="text" value="${course.name}" id="name" name="name"></td>
				</tr>
				
				<tr>
					<td>학점</td>
					<td><input type="number" value="${course.credit}" id="credit" name="credit"></td>
				</tr>
				
				<tr>
						<td>담당강사</td>
						<td><select id="lecturer" name="lecturer">
								<option value="0">담당강사선택</option>
						
								<option value="1" 
								<%="1".equals(course.getLecturer())?"selected":"" %>>김교수</option>
			
								<option value="2"
								<%="2".equals(course.getLecturer())?"selected":"" %>>이교수</option>
		
								<option value="3"
								<%="3".equals(course.getLecturer())?"selected":"" %>>박교수</option>
								
								<option value="4"
								<%="4".equals(course.getLecturer())?"selected":"" %>>추교수</option>
								
								<option value="5"
								<%="5".equals(course.getLecturer())?"selected":"" %>>최교수</option>
								
								<option value="6"
								<%="6".equals(course.getLecturer())?"selected":"" %>>임교슈</option>
							</select>
						</td>				
				</tr>
				
				<tr>
					<td>요일</td>
					<td>
						<input type="radio" id="week" name="week" value="1" 
						<%="1".equals(course.getWeek())?"chaecked":"" %>>월요일
						<input type="radio" id="week" name="week" value="2"
						<%="2".equals(course.getWeek())?"chaecked":"" %>>화요일
						<input type="radio" id="week" name="week" value="3"
						<%="3".equals(course.getWeek())?"chaecked":"" %>>수요일
						<input type="radio" id="week" name="week" value="4"
						<%="4".equals(course.getWeek())?"chaecked":"" %>>목요일
						<input type="radio" id="week" name="week" value="5"
						<%="5".equals(course.getWeek())?"chaecked":"" %>>금요일
					</td>
				</tr>
												
				<tr>
					<td>시작시간</td>
					<td><input type="number" value="${course.start_hour}" id="start_hour" name="start_hour"></td>
				</tr>
				
					<tr>
					<td>종료시간</td>
					<td><input type="number" value="${course.end_hour}" id="end_hour" name="end_hour"></td>
				</tr>
				
				<tr>
					<td colspan="2" align="center">
					<input type="submit" value="수정" onclick="return checkForm()">
					<input type="button" value="목록" onclick="location.href ='/courseList'">
				</tr>
				
			</table>	
	</form>
</div>
</section>


<script>
	function checkForm() {
		if(document.frm.id.value.trim() == ""){
			alert('참가번호가 입력되지 않았습니다!');
			document.frm.id.focus();
			retuen false;
		}
		if(document.frm.name.value.trim() == ""){
			alert('참가자명가 입력되지 않았습니다!');
			document.frm.name.focus();
			retuen false;
		}
		if(document.frm.credit.value.trim() == ""){
			alert('생년월일이 입력되지 않았습니다!');
			document.frm.credit.focus();
			retuen false;
		}
		if(document.frm.lecture.value == 0){
			alert('성별이 입력되지 않았습니다!');
			document.frm.lecture.focus();
			retuen false;
		}
		if(document.frm.week.value > 5){
			alert('요일이 입력되지 않았습니다!');
			document.frm.week.focus();
			retuen false;
		}
		if(document.frm.start_hour.value.trim() == ""){
			alert('소속사 입력되지 않았습니다!');
			document.frm.start_hour.focus();
			retuen false;
		}
		if(document.frm.end_hour.value.trim() == ""){
			alert('소속사 입력되지 않았습니다!');
			document.frm.end_hour.focus();
			retuen false;
		}
		document.frm.submit();
		}
</script>
<jsp:include page ="master/footer.jsp"/>
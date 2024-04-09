<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="master/header.jsp"/>

<section>
<div class="container">
	<p class="title">점수입력</p>
	<form action="/courseInsert" method="post" name="frm">
			<table width="600px">
				
				<tr>
						<td>학생코드</td>
						<td><select id="lecturer" name="lecturer">
								<option value="0">학생선택</option>
						
								<option value="1">김길동</option>
			
								<option value="2">이길동</option>
		
								<option value="3">박길동</option>
								
								<option value="4">정길동</option>
								
								<option value="5">최길동</option>
								
								<option value="6">황길동</option>
							</select>
						</td>				
				</tr>
				
				<tr>
						<td>담당강사</td>
						<td><select id="lecturer" name="lecturer">
								<option value="0">과목선택</option>
						
								<option value="1">메타버스의이해</option>
			
								<option value="2">게임엔진기초</option>
		
								<option value="3">게임엔진심화</option>
								
								<option value="4">인문학개론</option>
							</select>
						</td>				
				</tr>
				
				<tr>
					<td>중간고사</td>
					<td><input type="number" id="credit" name="credit"></td>
				</tr>
				
				<tr>
					<td>기말고사</td>
					<td><input type="number" id="credit" name="credit"></td>
				</tr>
				
				<tr>
					<td>출석점수</td>
					<td><input type="number" id="credit" name="credit"></td>
				</tr>
				
				<tr>
					<td>과제</td>
					<td><input type="number" id="credit" name="credit"></td>
				</tr>
				
				<tr>
					<td>기타</td>
					<td><input type="number" id="credit" name="credit"></td>
				</tr>
				
												
		
				<tr>
					<td colspan="2" align="center">
					<input type="submit" value="추가" onclick="return checkForm()">
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
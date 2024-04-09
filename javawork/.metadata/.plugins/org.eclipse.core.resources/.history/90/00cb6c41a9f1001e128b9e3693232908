<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="master/header.jsp"/>

<section>
<div class="container">
	<p class="title">홈쇼필 회원 등록</p>
	<form action="/memberInsert" method="post" name="frm">
			<table width="600px">
				<tr>
					<td>회원정보(자동발생)</td>
					<td><input type = "number" value="${custno}" name="custno" id="custno" readonly="readonly"></td>
				</tr>
				
				<tr>
					<td>회원성명</td>
					<td><input type="text" id="custname" name="custname"></td>
				</tr>
				
				<tr>
					<td>회원전화</td>
					<td><input type="text" id="phone" name="phone"></td>
				</tr>
				
				<tr>
					<td>회원주소</td>
					<td><input type="text" id="address" name="address"></td>
				</tr>
				
				<tr>
					<td>가입일자</td>
					<td><input type="text" id="joindate" name="joindate"></td>
				</tr>
				
				<tr>
						<td>고객등급[A:VIP, B:일반, C:직원]</td>
					
					<td><select id="grade" name="grade">
						<option value="A">VIP</option>
		
						<option value="B">일반</option>
		
						<option value="C">직원</option>
					</select></td>						
				</tr>
				
				<tr>
				<td>도시코드</td>
				<td><input type="text" id="city" name="city"></td>
				</tr>
				
				<tr>
					<td colspan="2" align="center">
					<input type="submit" value="가입하기" onclick="return checkForm()">
				</tr>
				
			</table>	
	</form>
</div>
</section>


<script>
	function checkForm() {
		if(document.frm.custname.value.trim() == ""){
			alert('회원성명을 입력하세요');
			document.frm.custname.focus();
			retuen false;
		}
		if(document.frm.phone.value.trim() == ""){
			alert('회원전화을 입력하세요');
			document.frm.phone.focus();
			retuen false;
		}
		if(document.frm.address.value.trim() == ""){
			alert('회원주소을 입력하세요');
			document.frm.address.focus();
			retuen false;
		}
		if(document.frm.joindate.value.trim() == ""){
			alert('가입일자을 입력하세요');
			document.frm.joindate.focus();
			retuen false;
		}
		if(document.frm.grade.value.trim() == ""){
			alert('고객등급을 입력하세요');
			document.frm.grade.focus();
			retuen false;
		}
		if(document.frm.city.value.trim() == ""){
			alert('도시코드을 입력하세요');
			document.frm.city.focus();
			retuen false;
		}
		document.frm.submit();
		}
</script>
<jsp:include page ="master/footer.jsp"/>
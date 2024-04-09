
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="master/header.jsp"/>

<section>
<div class="container">
	<p class="title">홈쇼필 회원 등록</p>
	<form action="/memberInsert" method="post" name="frm">
			<table width="600px">
				<tr>
					<td>참가번호</td>
					<td><input type = "text"  name="artist_id" id="artist_id" ></td>
				</tr>
				
				<tr>
					<td>참가자명</td>
					<td><input type="text" id="artist_name" name="artist_name"></td>
				</tr>
				
				<tr>
					<td>생년월일</td>
					<td><input type="text" id="artist_birth" name="artist_birth"></td>
				</tr>
				
				<tr>
					<td>성별</td>
					<td><input type="radio" id="artist_gender" name="artist_gender" value="M">남
					<input type="radio" id="artist_gender" name="artist_gender" value="F">여
					</td>
					
				</tr>
												
				<tr>
						<td>특기</td>
					
					<td><select id="talent" name="talent" value="특기선택">
						<option value="0">특기선택</option>
						
						<option value="1">보컬</option>
		
						<option value="2">댄스</option>
		
						<option value="3">랩</option>
					</select></td>						
				</tr>
				
				<tr>
				<td>도시코드</td>
				<td><input type="text" id="agency" name="agency"></td>
				</tr>
				
				<tr>
					<td colspan="2" align="center">
					<input type="submit" value="오디션등록" onclick="return checkForm()">
					<input type="reset" value="다시쓰기" onclick="return checkForm()">
				</tr>
				
			</table>	
	</form>
</div>
</section>


<script>
	function checkForm() {
		if(document.frm.artist_id.value.trim() == ""){
			alert('참가번호가 입력되지 않았습니다!');
			document.frm.artist_id.focus();
			retuen false;
		}
		if(document.frm.artist_name.value.trim() == ""){
			alert('참가자명가 입력되지 않았습니다!');
			document.frm.artist_name.focus();
			retuen false;
		}
		if(document.frm.artist_birth.value.trim() == ""){
			alert('생년월일이 입력되지 않았습니다!');
			document.frm.artist_birth.focus();
			retuen false;
		}
		if(document.frm.artist_gender.value.trim() == ""){
			alert('성별이 입력되지 않았습니다!');
			document.frm.artist_gender.focus();
			retuen false;
		}
		if(document.frm.talent.value.trim() == ""){
			alert('특기 입력되지 않았습니다!');
			document.frm.talent.focus();
			retuen false;
		}
		if(document.frm.agency.value.trim() == ""){
			alert('소속사 입력되지 않았습니다!');
			document.frm.agency.focus();
			retuen false;
		}
		document.frm.submit();
		}
</script>
<jsp:include page ="master/footer.jsp"/>

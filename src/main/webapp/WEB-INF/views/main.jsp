<%@ page session="false" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<body>

	<div class="loginGroup">
	
		<form name="member">
			<div class="loginTitle">
				<p>로그인</p><br/>${sessionID}는 세션 아이디
			</div>
			<br>${productName}
			<div>
				<p>
					<label class="readonly">아이디</label>
					<input type="text" name="userId" placeholder="아이디를 입력하세요" >
				</p>
				<p>
					<label class="readonly">비밀번호</label>
					<input type="password" name="userPw" placeholder="비밀번호를 입력하세요">
				</p>
			</div>
			<div class="loginButton">
				<p>
					<input type="button" value="로그인" class="submit" onClick="loginCheck();">
				</p>
			</div>
			
		</form>
	
	
		
	</div>
	
	<script>
		function loginCheck(){
			var form = document.member;
			if(form.userId.value == ""){
				alert("아이디를 입력하세요!");
				form.userId.focus();
				return;
			}
			if(form.userPw.value == ""){
				alert("비밀번호를 입력하세요!");
				form.userPw.focus();
				return;
			}
			form.method="post";
			form.action="loginCheck";
			form.submit();
		}
	</script>
	
</body>
</html>

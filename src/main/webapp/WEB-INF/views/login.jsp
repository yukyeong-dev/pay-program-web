<%@ page session="false" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<body>

<form name="login">
	<div class="loginGroup">
	
		<div>
			<li>
				<input type="button" value="로그인하러가기" class="submit" onClick="goLogin();">
			</li>
		</div>
		
	</div>

</form>
	
	<script>
		function goLogin(){
			var form = document.login;
			form.method="post";
			form.action="main";
			form.submit();
		}
	</script>
	
</body>
</html>

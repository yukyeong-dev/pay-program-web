<%@ page session="false" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<body>
	<form name="goHome">
		<input type="hidden" name="userId" value="${sessionID}">
		<input type="hidden" name="userPw" value="${sessionPW}">
	
	<div class="order_group">
		<div>[ 주문성공  ]</div>
		<br/>
		<br/>

		<p>${map}</p>
		<p>아이디들어옴: ${sessionID}</p>
		<p>비번들어옴: ${sessionPW}</p>
		<p>토탈포인트들어옴: ${map.totalPoint}</p>
		
	</div>
	<div>
		<p>
			<input type="button" value="홈으로  돌아가기" onClick="go();">
		</p>
	</div>
	
	</form>
	
	<script>
		function go(){
			alert("2222");
			var form = document.goHome;
			form.method="post";
			form.action="loginCheck";
			form.submit();
		}
	</script>
	
	
	
</body>

</html>

	
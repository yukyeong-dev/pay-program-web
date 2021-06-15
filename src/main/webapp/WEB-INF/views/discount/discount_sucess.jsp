<%@ page session="false" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<body>
	<form name="goHome">
		<input type="hidden" name="userId" value="${sessionID}">
		<input type="hidden" name="userPw" value="${sessionPW}">
	
	<div class="order_group">
		<div>[ 세일기간 설정 성공  ]</div>
		<br/>
		<br/>

		
		<p>아이디들어옴: ${sessionID}</p>
		<p>비번들어옴: ${sessionPW}</p>
		<p>비번들어옴: ${start}</p><p>비번들어옴: ${end}</p><p>비번들어옴: ${persent}</p>
		
	</div>
	<div>
		<p>
			<input type="button" value="홈으로  돌아가기" onClick="go();">
		</p>
	</div>
	<input type="hidden" name="start" value="${start}">
	<input type="hidden" name="end" value="${end}">
	<input type="hidden" name="persent" value="${persent}">
	<input type="hidden" name="productPrice" value="${productPrice}">
	<input type="hidden" name="productCode" value="${productCode}">
	<input type="hidden" name="productOldprice" value="${productOldprice}">
	
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

	
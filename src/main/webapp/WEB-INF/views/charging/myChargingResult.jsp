<%@ page session="false" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<body>
<form name="goHome">
<input type="hidden" name="userId" value="${userId}">
<input type="hidden" name="userPw" value="${userPw}">
	<div class="chargingGroup">
		<c:forEach items="${charging}" var="charg">
		<div>
			충전이 완료되었습니다.
		</div>
		<br/>
		<div>
			충전된 나의 포인트 : ${charg.totalPoint}
		</div>
		<br/>
		<div>
			<p>
				<input type="button" value="홈으로  돌아가기" onClick="go();">
			</p>
		</div>
		</c:forEach>
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

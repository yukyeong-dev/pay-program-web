<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java"  contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ko">
<head>
	<title>Home</title>
</head>

<body>
	<form name="cancel">
			
	<div class="order_group">
		<div>[ 주문실패  ]</div>
		<br/>
		<br/>
		<div>포인트가 부족합니다.
			<p>현재포인트 : ${totalPoint}</p>
			<p>구매금액 : ${sum}</p>
			<p>${result}원이 부족합니다.</p>
			
			<div>
				<input type="button" value="충전하러가기" class="submit" onClick="goCharging();">
			</div>
		</div>
	</div>
	</form>
	
	
	
	<script>
	function goCharging(){
		var form = document.cancel;
		form.method="post";
		form.action="Charging";
		form.submit();
	}
	</script>
</body>

</html>

	
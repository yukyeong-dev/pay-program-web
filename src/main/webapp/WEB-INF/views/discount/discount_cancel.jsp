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
		<div>[ 세일기간 설정 실패  ]</div>
		<br/>
		<br/>
		<div>시스쳄 오류로 정상처리되지 못하였습니다.<br/>
		<p>시스템 </p>
			
			<div>
				<input type="button" value="돌아가기" class="submit" onClick="();">
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

	
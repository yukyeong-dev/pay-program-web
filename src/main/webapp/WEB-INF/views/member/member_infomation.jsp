<%@ page session="false" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../header.html" %>


	<div>
	
	
	
		<p>아이디 들어옴 : ${userId}</p>
		<br/><br/>
		<li>
			<input type="button" value="나의 구매내역 보러가기" class="submit" onClick="memberMyInfoOrder();">
		</li>
		<br><br>
		<li>
			<input type="button" value="나의 선물내역 보러가기" class="submit" onClick="memberMyInfoGift();">
		</li>
	
	
	</div>


<script>

	function memberMyInfoOrder(){
		var form = document.product;
		form.method="post";
		form.action="memberMyInfoOrder";
		form.submit();
	}
	
	function memberMyInfoGift(){
		var form = document.product;
		form.method="post";
		form.action="memberMyInfoGift";
		form.submit();
	}

</script>




</body>
</html>
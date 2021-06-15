<%@ page session="false" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../header.html" %>


	
	<input type="hidden" name="userId" value="${userId}">
	<input type="hidden" name="userPw" value="${userPw}">
		
		<div class="chargingGroup">
			<c:forEach items="${charging}" var="charg">
				<div>
					나의 포인트 :${charg.totalPoint}
				</div>
				<br/>
				<div>
					+ <input type="text" name="chargingPoint" placeholder="   충전 할 포인트 입력">
				</div>
				<br/>
				<div>
					<p>
						<input type="button" class="submit" value="충전하기" onClick="chargingCheck();">
					</p>
				</div>
			</c:forEach>
		</div>
	
	</form>	
	
	<script>
		function chargingCheck(){
			var form = document.product;
			if(form.chargingPoint.value == ""){
				alert("충전 할 포인트를 입력하세요! ");
				form.chargingPoint.focus();
				return;
			}
			form.method="post";
			form.action="ChargingCheck";	// 충전하기를 눌렀을  때 컨트롤러로 넘어갈 거 입력하기 - 컴트롤러에 넘어가서 포인트 더해줘야됨 
			form.submit();
		}
	</script>
	
</body>
</html>

<%@ page session="false" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../header.html" %>

	<c:forEach items="${member}" var="mem">
	<div>[  나의 선물내역    ]</div>
	<br/>
		<div>
		
			<li>			
				<ul> 선물을 보내신 핸드폰 번호 : ${mem.phoneNumber}</ul>
				<ul> 나의 포인트 : ${mem.totalpoint}</ul>
				<ul> 선물한 상품 : ${mem.productName}</ul>
				<ul> 상품의 가격: ${mem.productPrice}</ul>
				<ul> 상품의 코드 : ${mem.productCode}</ul>
				<ul> 상품의 바코드 : ${mem.productBarcode}</ul>
				<ul> 선물한 갯수 : ${mem.amount}</ul>
				<ul> 지불한 금액 : ${mem.pointSum}</ul>
				<ul> 남은 포인트 : ${mem.pointRemain}</ul>
				<ul> 선물한 날짜 : ${mem.regdate}</ul>
			<br/>
			</li>
		
		
		</div>
	
	</c:forEach>
</form>




</body>
</html>
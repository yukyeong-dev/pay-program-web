<%@ page session="false" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="header.html" %>


	
	<div class="productPRB_group">
		<div>${sessionID} 님</div><br>
	
		<h1 class="P_title">
			[ 파리바게트 상품 리스트 ]
		</h1>
		
	<c:forEach items="${product}" var="po">
	<input type="hidden" value="${po.productPrice}" name="productPrice">
	<input type="hidden" value="${po.productCode}" name="productCode">
	<input type="hidden" value="${po.productConnect}" name="productConnect">
	<input type="hidden" value="${po.productOldprice}" name="productOldprice">
		<br/>
		<br/>
			<div>
<!-- 			<input type="button" name="세일기간 설정하러 가기" class="submit" onClick="sale();"> -->
			<button><a href="discount?productPrice=${po.productPrice}&productCode=${po.productCode}&productOldprice=${po.productOldprice}">세일기간 설정하러 가기</a></button>
			</div>
		<br/>
		<br/>
		
		<div class="PRB_list">	
			<div style="margin:20px;padding:20px;">
				<li style="list-style:none;">
					<ul>상품 이름 : ${po.productName}</ul>
					<ul>상품 설명 : ${po.productExplain}</ul>
					<ul>상품 가격 : ${po.productPrice} 원</ul>		
					<ul>상품 코드 : ${po.productCode}</ul>
					<ul>상품 바코드 : ${po.productBarcode}</ul>	
					<ul><a href="${po.productImgUrl}">상품 이미지 보기</a></ul>
				<!-- 	<br><input type="button" name="주문하기" class="submit" onClick="order();"> -->
					<br>
					<button><a href="productOrder?productName=${po.productName}&productExplain=${po.productExplain}&productPrice=${po.productPrice}&productCode=${po.productCode}&productBarcode=${po.productBarcode}&totalPoint=${totalPoint}&pw=${pw}&productConnect=${po.productConnect}">주문하기</a></button>
					&nbsp;&nbsp;&nbsp;
					<button><a href="productGift?productName=${po.productName}&productExplain=${po.productExplain}&productPrice=${po.productPrice}&productCode=${po.productCode}&productBarcode=${po.productBarcode}&totalPoint=${totalPoint}&pw=${pw}&productConnect=${po.productConnect}">선물하기</a></button>
				</li>
			</div>	
			</c:forEach>
			
			
			
		</div>
		
	</div>
	</form>
	
	<script>
		function sale(){
			var form = document.product;
			form.method="post";
			form.action="discount";
			form.submit();
		}
	</script>
	
	
</body>

</html>

	
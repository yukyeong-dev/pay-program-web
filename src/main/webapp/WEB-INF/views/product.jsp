<%@ page session="false" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="header.html" %>
	<input type="hidden" name="start" value="${start}">
	<input type="hidden" name="end" value="${end}">
	<input type="hidden" name="persent" value="${persent}">	
	<input type="hidden" name="productPrice" value="${productPrice}">
	<input type="hidden" name="productCode" value="${productCode}">
	<input type="hidden" name="productOldprice" value="${productOldprice}">
	
		
		<br>

			<div class="productButton"><br><br>
				<li>
					<input type="button" value="파리바게트 상품보기 - 바로가기" class="submit" onClick="productPRB();">
				</li>
				<br><br>
				<li>
					<input type="button" value="스타벅스 상품보기 - 바로가기" class="submit" onClick="productSTR();">
				</li>
				<br><br>
				<li>
					<input type="button" value="베스킨라빈스 상품보기 - 바로가기" class="submit" onClick="productBSK();">
				</li>
			</div>
		
	</form>
	
	
	<script>
	function goCharging(){
		var form = document.product;
		form.method="post";
		form.action="Charging";
		form.submit();
	}
	function productPRB(){
		var form = document.product;
		form.method="post";
		form.action="product_PRB";
		form.submit();
	}
	function productSTR(){
		var form = document.product;
		form.method="post";
		form.action="product_STR";
		form.submit();
	}
	function productBSK(){
		var form = document.product;
		form.method="post";
		form.action="product_BSK";
		form.submit();
	}
	function login(){
		var form = document.product;
		form.method="post";
		form.action="login";
		form.submit();
	}
	
	</script>
	
	
</body>
</html>

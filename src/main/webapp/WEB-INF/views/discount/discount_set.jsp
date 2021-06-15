<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java"  contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<body onload="init();">
	<form name="form">
			
	<div class="sale_group">
		<div>[ 세일 설정하기  ]</div>
		<p>상품가격 들어왔나 ? ${productPrice}</p>
		<p>상품코드 들어왔나 ? ${productCode}</p>
		<br/>
		<br/>
		<tr>
			<label>기간설정</label>
			<input type="text" name="start"> ~ <input type="text" name="end">
		</tr>
		<br/>
		<br/>
		<tr>
			<lable>할인율 입력 :</lable>
			<input type="text" name="persent">
		</tr>
		<br/>
		<br/>
		<br><button><a href="javascript:discountSet()">바로 적용하기</a></button>
		<input type="hidden" name="productPrice" value="${productPrice}">
		<input type="hidden" name="productCode" value="${productCode}">
		<input type="hidden" name="productOldprice" value="${productOldprice}">
	</div>

	</form>
	
	<script language="JavaScript">
	function discountSet(){
	
	/* 	alert(amount);
		alert(sum);
		alert(name);
		alert(price);
		alert(code);
		alert(barcode);  */
	/* 	
	 	form.productName.value=name;
		form.productPrice.value=price;
		form.productCode.value=code;
		form.productBarcode.value=barcode; */
		 
		form.method="post";
//		form.action="order?productName="+name+"&productPrice="+price+"&productCode="+code+"&productBarcode="+barcode+"&amount="+amount+"&sum="+sum; 
		form.action="discountSet";
		form.submit();
	}
	
	
	
	</script>

	
	
	
</body>

</html>

	
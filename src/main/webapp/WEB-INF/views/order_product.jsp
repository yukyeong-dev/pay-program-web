<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java"  contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ko">
<head>
	<title>Home</title>
</head>

<body onload="init();">
	<form name="form">
			
	<div class="order_group">
		<div>[ 주문  ]</div>
		<br/>
		
		<c:if test="${count > 0}">
			<p>
				할인률 적용하기 : <input type="text" name="apply" > %
			</p>
		</c:if>
		<br/>
		<tr>
			<td>주문한 상품: ${productName}</td>
		</tr><br/>
		<tr>
			<td>상품 가격: ${productPrice}</td>
			<td>dd : ${productP}</td>
		</tr><br/>
		<tr>
			<td>상품 코드: ${productCode}</td>
		</tr><br/>
		<tr>
			<td>상품 바코드: ${productBarcode}</td>
		</tr><br/>
		<tr>
			<td>토탈포인트: ${totalPoint}</td>
		</tr><br/>
		<br/>
		
		주문하실 수량을 선택해주세요 : <input type=hidden name="sell_price" value="${productPrice}">
		<input type="text" name="amount" value="1" size="3" onchange="change();">
		<input type="button" value=" + " onclick="add();"><input type="button" value=" - " onclick="del();"><br>
		<br/>
		금액 : <input type="text" name="sum" size="11" readonly>원
		<br/>
		받으시는 분의 주소를 입력하세요 : <input type="text" name="address" size="10">
		
		<br/>
		<br/>
<%-- 		<br><button><a href="order?productName=${po.productName}&productExplain=${po.productExplain}&productPrice=${po.productPrice}&productCode=${po.productCode}&productBarcode=${po.productBarcode}">주문하기</a></button> --%>
		<br><button><a href="javascript:order()">주문하기</a></button>
		
	</div>
	<input type="hidden" name="pw" value="${pw}">
 	<input type="hidden" name="productName" value="${productName}">
	<input type="hidden" name="productPrice" value="${productPrice}">
	<input type="hidden" name="productCode" value="${productCode}">
	<input type="hidden" name="productBarcode" value="${productBarcode}">
	<input type="hidden" name="totalPoint" value="${totalPoint}">
	<input type="hidden" name="productConnect" value="${productConnect}">
	
	
	
	</form>
	
	
	<script language="JavaScript">
	function order(){
	
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
		//form.action="order?productName="+name+"&productPrice="+price+"&productCode="+code+"&productBarcode="+barcode+"&amount="+amount+"&sum="+sum; 
		form.action="order";
		form.submit();
	}
	
	
	
	var sell_price;
	var amount;
	
	function init () {
		sell_price = document.form.sell_price.value;
		amount = document.form.amount.value;
		document.form.sum.value = sell_price;
		change();
	}
	
	function add () {
		hm = document.form.amount;
		sum = document.form.sum;
		hm.value ++ ;
	
		sum.value = parseInt(hm.value) * sell_price;
	}
	
	function del () {
		hm = document.form.amount;
		sum = document.form.sum;
			if (hm.value > 1) {
				hm.value -- ;
				sum.value = parseInt(hm.value) * sell_price;
			}
	}
	
	function change () {
		hm = document.form.amount;
		sum = document.form.sum;
	
			if (hm.value < 0) {
				hm.value = 0;
			}
		sum.value = parseInt(hm.value) * sell_price;
	}  

	</script>

	
	
	
</body>

</html>

	
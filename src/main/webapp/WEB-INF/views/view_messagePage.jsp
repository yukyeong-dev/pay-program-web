<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
	<body>
		<script type="text/javascript">
			var message='${msg}';
			var returnUrl = '${url}'; 
			alert(message);
			document.location.href=returnUrl;
		</script>
	</body>
</html>


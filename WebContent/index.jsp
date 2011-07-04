<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Captcha</title>
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/sexy-captcha/styles.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.7.2.custom.min.js"></script>
<script type="text/javascript" src="js/jquery.sexy-captcha-0.1.js"></script>
<script>
	$("document").ready(function() {
		$('.myCaptcha').sexyCaptcha('CaptchaServlet');

	});
</script>
</head>
<body>
	<form id="test-form" action="">
		<div class="myCaptcha"></div>
	</form>
</body>
</html>
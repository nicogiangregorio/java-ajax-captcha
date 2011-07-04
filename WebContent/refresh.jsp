<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="it.nicogiangregorio.utils.WebConstants"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<c:set var="ATTR_CAPTCHA_CODES"
	value="<%=request.getSession().getAttribute(WebConstants.ATTR_CAPTCHA_CODES) %>"></c:set>
<c:set var="ATTR_CAPTCHA_IMAGES"
	value="<%=request.getSession().getAttribute(WebConstants.ATTR_CAPTCHA_IMAGES) %>"></c:set>
<c:set var="ATTR_CAPTCHA_ANSWER"
	value="<%=request.getSession().getAttribute(WebConstants.ATTR_CAPTCHA_ANSWER) %>"></c:set>
<c:set var="ATTR_RIGHT_ANSWER"
	value="<%=request.getSession().getAttribute(WebConstants.ATTR_RIGHT_ANSWER) %>"></c:set>

<div class='captchaWrapper' id='captchaWrapper'>
	<c:forEach var="captchaImage" items="${ATTR_CAPTCHA_IMAGES }" varStatus="status">
		<a href='#' class='captchaRefresh'></a>
		<div id="draggable_${ATTR_CAPTCHA_CODES[captchaImage.idCaptcha]}"
			class='draggable'
			style='left: ${ ((status.count - 1) * 68) + 15 }px;background-position:${captchaImage.onTop} ${captchaImage.onLeft}'>
		</div>
	</c:forEach>

	<div class='targetWrapper'>
		<div class='target'
			style='background-position: ${ATTR_RIGHT_ANSWER.offTop } ${ATTR_RIGHT_ANSWER.offLeft };'>
		</div>
	</div>
	<input type='hidden' class='captchaAnswer' name='captcha' value='' />
</div>
</html>

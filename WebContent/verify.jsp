<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="it.nicogiangregorio.utils.WebConstants"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="VERIFY_RESULT"
	value="<%=request.getSession().getAttribute(WebConstants.VERIFY_RESULT) %>"></c:set>
	<c:set var="VERIFY_SUCCESS"
	value="success"></c:set>
<c:choose>
<c:when test="${VERIFY_RESULT eq VERIFY_SUCCESS }">
	{'status': 'success'}
</c:when>
<c:otherwise>
	{'status': 'error'}
</c:otherwise>	
</c:choose>

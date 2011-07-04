package it.nicogiangregorio.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ICaptchaAction {
	/**
	 * Strategy pattern applied: allows to select wich action to perform
	 * depending on request
	 * 
	 * @param request
	 *            : Http Request
	 * @param response
	 *            : Http Response
	 * @return : JSP where to forward the results
	 */
	public String process(HttpServletRequest request,
			HttpServletResponse response);
}

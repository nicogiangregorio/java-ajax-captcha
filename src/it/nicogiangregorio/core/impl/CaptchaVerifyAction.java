package it.nicogiangregorio.core.impl;

import it.nicogiangregorio.core.ICaptchaAction;
import it.nicogiangregorio.utils.WebConstants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CaptchaVerifyAction implements ICaptchaAction, WebConstants {

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		String hashCaptcha = request.getParameter(PARAM_CAPTCHA).substring(
				PARAM_CAPTCHA_SUBSTR.length());
		String captchaAnswer = (String) request.getSession().getAttribute(
				ATTR_CAPTCHA_ANSWER);
		String result;

		if (captchaAnswer.equals(hashCaptcha))
			result = VERIFY_RESULT_SUCCESS;
		else {
			request.getSession().setAttribute(ATTR_CAPTCHA_CODES, null);
			request.getSession().setAttribute(ATTR_CAPTCHA_ANSWER, null);
			result = VERIFY_RESULT_FAILED;
		}

		request.getSession().setAttribute(VERIFY_RESULT, result);
		return VERIFY_FORWARD_JSP;
	}
}

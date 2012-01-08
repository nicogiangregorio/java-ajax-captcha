package it.nicogiangregorio.core.impl;

import it.nicogiangregorio.core.ICaptchaAction;
import it.nicogiangregorio.utils.WebConstants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CaptchaVerifyAction implements ICaptchaAction {

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {

		String hashCaptcha = request.getParameter(WebConstants.PARAM_CAPTCHA)
				.substring(WebConstants.PARAM_CAPTCHA_SUBSTR.length());

		String captchaAnswer = (String) request.getSession().getAttribute(
				WebConstants.ATTR_CAPTCHA_ANSWER);

		String result = "";

		if (captchaAnswer.equals(hashCaptcha))
			result = WebConstants.VERIFY_RESULT_SUCCESS;
		else {
			request.getSession().setAttribute(WebConstants.ATTR_CAPTCHA_CODES,
					null);
			request.getSession().setAttribute(WebConstants.ATTR_CAPTCHA_ANSWER,
					null);
			result = WebConstants.VERIFY_RESULT_FAILED;
		}

		request.getSession().setAttribute(WebConstants.VERIFY_RESULT, result);
		return WebConstants.VERIFY_FORWARD_JSP;
	}
}

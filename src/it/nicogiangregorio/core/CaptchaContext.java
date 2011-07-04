package it.nicogiangregorio.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CaptchaContext {
	private ICaptchaAction captchaAction;

	public void setCaptchaAction(ICaptchaAction captchaAction) {
		this.captchaAction = captchaAction;
	}

	public String processCaptcha(HttpServletRequest request,
			HttpServletResponse response) {
		return captchaAction.process(request, response);
	}
}

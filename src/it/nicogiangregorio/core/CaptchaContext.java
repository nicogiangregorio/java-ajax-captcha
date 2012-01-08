package it.nicogiangregorio.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Manage strategy pattern with strategy selection in the setter and
 * processCaptcha() method to execute computing by given strategy
 * 
 * @author Nico Giangregorio
 * 
 */
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

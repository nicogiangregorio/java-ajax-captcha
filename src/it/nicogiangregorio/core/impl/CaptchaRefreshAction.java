package it.nicogiangregorio.core.impl;

import it.nicogiangregorio.core.ICaptchaAction;
import it.nicogiangregorio.servlets.CaptchaServlet;
import it.nicogiangregorio.utils.CaptchaBean;
import it.nicogiangregorio.utils.CaptchaGenerator;
import it.nicogiangregorio.utils.WebConstants;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CaptchaRefreshAction implements ICaptchaAction, WebConstants {

	private static CaptchaGenerator captchaGen = CaptchaGenerator.getIstance();

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, String> captchaCodes = new HashMap<String, String>();
		captchaCodes.put(starCaptcha.getIdCaptcha(),
				captchaGen.createCaptchaCodes());
		captchaCodes.put(heartCaptcha.getIdCaptcha(),
				captchaGen.createCaptchaCodes());
		captchaCodes.put(bwmCaptcha.getIdCaptcha(),
				captchaGen.createCaptchaCodes());
		captchaCodes.put(diamondCaptcha.getIdCaptcha(),
				captchaGen.createCaptchaCodes());

		int index = new Random().nextInt(captchaCodes.size());

		CaptchaBean rightAnswer = (CaptchaBean) CaptchaServlet.captchaImages
				.get(index);

		request.getSession().setAttribute(ATTR_CAPTCHA_IMAGES,
				CaptchaServlet.captchaImages);
		request.getSession().setAttribute(ATTR_CAPTCHA_ANSWER,
				captchaCodes.get(rightAnswer.getIdCaptcha()));
		request.getSession().setAttribute(ATTR_RIGHT_ANSWER, rightAnswer);
		request.getSession().setAttribute(ATTR_CAPTCHA_CODES, captchaCodes);
		return REFRESH_FORWARD_JSP;
	}
}

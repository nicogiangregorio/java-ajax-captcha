package it.nicogiangregorio.utils;

/**
 * 
 * Constants class
 * 
 * @author Nico Giangregorio
 * 
 */
public class WebConstants {
	public static final String NICK_DEMO = "nick_demo";
	public static final String PARAM_ACTION = "action";
	public static final String ACTION_VERIFY = "verify";
	public static final String ACTION_REFRESH = "refresh";
	public static final String ATTR_CAPTCHA_ANSWER = "captchaAnswer";
	public static final String ATTR_CAPTCHA_CODES = "captchaCodes";
	public static final String VERIFY_RESULT = "VerifyResult";
	public static final String PARAM_CAPTCHA = "captcha";
	public static final String PARAM_CAPTCHA_SUBSTR = "draggable_";
	public static final String VERIFY_RESULT_SUCCESS = "success";
	public static final String VERIFY_RESULT_FAILED = "failed";
	public static final String VERIFY_FORWARD_JSP = "/verify.jsp";
	public static final String REFRESH_FORWARD_JSP = "/refresh.jsp";
	public static final String ERROR_FORWARD_JSP = "/error.jsp";
	public static final String ATTR_CAPTCHA_IMAGES = "captchaImages";
	public static final String ATTR_RIGHT_ANSWER = "rightAnswer";

	// Enforce non-istantiability
	private WebConstants() {
	}
}

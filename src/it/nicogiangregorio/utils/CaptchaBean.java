package it.nicogiangregorio.utils;

public class CaptchaBean {

	String idCaptcha;
	String onTop;
	String onLeft;
	String offTop;
	String offLeft;

	public String getIdCaptcha() {
		return idCaptcha;
	}

	public String getOnTop() {
		return onTop;
	}

	public String getOnLeft() {
		return onLeft;
	}

	public String getOffTop() {
		return offTop;
	}

	public String getOffLeft() {
		return offLeft;
	}

	public CaptchaBean(String idCaptcha, String onTop, String onLeft,
			String offTop, String offLeft) {
		super();
		this.idCaptcha = idCaptcha;
		this.onTop = onTop;
		this.onLeft = onLeft;
		this.offTop = offTop;
		this.offLeft = offLeft;
	}
}

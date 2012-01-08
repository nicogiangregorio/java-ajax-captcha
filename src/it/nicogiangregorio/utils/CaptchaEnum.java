package it.nicogiangregorio.utils;

public enum CaptchaEnum {
	STAR("-120px", "-3px", "-120px", "-66px"), 
	HEART("0", "-3px", "0px","-66px"), 
	BWM("-56px", "-3px", "-56px", "-66px"), 
	DIAMOND("-185px","-3px", "-185px", "-66px");

	private final String onTop;
	private final String onLeft;
	private final String offTop;
	private final String offLeft;

	CaptchaEnum(String onTop, String onLeft, String offTop, String offLeft) {
		this.onTop = onTop;
		this.onLeft = onLeft;
		this.offTop = offTop;
		this.offLeft = offLeft;
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

}

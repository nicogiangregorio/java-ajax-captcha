package it.nicogiangregorio.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import sun.misc.BASE64Encoder;

public class CaptchaGenerator implements WebConstants {

	public static CaptchaGenerator CAPTCHA_GEN;

	public static CaptchaGenerator getIstance() {
		if (CAPTCHA_GEN == null)
			CAPTCHA_GEN = new CaptchaGenerator();
		return CAPTCHA_GEN;
	}

	public String createCaptchaCodes() {

		MessageDigest digest = null;
		SecureRandom rand = null;
		byte[] result = null;
		BASE64Encoder encoderToBase64 = null;
		String hashedResult = null;

		try {
			rand = new SecureRandom();

			encoderToBase64 = new BASE64Encoder();
			digest = MessageDigest.getInstance("SHA-256");
			digest.update(NICK_DEMO.getBytes());

			String randString = "" + rand.nextDouble();
			result = digest.digest(randString.getBytes());
			hashedResult = encoderToBase64.encode(result);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return hashedResult;
	}
}

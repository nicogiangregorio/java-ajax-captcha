package it.nicogiangregorio.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import sun.misc.BASE64Encoder;

public enum CaptchaGenerator {

	INSTANCE;

	public String createCaptchaCodes() {

		MessageDigest digest = null;
		byte[] result = {};
		String hashedResult = null;

		SecureRandom rand = new SecureRandom();
		BASE64Encoder encoderToBase64 = new BASE64Encoder();

		try {

			digest = MessageDigest.getInstance("SHA-256");
			digest.update(WebConstants.NICK_DEMO.getBytes());

		} catch (NoSuchAlgorithmException e) {
			throw new IllegalStateException(e);
		}

		String randString = "" + rand.nextDouble();
		result = digest.digest(randString.getBytes());
		hashedResult = encoderToBase64.encode(result);

		return hashedResult;
	}
}

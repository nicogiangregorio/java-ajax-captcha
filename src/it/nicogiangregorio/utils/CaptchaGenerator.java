package it.nicogiangregorio.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import sun.misc.BASE64Encoder;

/**
 * Helper class to generate random code to associate with captcha
 * 
 * @author Nico Giangregorio
 * 
 */
public class CaptchaGenerator {

	private CaptchaGenerator() {
	}

	public static String createCaptchaCodes() {

		MessageDigest digest = null;
		byte[] result = {};

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

		return encoderToBase64.encode(result);
	}
}

package com.shop.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;

public class encrypt {
	public static String encryptttth(String data, String key) throws Exception {
		Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		md5.update(key.getBytes(), 0, key.length());
		String keymd5 = new BigInteger(1, md5.digest()).toString(16).substring(0, 24);
		SecretKeySpec keyspec = new SecretKeySpec(keymd5.getBytes(), "DESede");
		cipher.init(Cipher.ENCRYPT_MODE, keyspec);
		byte[] stringBytes = data.getBytes();
		byte[] raw = cipher.doFinal(stringBytes);
		// String base64 = Base64.encode(raw);
		byte[] base64 = Base64.encodeBase64(raw);
		return new String(base64, "UTF-8");
	}

	public static String decryptttth(String data, String key) throws Exception {
		Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		md5.update(key.getBytes(), 0, key.length());
		String keymd5 = new BigInteger(1, md5.digest()).toString(16).substring(0, 24);
		SecretKeySpec keyspec = new SecretKeySpec(keymd5.getBytes(), "DESede");
		cipher.init(Cipher.DECRYPT_MODE, keyspec);
		// byte[] raw = Base64.decode(data);
		byte[] raw = Base64.decodeBase64(data);
		byte[] stringBytes = cipher.doFinal(raw);
		String result = new String(stringBytes);
		return result;
	}
	/**
     * MA HOA PASSWORD
     *
     * @param password
     * @return
     */
    public static String Password(String password) {
        String stringkey = "nhanhnt1@ttth" + "|" + password + "|" + "nhanhnt1@ttth";
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
            digest.update(stringkey.getBytes(), 0, stringkey.length());
            String hash = new BigInteger(1, digest.digest()).toString(16);
            return hash;
        } catch (NoSuchAlgorithmException e) {
        }
        return "";
    }  
	public static void main(String[] args) throws Exception {
		String test = "thanhnhan";
		String encode = encryptttth(test, "nhanhnt1@ttth");
		System.out.println(encode);
		String decode = decryptttth(encode, "nhanhnt1@ttth");
		System.out.println(decode);
	}
}

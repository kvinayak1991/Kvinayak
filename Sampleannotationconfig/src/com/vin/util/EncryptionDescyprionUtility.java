package com.vin.util;

import java.util.Date;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class EncryptionDescyprionUtility {
	private static final String key = "aesEncryptio12!@";
	private static final String initVector = "encryptionIn12!@";

	public static String encrypt(String value) {
		try {
			IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

			byte[] encrypted = cipher.doFinal(value.getBytes());
			return Base64.encodeBase64String(encrypted);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public static String decrypt(String encrypted) {
		try {
			IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
			byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));

			return new String(original);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}
	public static void main(String[] args) {
		String originalString = "Agent12!@";
		System.out.println("Original String to encrypt - " + originalString);
		String encryptedString = encrypt(originalString);
		System.out.println("Encrypted String - " + encryptedString);
		System.out.println("Encrypted String - " + new Date().toString());
		
		System.out.println("Encrypted String - " + Base64.encodeBase64String((encryptedString+new Date().toString()).getBytes()));
		String decryptedString = decrypt(encryptedString);
		System.out.println("After decryption - " + decryptedString);
		
		
	}
}


//JS CODE with npm install crypto-js --save in angular 6

//var message = "password";
//var key = "aesEncryptionKey"; //length=22
//var iv  = "encryptionIntVec"; //length=22

//key = CryptoJS.enc.Utf8.parse(key);iv = CryptoJS.enc.Utf8.parse(iv);
//var cipherData = CryptoJS.AES.encrypt(message, key, { iv: iv });
//console.log(cipherData.toString());
//var data = CryptoJS.AES.decrypt(cipherData, key, { iv: iv });
//console.log("Original String:::"+data.toString(CryptoJS.enc.Utf8));
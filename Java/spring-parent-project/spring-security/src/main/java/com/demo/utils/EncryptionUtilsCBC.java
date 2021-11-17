
package com.demo.utils;

import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.cxf.common.util.Base64Utility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EncryptionUtilsCBC {

	private static final String AES_CBC_PKCS5_PADDING = "AES/CBC/PKCS5Padding";

	private static final Logger LOGGER = LoggerFactory.getLogger(EncryptionUtilsCBC.class);

	public static final String ENCODING_CHARSET = "UTF-8";
	public static final String AES_ENCRYPTION_ALGORITHM = "AES";
	private boolean encryptionEnabled;

	public EncryptionUtilsCBC() {
		this.encryptionEnabled = true;
	}

	public EncryptionUtilsCBC(final boolean encryptionEnabled) {
		this.encryptionEnabled = encryptionEnabled;
	}

	private Cipher getEncryptionCipher(final String key, String randomIV) throws Exception {

		IvParameterSpec iv = new IvParameterSpec(randomIV.getBytes("UTF-8"));
		System.out.println("randomIV:" + randomIV.length());
		final Key aesKey = new SecretKeySpec(Base64.getDecoder().decode(key), AES_ENCRYPTION_ALGORITHM);
		final Cipher encryptionCipher = Cipher.getInstance(AES_CBC_PKCS5_PADDING);
		encryptionCipher.init(Cipher.ENCRYPT_MODE, aesKey, iv);
		return encryptionCipher;
	}

	private Cipher getDecryptionCipher(final String key, String randomIV) throws Exception {

		IvParameterSpec iv = new IvParameterSpec(randomIV.getBytes("UTF-8"));
		final SecretKey aesKey = new SecretKeySpec(Base64.getDecoder().decode(key), AES_ENCRYPTION_ALGORITHM);
		final Cipher decryptionCipher = Cipher.getInstance(AES_CBC_PKCS5_PADDING);
		decryptionCipher.init(Cipher.DECRYPT_MODE, aesKey, iv);
		return decryptionCipher;
	}

	public String decrypt(final String encryptedValue, final String key, String randomIV, final boolean urlSafe)
			throws Exception {
		if (this.encryptionEnabled) {
			try {
				byte[] decodedValue = Base64Utility.decode(encryptedValue, urlSafe);
				byte[] decryptedBytes = this.getDecryptionCipher(key, randomIV).doFinal(decodedValue);
				return new String(decryptedBytes, Constants.DEFAULT_ENCODING_CHARSET);
			} catch (Exception e) {
				//throw new CryptoException("Unable to decrypt data", e);
			}
		}
		return encryptedValue;
	}

	public String encrypt(final String plainValue, final String key, final String randomIV, final boolean urlEncode)
			throws Exception {
		if (this.encryptionEnabled) {
			try {
				final byte[] encryptedBytes = this.getEncryptionCipher(key, randomIV)
						.doFinal(plainValue.getBytes(Constants.DEFAULT_ENCODING_CHARSET));
				return new String(Base64Utility.encodeChunk(encryptedBytes, 0, encryptedBytes.length, urlEncode));
			} catch (Exception e) {
				//throw new CryptoException("Unable to encrypt  data", e);
			}
		}
		return plainValue;
	}

	public boolean encryptionEnabled() {
		return this.encryptionEnabled;
	}

	public void encryptionEnabled(final boolean isEncryptionEnabled) {
		this.encryptionEnabled = isEncryptionEnabled;
	}

	

}
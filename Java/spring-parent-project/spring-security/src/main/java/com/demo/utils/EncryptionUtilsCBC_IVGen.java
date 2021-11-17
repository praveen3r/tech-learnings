
package com.demo.utils;
import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EncryptionUtilsCBC_IVGen {

	//private static final String AES_ECB_PKCS5_PADDING = "AES/ECB/PKCS5Padding";
	private static final String AES_CBC_PKCS5_PADDING = "AES/CBC/PKCS5Padding";  

	private static final Logger LOGGER = LoggerFactory.getLogger(EncryptionUtils.class);

	public static final String ENCODING_CHARSET = "UTF-8";
	public static final String AES_ENCRYPTION_ALGORITHM = "AES";
	private boolean encryptionEnabled;
	public EncryptionUtilsCBC_IVGen() {
		this.encryptionEnabled = true;
	}

	public EncryptionUtilsCBC_IVGen(final boolean encryptionEnabled) {
		this.encryptionEnabled = encryptionEnabled;
	}
	
	private Cipher getEncryptCipher(final String key, String randomIV) throws Exception {
		
        IvParameterSpec iv = new IvParameterSpec(randomIV.getBytes("UTF-8"));
     //   System.out.println("randomIV:"+randomIV.length());
		final Key aesKey = new SecretKeySpec(Base64.getDecoder().decode(key), AES_ENCRYPTION_ALGORITHM);
		final Cipher encryptionCipher = Cipher.getInstance(AES_CBC_PKCS5_PADDING);
		encryptionCipher.init(Cipher.ENCRYPT_MODE, aesKey, iv );
		return encryptionCipher;
	}
	private Cipher getDecryptCipher(final String key, String randomIV) throws Exception {
	
		IvParameterSpec iv = new IvParameterSpec(randomIV.getBytes("UTF-8"));
		final SecretKey  aesKey = new SecretKeySpec(Base64.getDecoder().decode(key), AES_ENCRYPTION_ALGORITHM);
		final Cipher decryptionCipher = Cipher.getInstance(AES_CBC_PKCS5_PADDING);
		decryptionCipher.init(Cipher.DECRYPT_MODE, aesKey, iv);
		return decryptionCipher;
	}
	public String callDecrypt(final String encryptedValue, final String pwd,final boolean urlSafe) throws Exception {
		if (this.encryptionEnabled) {
			final byte[] decodedValue = Base64.getDecoder().decode(encryptedValue);
			int ivSize = 16;
	        byte[] iv = new byte[ivSize];
	        System.arraycopy(decodedValue, 0, iv, 0, iv.length);
	        int encryptedSize = decodedValue.length - ivSize;
	        byte[] encryptedBytes = new byte[encryptedSize];
	        System.arraycopy(decodedValue, ivSize, encryptedBytes, 0, encryptedSize);
	        
			String value1 = new String(decodedValue);
	        final byte[] unencryptedBytes = this.getDecryptCipher(pwd,value1.substring(0,16)).doFinal(encryptedBytes);
			return new String(unencryptedBytes, ENCODING_CHARSET);
		} else {
			return encryptedValue;
		}
	}
	public String callEncrypt(final String plainValue, final String pwd, final String randomKey,final boolean urlEncode) throws Exception {
		if (this.encryptionEnabled) {
			byte[] encryptedBytes = this.getEncryptCipher(pwd, randomKey).doFinal(plainValue.getBytes(ENCODING_CHARSET));
			byte[]  random=randomKey.getBytes();	
			byte[] total = new byte[random.length + encryptedBytes.length];
			System.arraycopy(random, 0, total, 0, random.length);
			System.arraycopy(encryptedBytes, 0, total, random.length, encryptedBytes.length);
			return new String(Base64.getEncoder().encode(total));
		} else {
			return plainValue;
		}
	}
	private Cipher getEncryptionCipher(final String key, String randomIV) throws Exception {
			
	        IvParameterSpec iv = new IvParameterSpec(Base64.getDecoder().decode(randomIV));
	        final Key aesKey = new SecretKeySpec(Base64.getDecoder().decode(key), AES_ENCRYPTION_ALGORITHM);
			final Cipher encryptionCipher = Cipher.getInstance(AES_CBC_PKCS5_PADDING);
			encryptionCipher.init(Cipher.ENCRYPT_MODE, aesKey, iv );
			return encryptionCipher;
		}
	private Cipher getDecryptionCipher(final String key, String randomIV) throws Exception {
		
        IvParameterSpec iv = new IvParameterSpec(Base64.getDecoder().decode(randomIV));
		final Key  aesKey = new SecretKeySpec(Base64.getDecoder().decode(key), AES_ENCRYPTION_ALGORITHM);
		final Cipher decryptionCipher = Cipher.getInstance(AES_CBC_PKCS5_PADDING);
		decryptionCipher.init(Cipher.DECRYPT_MODE, aesKey, iv);
		return decryptionCipher;
	}

	
	public String decrypt(final String encryptedValue, final String pwd,final boolean urlSafe) throws Exception {
		if (this.encryptionEnabled) {
			final byte[] decodedValue = Base64.getDecoder().decode(encryptedValue);
			final byte[] unencryptedBytes = this.getDecryptionCipher(pwd,pwd).doFinal(decodedValue);
			return new String(unencryptedBytes, ENCODING_CHARSET);
		} else {
			return encryptedValue;
		}
	}
	public String encrypt(final String plainValue, final String pwd, final String randomKey,final boolean urlEncode) throws Exception {
		if (this.encryptionEnabled) {
			byte[] encryptedBytes = this.getEncryptionCipher(pwd, randomKey).doFinal(plainValue.getBytes(ENCODING_CHARSET));
			return new String(Base64.getEncoder().encode(encryptedBytes));
		} else {
			return plainValue;
		}
	}

	public boolean encryptionEnabled() {
		return this.encryptionEnabled;
	}

	public void encryptionEnabled(final boolean isEncryptionEnabled) {
		this.encryptionEnabled = isEncryptionEnabled;
	}

	public String hmacDigest(final String data, final String secret, final String algo) {
		String digest = null;
		try {
			final SecretKeySpec key = new SecretKeySpec((secret).getBytes("UTF-8"), algo);
			final Mac mac = Mac.getInstance(algo);
			mac.init(key);

			final byte[] bytes = mac.doFinal(data.getBytes("UTF-8"));

			final StringBuffer hash = new StringBuffer();
			for (int i = 0; i < bytes.length; i++) {
				final String hex = Integer.toHexString(0xFF & bytes[i]);
				if (hex.length() == 1) {
					hash.append('0');
				}
				hash.append(hex);
			}
			digest = hash.toString();
		} catch (final Exception e) {
			LOGGER.error("Error computing hmac", e);
			throw new RuntimeException(e);
		}
		return digest;
	}

	public static String generateRandomKey() {

		KeyGenerator generator = null;
		SecretKey keyToBeWrapped = null;
		String key = null;
		try {

			generator = KeyGenerator.getInstance(AES_ENCRYPTION_ALGORITHM, "BC");
			generator.init(128);
			keyToBeWrapped = generator.generateKey();
			key = new String(Base64.getEncoder().encode(keyToBeWrapped.getEncoded()));
			if(key.length()>16)
				key=key.substring(0, 16);

		} catch (final Exception e) {
			LOGGER.error("Error while generating key", e);
		}

		return key;
	}
	public static String generateKey() {

		KeyGenerator generator = null;
		Key keyToBeWrapped = null;
		String key = null;
		try {

			generator = KeyGenerator.getInstance(AES_ENCRYPTION_ALGORITHM, "BC");
			generator.init(128);
			keyToBeWrapped = generator.generateKey();
			key = new String(Base64.getEncoder().encode(keyToBeWrapped.getEncoded()));
		} catch (final Exception e) {
			LOGGER.error("Error while generating key", e);
		}

		return key;
	}

}
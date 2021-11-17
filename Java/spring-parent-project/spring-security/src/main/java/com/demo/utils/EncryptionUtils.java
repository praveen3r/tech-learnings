package com.demo.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.util.Base64;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.lang3.StringUtils;
import org.apache.cxf.common.util.Base64Exception;
import org.apache.cxf.common.util.Base64Utility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 
 * @author e1001266
 *
 */
public class EncryptionUtils {

	private static final String AES_ECB_PKCS5_PADDING = "AES/ECB/PKCS5Padding";

	private static final Logger LOGGER = LoggerFactory.getLogger(EncryptionUtils.class);

	public static final String AES_ENCRYPTION_ALGORITHM = "AES";
	private static final String AES_CBS_PADDING = "AES/CBC/PKCS5Padding";
	private boolean encryptionEnabled;

	public EncryptionUtils() {
		this.encryptionEnabled = true;
	}

	public EncryptionUtils(boolean encryptionEnabled) {
		this.encryptionEnabled = encryptionEnabled;
		LOGGER.info("Encryption activated stauts [{}] ", encryptionEnabled);
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
			if (StringUtils.contains(key, '+')) {
				key = StringUtils.replaceChars(key, "+", "1");
			}
		} catch (final Exception e) {
			LOGGER.error("Error while generating key", e);
		}

		return key;
	}

	private Cipher getEncryptionCipher(final String key) throws GeneralSecurityException, Base64Exception {

		final Key aesKey = new SecretKeySpec(Base64Utility.decode(key), AES_ENCRYPTION_ALGORITHM);
		final Cipher encryptionCipher = Cipher.getInstance(AES_ECB_PKCS5_PADDING);
		encryptionCipher.init(Cipher.ENCRYPT_MODE, aesKey);
		return encryptionCipher;
	}

	private Cipher getDecryptionCipher(final String key) throws GeneralSecurityException, Base64Exception {
		final Key aesKey = new SecretKeySpec(Base64Utility.decode(key), AES_ENCRYPTION_ALGORITHM);
		final Cipher decryptionCipher = Cipher.getInstance(AES_ECB_PKCS5_PADDING);
		decryptionCipher.init(Cipher.DECRYPT_MODE, aesKey);
		return decryptionCipher;
	}

	public String decrypt(final String encryptedValue, final String password, final boolean urlSafe) {
		if (this.encryptionEnabled) {
			try {
				byte[] decodedValue = Base64Utility.decode(encryptedValue, urlSafe);
				byte[] unencryptedBytes = this.getDecryptionCipher(password).doFinal(decodedValue);
				return new String(unencryptedBytes, Constants.DEFAULT_ENCODING_CHARSET);
			} catch (Exception e) {
				//throw new CryptoException("Unable to decrypt data", e);
			}
		}
		return encryptedValue;
	}

	public String encrypt(final String plainValue, final String password, final boolean urlEncode) {
		if (this.encryptionEnabled) {
			try {
				final byte[] encryptedBytes = this.getEncryptionCipher(password)
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

	public String hmacDigest(String data, String secret, String algo) {
		String digest = null;
		try {
			SecretKeySpec key = new SecretKeySpec((secret).getBytes(Constants.DEFAULT_ENCODING_CHARSET), algo);
			Mac mac = Mac.getInstance(algo);
			mac.init(key);

			byte[] bytes = mac.doFinal(data.getBytes(Constants.DEFAULT_ENCODING_CHARSET));

			StringBuilder hash = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				String hex = Integer.toHexString(0xFF & bytes[i]);
				if (hex.length() == 1) {
					hash.append('0');
				}
				hash.append(hex);
			}
			digest = hash.toString();
		} catch (Exception e) {
			//throw new CryptoException("Error computing hmac", e);
		}
		return digest;
	}

	public static byte[] encryptDecryptAESCBC(final int mode, final byte[] key, final byte[] IV, final byte[] message)
			throws Exception {
		try {
			LOGGER.info("encryptDecryptAESCBC");
			fixKeyLength();
			// Security.addProvider(new BouncyCastleProvider());
			final Cipher cipher = Cipher.getInstance(AES_CBS_PADDING);
			final SecretKeySpec keySpec = new SecretKeySpec(key, AES_ENCRYPTION_ALGORITHM);
			final IvParameterSpec ivSpec = new IvParameterSpec(IV);
			cipher.init(mode, keySpec, ivSpec);
			return cipher.doFinal(message);
		} catch (final Exception e) {
			LOGGER.error("Error while generating key", e);
			throw e;
		}
	}

	public static void fixKeyLength() {
		String errorString = "Failed manually overriding key-length permissions.";
		int newMaxKeyLength;
		try {
			if ((newMaxKeyLength = Cipher.getMaxAllowedKeyLength("AES")) < 256) {
				Class c = Class.forName("javax.crypto.CryptoAllPermissionCollection");
				Constructor con = c.getDeclaredConstructor();
				con.setAccessible(true);
				Object allPermissionCollection = con.newInstance();
				Field f = c.getDeclaredField("all_allowed");
				f.setAccessible(true);
				f.setBoolean(allPermissionCollection, true);

				c = Class.forName("javax.crypto.CryptoPermissions");
				con = c.getDeclaredConstructor();
				con.setAccessible(true);
				Object allPermissions = con.newInstance();
				f = c.getDeclaredField("perms");
				f.setAccessible(true);
				((Map) f.get(allPermissions)).put("*", allPermissionCollection);

				c = Class.forName("javax.crypto.JceSecurityManager");
				f = c.getDeclaredField("defaultPolicy");
				f.setAccessible(true);
				Field mf = Field.class.getDeclaredField("modifiers");
				mf.setAccessible(true);
				mf.setInt(f, f.getModifiers() & ~Modifier.FINAL);
				f.set(null, allPermissions);

				newMaxKeyLength = Cipher.getMaxAllowedKeyLength("AES");
			}
		} catch (Exception e) {
			throw new RuntimeException(errorString, e);
		}
		if (newMaxKeyLength < 256)
			throw new RuntimeException(errorString); // hack failed
	}

}
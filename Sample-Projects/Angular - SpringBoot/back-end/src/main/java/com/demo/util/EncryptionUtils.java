package com.demo.util;

import java.security.Key;
import java.security.Security;
import java.util.Base64;
import java.util.stream.IntStream;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EncryptionUtils {

	private static final String AES_ECB_PKCS5_PADDING = "AES/ECB/PKCS5Padding";

	public static final String ENCODING_CHARSET = "UTF-8";
	public static final String AES_ENCRYPTION_ALGORITHM = "AES";
	private boolean encryptionEnabled;

	public EncryptionUtils() {
		this.encryptionEnabled = true;
	}

	public EncryptionUtils(final boolean encryptionEnabled) {
		this.encryptionEnabled = encryptionEnabled;
	}

	private Cipher getEncryptionCipher(final String key) throws Exception {

		final var aesKey = new SecretKeySpec(Base64.getDecoder().decode(key), AES_ENCRYPTION_ALGORITHM);
		final var encryptionCipher = Cipher.getInstance(AES_ECB_PKCS5_PADDING);
		encryptionCipher.init(Cipher.ENCRYPT_MODE, aesKey);
		return encryptionCipher;
	}

	private Cipher getDecryptionCipher(final String key) throws Exception {
		final var aesKey = new SecretKeySpec(Base64.getDecoder().decode(key), AES_ENCRYPTION_ALGORITHM);
		final var decryptionCipher = Cipher.getInstance(AES_ECB_PKCS5_PADDING);
		decryptionCipher.init(Cipher.DECRYPT_MODE, aesKey);
		return decryptionCipher;
	}
	
	public String decrypt(final String key, final String encryptedValue ) throws Exception {
		if (this.encryptionEnabled) {
			final var decodedValue = Base64.getDecoder().decode(encryptedValue);
			final var unencryptedBytes = this.getDecryptionCipher(key).doFinal(decodedValue);
			return new String(unencryptedBytes, ENCODING_CHARSET);
		} else {
			return encryptedValue;
		}
	}

	public String decrypt(final String encryptedValue, final String key, final boolean urlSafe) throws Exception {
		if (this.encryptionEnabled) {
			final var decodedValue = Base64.getDecoder().decode(encryptedValue);
			final var unencryptedBytes = this.getDecryptionCipher(key).doFinal(decodedValue);
			return new String(unencryptedBytes, ENCODING_CHARSET);
		} else {
			return encryptedValue;
		}
	}

	public String encrypt(final String plainValue, final String key) throws Exception {
		if (this.encryptionEnabled) {
			final var encryptedBytes = this.getEncryptionCipher(key).doFinal(plainValue.getBytes(ENCODING_CHARSET));
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
			final var key = new SecretKeySpec((secret).getBytes("UTF-8"), algo);
			final var mac = Mac.getInstance(algo);
			mac.init(key);

			final var bytes = mac.doFinal(data.getBytes("UTF-8"));

			final var hash = new StringBuffer();
			IntStream.range(0, bytes.length).forEach(index -> {
				final var hex = Integer.toHexString(0xFF & bytes[index]);
				if (hex.length() == 1) {
					hash.append('0');
				}
				hash.append(hex);
			});
			digest = hash.toString();
		} catch (final Exception e) {
			log.error("Error computing hmac", e);
			throw new RuntimeException(e);
		}
		return digest;
	}

	public static String generateKey() {

		KeyGenerator generator = null;
		Key keyToBeWrapped = null;
		String key = null;
		try {
			Security.addProvider(new BouncyCastleProvider());
			generator = KeyGenerator.getInstance(AES_ENCRYPTION_ALGORITHM, "BC");
			generator.init(128);
			keyToBeWrapped = generator.generateKey();
			key = new String(Base64.getEncoder().encode(keyToBeWrapped.getEncoded()));

		} catch (final Exception e) {
			log.error("Error while generating key", e);
		}

		return key;
	}

}
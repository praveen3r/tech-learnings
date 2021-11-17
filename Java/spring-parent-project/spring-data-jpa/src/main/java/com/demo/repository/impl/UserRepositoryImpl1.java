/*package com.demo.repository.impl;

public class UserRepositoryImpl1 {

	private static final String USER_SECURITY_SECRET_KEYS = "USER_SECURITY_SECRET_KEYS";

	@PersistenceContext(unitName = "defaultUnit")
	private EntityManager em;

	@Autowired
	CacheRepository cacheRepository;

	@Autowired
	UserRoleRepository userRoleRepo;

	@Value("${encrypt.padding.value}")
	private String padding;
	
	@Value("${encrypt.cipher.value}")
	private String encryption;
	
	@Override
	public String authenticate(final String username, final String pwd, final String bankId, final String applAccess) {
		String response = null;
		try {
			final String key = username + bankId;
			final String newPwd = pwd.replaceAll("AB1", "+");
			final String plainPwd = getPlainPwd(key, newPwd, true);// added for simulator
			final String hashedCredential = Utility.md5Encode(plainPwd);
		
			Integer result = 0;
			if(bankId!=null && (bankId.equals("BANKADMIN") || bankId.equals("BANKOPS"))){
				String bankIdNew;
				if(bankId.equals("BANKOPS"))
					bankIdNew = "BANKADMIN";
				else
					bankIdNew = bankId;
					
				final StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("userAuthenticationAdmin");
				spq.setParameter("p_corpId", bankIdNew).setParameter("p_username", username).setParameter("p_password", hashedCredential);
				spq.execute();
				result = (Integer) spq.getOutputParameterValue("p_message");
			}else{
				final StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("userAuthentication");
				spq.setParameter("p_corpId", bankId).setParameter("p_username", username).setParameter("p_password", hashedCredential).setParameter("p_appid", applAccess);
					
				spq.execute();
				result = (Integer) spq.getOutputParameterValue("p_message");
			}
			
			
			if (result == 0) {
				response = result.toString() + "|Login Accepted";
			} else {
				response = result.toString() + "|Authentication failure";
			}
		} catch (final Exception e) {
			response = "7|" + "A system Error occurred.Please contact bank";
		}
		return response;
	}
	
	@Cacheable("usersList")
	@SuppressWarnings("unchecked")
	public List<UserVO> getUsersList(){
		List<UserVO> userList = new ArrayList<>();
		Query query = em.createNativeQuery("SELECT usr.auto_id, usr.userid, usr.pwd, usr.username, usr.makerchecker, usr.user_active, ur.roledesc, usr.email_id "
				+ "FROM JCB_USER usr JOIN jcb_userrole ur ON ur.role = usr.makerchecker WHERE usr.bankid = 'BANKADMIN' AND usr.userid != 'SUPERUSER1'"
				+ " AND usr.userid != 'SUPERUSER2' ORDER BY usr.userid");
		List<Object[]> results = query.getResultList();
		
		if(results!=null && !results.isEmpty()){
			results.forEach(result -> {
				Object[] values = (Object[]) result;
				
				UserVO userVO = new UserVO();
				userVO.setId(values[0]!=null ? Long.parseLong(values[0].toString()) : 0);
				userVO.setUserId(values[1]!=null ? values[1].toString() : null);
				userVO.setPwd(values[2]!=null ? values[2].toString() : null);
				userVO.setUserName(values[3]!=null ? values[3].toString() : null);
				userVO.setRole(values[4]!=null ? values[4].toString() : null);
				userVO.setStatus(values[5]!=null ? new Integer(values[5].toString()) : null);
				userVO.setRoleDesc(values[6]!=null ? values[6].toString() : null);
				userVO.setEmailId(values[7]!=null ? values[7].toString() : null);
				
				userList.add(userVO);
			});
		}
		return userList;
	}
	
	@SuppressWarnings("unchecked")
	public List<UserVO> getBankUsers(String bankId){
		List<UserVO> userList = new ArrayList<>();
		StringBuilder queryStr = new StringBuilder("SELECT usr.auto_id, usr.bankid, usr.userid, usr.pwd, usr.username, usr.user_active, usr.act_start_date, "
				+ "usr.act_end_date, usr.app_access, usr.corpuser, usr.changepwdonfirstlogin FROM JCB_USER usr");
		
		if (!StringUtils.isEmpty(bankId)) {
			queryStr.append(" WHERE usr.bankid = '").append(bankId).append("' ");
		}
		
		queryStr.append("ORDER BY usr.userid");
		
		Query query = em.createNativeQuery(queryStr.toString());
		List<Object[]> results = query.getResultList();
		
		if(results!=null && !results.isEmpty()){
			AtomicLong serialNo = new AtomicLong();
			results.forEach(result -> {
				
				Object[] values = (Object[]) result;
				
				UserVO userVO = new UserVO();
				userVO.setSerialNo(serialNo.incrementAndGet());
				userVO.setId(values[0]!=null ? Long.parseLong(values[0].toString()) : 0);
				userVO.setBankId(values[1]!=null ? values[1].toString() : null);
				userVO.setUserId(values[2]!=null ? values[2].toString() : null);
				userVO.setPwd(values[3]!=null ? values[3].toString() : null);
				userVO.setUserName(values[4]!=null ? values[4].toString() : null);
				userVO.setStatus(values[5]!=null ? new Integer(values[5].toString()) : null);
				userVO.setStartDate(values[6]!=null? DateUtil.convertSqlDate(values[6].toString(),"yyyy-MM-dd HH:mm:ss.S") : null);
				userVO.setEndDate(values[7]!=null? DateUtil.convertSqlDate(values[7].toString(),"yyyy-MM-dd HH:mm:ss.S") : null);
				userVO.setApplAccess(values[8]!=null ? new Integer(values[8].toString()) : null);
				userVO.setCorpUser(values[9]!=null ? new Integer(values[9].toString()) : null);
				userVO.setChangePwdOnFirstLogin(values[10]!=null ? new Integer(values[10].toString()) : null);
				
				userList.add(userVO);
			});
		}
		return userList;
	}

	*//**
	 * this method will generate the secret key and stored into the cache memory
	 *
	 * @param Identifier
	 * @return String
	 *//*
	@Override
	public String generateSecretKey(final String userIdentifier) {
		final EncryptionUtils encryptionUtils = new EncryptionUtils(padding, encryption);
		final String key = encryptionUtils.generateKey();
		cacheRepository.storeIntoCache(USER_SECURITY_SECRET_KEYS, userIdentifier, key);
		return key;
	}
	
	*//**
	 * this method will return the plain Pwd, Pwd which will be decripted from
	 * the encription mode.
	 *
	 * @param userIdentifier
	 * @param encryptedPwd
	 * @return String
	 *//*
	@Override
	public String getEncryptedValue(final String userIdentifier, final String data) {
		final EncryptionUtils encryptionUtils = new EncryptionUtils(padding, encryption);
		final String key = getSecretKey(userIdentifier);
		String encryptedValue;
		try {
			encryptedValue = encryptionUtils.encrypt(data, key, false);
		} catch (final Exception e) {
			throw new ApiDataAccessException("1002", "Invalid Credentials");
		}
		return encryptedValue;
	}
	
	*//**
	 * this method will return the plain Pwd, Pwd which will be decripted from
	 * the encription mode.
	 *
	 * @param userIdentifier
	 * @param encryptedPwd
	 * @return String
	 *//*
	@Override
	public String getEncryptedValueWithKey(final String key, final String data) {
		final EncryptionUtils encryptionUtils = new EncryptionUtils(padding, encryption);
		String encryptedValue;
		try {
			encryptedValue = encryptionUtils.encrypt(data, key, false);
		} catch (final Exception e) {
			throw new ApiDataAccessException("1002", "Invalid Credentials");
		}
		return encryptedValue;
	}

	*//**
	 * this method will return the plain Pwd, Pwd which will be decripted from
	 * the encription mode.
	 *
	 * @param userIdentifier
	 * @param encryptedPwd
	 * @return String
	 *//*
	@Override
	public String getPlainPwd(final String userIdentifier, final String encryptedPwd, final boolean isClear) {
		final EncryptionUtils encryptionUtils = new EncryptionUtils(padding, encryption);
		String plainPwd;
		try {
			final String key = getSecretKey(userIdentifier);
			if(key != null){
				plainPwd = encryptionUtils.decrypt(encryptedPwd, key, true);
				if(isClear)
					clearSecretKey(userIdentifier);
			}
			else 
				throw new ApiDataAccessException("1002", "Invalid Credentials");
		} catch (final Exception e) {
			throw new ApiDataAccessException("1002", "Invalid Credentials");
		}
		return plainPwd;
	}

	*//**
	 * this method will return the plain Pwd, Pwd which will be decripted from
	 * the encription mode.
	 *
	 * @param userIdentifier
	 * @param encryptedPwd
	 * @return String
	 * @throws IllegalBlockSizeException
	 *//*
	public String getPlainText(final String encryptedValue, final String encryptedText) throws IllegalBlockSizeException {
		String plainText;
		final EncryptionUtils encryptionUtils = new EncryptionUtils(padding, encryption);
		try {
			plainText = encryptionUtils.decrypt(encryptedValue, encryptedText, true);
		} catch (final IllegalBlockSizeException ie) {
			throw ie;
		} catch (final Exception e) {
			throw new ApiDataAccessException("1002", "Invalid value");
		}
		return plainText;
	}

	*//**
	 * this method will return authorized context from the profile DB.
	 *
	 * @param channel<Channel>,
	 * @param userClass<String>,
	 * @return List<Context>.
	 *//*
	private String getSecretKey(final String userIdentifier) {
		return cacheRepository.getElementFromCache(USER_SECURITY_SECRET_KEYS, userIdentifier, String.class);
	}
	
	public void clearSecretKey(final String userIdentifier) {
		cacheRepository.clearCache(USER_SECURITY_SECRET_KEYS, userIdentifier);
	}
}
*/
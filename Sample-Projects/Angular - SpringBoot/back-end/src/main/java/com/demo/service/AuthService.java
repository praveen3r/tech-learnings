package com.demo.service;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;


@Service
public class AuthService {

	/*@Autowired
	AuthRepository authRepository;
	
	@Autowired
	AuthValidationService authValidationService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	SecurityService securityService;*/
	
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		UsernamePasswordAuthenticationToken authenticationNew = null;
		String userId = authentication.getPrincipal().toString();
		String encKeyWord = authentication.getCredentials().toString();
		encKeyWord = encKeyWord.replaceAll("AB1", "+");
		System.out.println(userId);
		System.out.println(encKeyWord);
		
		/*UsernamePasswordAuthenticationToken authenticationNew = null;
		String userId = authentication.getPrincipal() != null ? authentication.getPrincipal().toString().toUpperCase() : null;
		String encKeyWord = authentication.getCredentials()!= null ? authentication.getCredentials().toString() : null ;
		encKeyWord = encKeyWord.replaceAll("AB1", "+");
		CYCWebAuthenticationDetails webAuthenticationDetails = (CYCWebAuthenticationDetails)authentication.getDetails();
		String instId = webAuthenticationDetails.getInstId()!= null ? webAuthenticationDetails.getInstId().toUpperCase() : null;
		try {
			authValidationService.validateAuth(userId, encKeyWord, instId);
			StringBuilder key = new StringBuilder();
			key.append(userId).append(instId);
			String plainCredential = securityService.getPlainKeyWord(key.toString(), encKeyWord);
			securityService.clearSecretKey(userId);
			String hashedCredential = securityService.getHashedCredential(plainCredential);
			Integer responseCode = authRepository.authenticate(userId, hashedCredential, instId);
			if (responseCode == 1) {
				UserDto user = userService.getUserIdAndRole(userId, instId);
				webAuthenticationDetails.setInstNo(user.getInstitution().getId());
				StringBuilder sb = new StringBuilder();
				sb.append(Constants.ROLE_PREFIX).append(user.getRole().getId());
				authenticationNew = new UsernamePasswordAuthenticationToken(user.getId(), null, AuthorityUtils.createAuthorityList(sb.toString()));
			}
			else if (responseCode == 2)
				throw new UsernameNotFoundException(responseCode.toString());
			else if (responseCode == 3)
				throw new LockedException(responseCode.toString());
			else if (responseCode == 4)
				throw new AccountExpiredException(responseCode.toString());
			else if (responseCode == 8)
				throw new InternalAuthenticationServiceException(responseCode.toString());
			} catch (AuthenticationException ex) {
				throw new InternalAuthenticationServiceException(ex.getMessage());
			} catch (Exception e) {
				throw new InternalAuthenticationServiceException("8");
			}

		return authenticationNew;*/
		return null;
	}
	
	
}

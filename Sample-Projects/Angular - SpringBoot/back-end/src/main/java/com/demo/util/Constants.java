package com.demo.util;

public interface Constants {
	
	String SPRING_PROFILE_DEVELOPMENT = "dev";
	String SPRING_PROFILE_SIT = "sit";
	String SPRING_PROFILE_UAT = "uat";
	String SPRING_PROFILE_PROD = "prod";
    String SECURITY_SECRET_KEY = "SECURITY_SECRET_KEY";
    String SECURITY_TOKEN_KEY = "SECURITY_TOKEN_KEY";
    
    String SQL_REFERENCE_ERROR_CODE = "23503";
    String SQL_DUPLICATE_ERROR_CODE = "23505";
    Integer REFERENCE_ERROR_CODE = 1002;
    Integer DUPLICATE_ERROR_CODE = 1003;
    Integer EMAIL_ERROR_CODE = 1004;
    
    String NUMBER_PATTERN = "\\d+";
	String DECIMAL_PATTERN = "^[0-9.]+";
    String DATA_TYPE_NUMBER = "NUMBER";
	String DATA_TYPE_DECIMAL = "DECIMAL";
	String DATA_TYPE_DATE = "DATE";
	
	String SPACE = " ";
	
	String DATE_PATTERN = "dd/MM/yyyy";
	
    

}

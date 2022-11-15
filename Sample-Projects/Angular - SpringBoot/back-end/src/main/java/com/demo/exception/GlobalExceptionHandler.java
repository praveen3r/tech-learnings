package com.demo.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.demo.util.APIErrorTitle;
import com.demo.util.CommonUtil;
import com.demo.util.Profile;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private Environment environment;

	@Autowired
	private MessageSource messageSource;

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex,
			final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
		logError(ex, APIErrorTitle.SERVER_VALIDATION.getTitle(), "handleMethodArgumentNotValid");

		final List<ErrorDetail> errorDetailList = new ArrayList<>();
		ex.getBindingResult().getFieldErrors().forEach(ExceptionWrapper.throwException(fieldError -> {
			if (CommonUtil.isNotEmpty(fieldError.getDefaultMessage())) {
				var code = fieldError.getDefaultMessage();
				var message = messageSource.getMessage(code, fieldError.getArguments(),
							LocaleContextHolder.getLocale());
				var errorDetail = new ErrorDetail(code, message, fieldError.getField());
				errorDetailList.add(errorDetail);
			}

		}));
		var errorResponse = new ErrorResponse(APIErrorTitle.SERVER_VALIDATION.getTitle(),
				errorDetailList);
		return new ResponseEntity<>(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);
	}

	private void logError(final Exception ex, final String errorMsg, final String methodName) {
		var profile = Profile.DEV;
		var className = "GlobalExceptionHandler";
		if (environment.getActiveProfiles().length == 0) {
			log.error("{} in {}.{}() with cause = {}", errorMsg, className, methodName, ex.getCause(), ex.toString());
		} else {
			if (Arrays.stream(environment.getActiveProfiles())
					.anyMatch(env -> env.equalsIgnoreCase(profile.getProfile()))) {
				log.error("{} in {}.{}() with cause = {}", errorMsg, className, methodName, ex.getCause(),
						ex.toString());
			} else {
				if (CommonUtil.isNotEmpty(ex.getCause())) {
					log.error("Exception in {}.{}() with cause = {}", className, methodName, ex.getCause());
				} else {
					log.error("Exception in {}.{}() with cause = {}", className, methodName, ex.toString());
				}
			}
		}
	}
}

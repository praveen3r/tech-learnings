package com.demo.response;

import java.util.Optional;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 *
 * Advice that checks the response body and manipulate HttpStatus Note: As per
 * standards: POST, PUT and DELETE API must return void and just HttpStatus
 *
 * @author e5616358
 *
 **/
@ControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice<Object> {

	private Object responseBodyNotPresent(Object body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) {
		final HttpMethod requestMethod = request.getMethod();
		if (HttpMethod.POST.equals(requestMethod)) {
			response.setStatusCode(HttpStatus.CREATED);
		} else if (HttpMethod.PUT.equals(requestMethod)) {
			response.setStatusCode(HttpStatus.NO_CONTENT);
		} else if (HttpMethod.DELETE.equals(requestMethod)) {
			response.setStatusCode(HttpStatus.NO_CONTENT);
		}
		return body;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean supports(final MethodParameter arg0, final Class arg1) {
		return true;
	}

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) {
		if (!Optional.ofNullable(body).isPresent()) {
			body = responseBodyNotPresent(body, returnType, selectedContentType, selectedConverterType, request, response);
		}
		return body;
	}

}
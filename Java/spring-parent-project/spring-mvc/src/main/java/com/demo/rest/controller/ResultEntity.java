package com.demo.rest.controller;

import java.io.Serializable;
import java.util.List;

public class ResultEntity<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private String statusCode;
	private String statusMsg;
	private Boolean success;
	private T data;
	private List<T> entityList;

	public ResultEntity() {
	}

	public ResultEntity(final T data) {
		this.data = data;
	}

	public ResultEntity(final String statusCode, final String statusMsg, final Boolean success) {
		this.statusCode = statusCode;
		this.statusMsg = statusMsg;
		this.success = success;
	}

	public ResultEntity(final String statusCode, final String statusMsg, final Boolean success, final T data) {
		this.statusCode = statusCode;
		this.statusMsg = statusMsg;
		this.success = success;
		this.data = data;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(final String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusMsg() {
		return statusMsg;
	}

	public void setStatusMsg(final String statusMsg) {
		this.statusMsg = statusMsg;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(final Boolean success) {
		this.success = success;
	}

	public T getData() {
		return data;
	}

	public void setData(final T data) {
		this.data = data;
	}

	public List<T> getEntityList() {
		return entityList;
	}

	public void setEntityList(List<T> entityList) {
		this.entityList = entityList;
	}

	@Override
	public String toString() {
		return "ResponseEntity [statusCode=" + statusCode + ", statusMsg=" + statusMsg + ", success=" + success + ", data=" + data + "]";
	}
}
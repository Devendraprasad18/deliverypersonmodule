package com.grocerydeliveryapplication.deliveryperson.responseentities;

import java.io.Serializable;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public class ErrorInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	private HttpStatus status;
	private int statusCode;
	private String message;
	private String uri;

	public ErrorInfo(HttpStatus status, int statusCode, String message, String uri) {
		super();
		this.status = status;
		this.statusCode = statusCode;
		this.message = message;
		this.uri = uri;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}
}

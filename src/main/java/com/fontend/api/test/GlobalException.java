package com.fontend.api.test;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(value = { ResponseStatusException.class })
	protected ResponseEntity<Object> responseStatusException(ResponseStatusException ex, WebRequest request) {
		ApiError apiError = new ApiError();
		apiError.setMessage(ex.getReason());
		apiError.setStatus(ex.getStatusCode().value());
		return new ResponseEntity(apiError, ex.getStatusCode());
	}

	private static class ApiError {
		public ApiError() {
		}
		
		private String message;
		private int status;

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}
		
		
	}
	
}

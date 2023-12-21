package com.culinarycode.commonservice.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionMappers extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			final MethodArgumentNotValidException ex,
			@Nullable final HttpHeaders headers,
			@Nullable final HttpStatusCode status,
			@Nullable final WebRequest request ) {
		Map<String, String> validationErrors = new HashMap<>();

		ex.getBindingResult()
				.getFieldErrors()
				.forEach( fieldError -> validationErrors.put( fieldError.getField(), fieldError.getDefaultMessage() ) );

		final GlobalApiError userGlobalException =
				new GlobalApiError( "Some of your fields are wrong", validationErrors );

		return new ResponseEntity<>( userGlobalException, HttpStatus.BAD_REQUEST );

	}

	@ExceptionHandler(value = { GlobalApiRequestException.class })
	public ResponseEntity<Object> handleUserGlobalRequestException( final GlobalApiRequestException exception ) {
		GlobalApiError userGlobalException = new GlobalApiError( exception.getMessage(), null );

		return new ResponseEntity<>( userGlobalException, exception.getHttpStatus() );
	}

}

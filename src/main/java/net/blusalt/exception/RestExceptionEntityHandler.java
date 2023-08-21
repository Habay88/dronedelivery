package net.blusalt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionEntityHandler  extends ResponseEntityExceptionHandler{

	@ExceptionHandler(DroneServiceCustomException.class)
	public ResponseEntity<ErrorResponse>  handleProductServiceException(DroneServiceCustomException exception){
		return new ResponseEntity<>(new ErrorResponse().builder()
				.errorMessage(exception.getMessage())
				.errorCode(exception.getErrorCode())
				.build(),HttpStatus.NOT_FOUND);
		
	}
}

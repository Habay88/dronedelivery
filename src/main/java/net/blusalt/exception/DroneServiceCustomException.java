package net.blusalt.exception;

import lombok.Data;

@Data
public class DroneServiceCustomException extends RuntimeException {

	private String errorCode;

	public DroneServiceCustomException(String message, String errorCode) {
		super(message);
		this.errorCode = errorCode;
	}
	
}

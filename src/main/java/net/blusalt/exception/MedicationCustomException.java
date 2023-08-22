package net.blusalt.exception;

import lombok.Data;

@Data
public class MedicationCustomException extends RuntimeException {

	private String errorCode;

	public MedicationCustomException(String message, String errorCode) {
		super(message);
		this.errorCode = errorCode;
	}
}
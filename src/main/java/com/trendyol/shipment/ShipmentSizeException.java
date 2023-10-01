package com.trendyol.shipment;

public class ShipmentSizeException extends RuntimeException {

  private ExceptionType exceptionType;

  public ShipmentSizeException(ExceptionType exceptionType) {
	super(exceptionType.getMessage());
	this.exceptionType = exceptionType;
  }

  public ExceptionType getExceptionType() {
	return exceptionType;
  }
}

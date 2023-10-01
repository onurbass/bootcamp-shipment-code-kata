package com.trendyol.shipment;

public enum ExceptionType {
  BASKET_IS_EMPTY("Basket is empty"),
  BASKET_IS_TOO_BIG("Basket is too big");

  private String message;

  public String getMessage() {
	return message;
  }

  ExceptionType(String message) {
	this.message = message;
  }

}

package com.trendyol.shipment;

import java.util.List;


public class Basket {

  private List<Product> products;
  ShipmentSizeManager shipmentSizeManager=new ShipmentSizeManager();


  //
  public ShipmentSize getShipmentSize() {

	return shipmentSizeManager.calculateShipmentSize(products);
  }


  public List<Product> getProducts() {
	return products;
  }

  public void setProducts(List<Product> products) {
	this.products = products;
  }

}

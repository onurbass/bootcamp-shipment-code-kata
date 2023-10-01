package com.trendyol.shipment;

import java.util.List;

public interface ShipmentSizeCalculator {

  ShipmentSize calculateShipmentSize(List<Product> products);

}

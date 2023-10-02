package com.trendyol.shipment;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ShipmentSizeManager implements ShipmentSizeCalculator {
  private final int THRESHOLD = 3;
  private final int MAX_SIZE = 5;

  @Override
  public ShipmentSize calculateShipmentSize(List<Product> products) {
	validateBasket(products);

	Map<ShipmentSize, Long> shipmentSizeCountMap = shipmentSizeByCount(products);

	return findShipmentSize(shipmentSizeCountMap);
  }

  private void validateBasket(List<Product> products) {
	if (products.isEmpty()) {
	  throw new ShipmentSizeException(ExceptionType.BASKET_IS_EMPTY);
	}
	if (products.size() > MAX_SIZE) {
	  throw new ShipmentSizeException(ExceptionType.BASKET_IS_TOO_BIG);
	}
  }

  private Map<ShipmentSize, Long> shipmentSizeByCount(List<Product> products) {
	return products.stream()
				   .map(Product::getSize)
				   .collect(Collectors.groupingBy(x -> x,LinkedHashMap::new,Collectors.counting()));
  }

  private ShipmentSize findShipmentSize(Map<ShipmentSize, Long> shipmentSizeCountMap) {
	ShipmentSize currentSize = null;

	for (Map.Entry<ShipmentSize, Long> entry : shipmentSizeCountMap.entrySet()) {
	  ShipmentSize size = ShipmentSize.values()[entry.getKey().ordinal()];
	  long count = entry.getValue();

	  if (size != ShipmentSize.X_LARGE && count >= THRESHOLD) {
		return ShipmentSize.values()[size.ordinal() + 1];
	  } else if (size == ShipmentSize.X_LARGE && count >= THRESHOLD) {
		return ShipmentSize.X_LARGE;
	  } else if (count >= 1) {
		currentSize = size;
	  }
	}

	return currentSize;
  }

}


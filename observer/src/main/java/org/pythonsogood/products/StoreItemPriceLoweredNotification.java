package org.pythonsogood.products;

import org.pythonsogood.enums.StoreNotificationType;

public class StoreItemPriceLoweredNotification extends AbstractStoreNotification {
	public StoreItemPriceLoweredNotification(StoreItem item) {
		super(StoreNotificationType.LowerPrice, "Price became lower!", String.format("%s is cheaper, now it costs: $%s", item.getTitle(), item.getPriceDollars()));
	}
}

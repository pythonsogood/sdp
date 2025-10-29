package org.pythonsogood.products;

import org.pythonsogood.enums.StoreNotificationType;

public class StoreItemPriceUpdateNotification extends AbstractStoreNotification {
	public StoreItemPriceUpdateNotification(StoreItem item) {
		super(StoreNotificationType.ItemPriceUpdate, "Price update!", String.format("%s now costs: $%s", item.getTitle(), item.getPriceDollars()));
	}
}

package org.pythonsogood.products.notification;

import org.pythonsogood.enums.StoreNotificationType;
import org.pythonsogood.products.store.StoreItem;

public class StoreItemPriceUpdateNotification extends AbstractStoreNotification {
	public StoreItemPriceUpdateNotification(StoreItem item) {
		super(StoreNotificationType.ItemPriceUpdate, "Price update!", String.format("%s now costs: $%s", item.getTitle(), item.getPriceDollars()));
	}
}

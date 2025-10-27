package org.pythonsogood.products;

import org.pythonsogood.enums.StoreNotificationType;

public class StoreNewItemNotification extends AbstractStoreNotification {
	public StoreNewItemNotification(StoreItem item) {
		super(StoreNotificationType.NewItem, String.format("New Item! %s", item.getTitle()), item.getDescription());
	}
}

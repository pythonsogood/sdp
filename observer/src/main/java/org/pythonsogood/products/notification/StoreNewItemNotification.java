package org.pythonsogood.products.notification;

import org.pythonsogood.enums.StoreNotificationType;
import org.pythonsogood.products.store.StoreItem;

public class StoreNewItemNotification extends AbstractStoreNotification {
	public StoreNewItemNotification(StoreItem item) {
		super(StoreNotificationType.NewItem, String.format("New Item! %s", item.getTitle()), item.getDescription());
	}
}

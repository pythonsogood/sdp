package org.pythonsogood.products.notification;

import org.pythonsogood.enums.StoreNotificationType;
import org.pythonsogood.products.store.StoreItem;

public class StoreRemoveItemNotification extends AbstractStoreNotification {
	public StoreRemoveItemNotification(StoreItem item) {
		super(StoreNotificationType.NewItem, String.format("Item is no longer available! %s", item.getTitle()));
	}
}

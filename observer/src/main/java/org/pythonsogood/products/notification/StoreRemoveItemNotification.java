package org.pythonsogood.products;

import org.pythonsogood.enums.StoreNotificationType;

public class StoreRemoveItemNotification extends AbstractStoreNotification {
	public StoreRemoveItemNotification(StoreItem item) {
		super(StoreNotificationType.NewItem, String.format("Item is no longer available! %s", item.getTitle()));
	}
}

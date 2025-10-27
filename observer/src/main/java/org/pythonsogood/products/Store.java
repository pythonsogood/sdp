package org.pythonsogood.products;

import org.pythonsogood.interfaces.StoreNotification;

public class Store extends AbstractPublisher<StoreNotification> {
	public Store() {}

	public StoreItem addNewItem(String title, String description, boolean silent) {
		StoreItem item = new StoreItem(title, description);

		if (!silent) {
			StoreNewItemNotification notification = new StoreNewItemNotification(item);
			this.notifySubscribers(notification);
		}

		return item;
	}

	public StoreItem addNewItem(String title, String description) {
		return this.addNewItem(title, description, false);
	}
}

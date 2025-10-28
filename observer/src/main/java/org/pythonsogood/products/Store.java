package org.pythonsogood.products;

import org.pythonsogood.interfaces.StoreNotification;

public class Store extends AbstractPublisher<StoreNotification> {
	public Store() {}

	public StoreItem addNewItem(String title, String description, float price, boolean silent) {
		StoreItem item = new StoreItem(title, description, price);

		if (!silent) {
			StoreNewItemNotification notification = new StoreNewItemNotification(item);
			this.notifySubscribers(notification);
		}

		return item;
	}

	public StoreItem addNewItem(String title, String description, float price) {
		return this.addNewItem(title, description, price, false);
	}

	public void setItemPriceDollars(StoreItem item, float priceDollars) {
		float oldItemPriceDollars = item.getPriceDollars();
		item.setPriceDollars(priceDollars);

		if (oldItemPriceDollars > priceDollars) {
			StoreItemPriceLoweredNotification notification = new StoreItemPriceLoweredNotification(item);
			this.notifySubscribers(notification);
		}
	}
}

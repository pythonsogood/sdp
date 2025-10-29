package org.pythonsogood.products.store;

import java.util.ArrayList;
import java.util.List;

import org.pythonsogood.interfaces.StoreNotification;
import org.pythonsogood.products.notification.StoreItemPriceUpdateNotification;
import org.pythonsogood.products.notification.StoreNewItemNotification;
import org.pythonsogood.products.notification.StoreRemoveItemNotification;

public class Store extends AbstractPublisher<StoreNotification> {
	private List<StoreItem> items = new ArrayList<>();

	public Store() {}

	public List<StoreItem> getItems() {
		return this.items;
	}

	public StoreItem addNewItem(String title, String description, float priceDollars) {
		StoreItem item = new StoreItem(title, description, priceDollars);
		this.items.add(item);

		StoreNotification notification = new StoreNewItemNotification(item);
		this.notifySubscribers(notification);

		return item;
	}

	public void setItemPriceDollars(StoreItem item, float priceDollars) {
		if (!this.items.contains(item)) {
			throw new RuntimeException(String.format("Item %s does not exist in the store!", item.getTitle()));
		}

		item.setPriceDollars(priceDollars);

		StoreNotification notification = new StoreItemPriceUpdateNotification(item);
		this.notifySubscribers(notification);
	}

	public boolean removeItem(StoreItem item) {
		if (!this.items.contains(item)) {
			return false;
		}

		this.items.remove(item);

		StoreNotification notification = new StoreRemoveItemNotification(item);
		this.notifySubscribers(notification);

		return true;
	}
}

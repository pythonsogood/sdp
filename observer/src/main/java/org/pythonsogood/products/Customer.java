package org.pythonsogood.products;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.pythonsogood.enums.StoreNotificationType;
import org.pythonsogood.interfaces.StoreNotification;

public class Customer {
	private UUID uuid = UUID.randomUUID();

	private Store store;
	private StoreSubscriber subscriber = new StoreSubscriber(this);

	private Set<StoreNotificationType> notificationTypesFilters;

	public Customer(Store store) {
		this.store = store;
	}

	public Customer(UUID uuid, Store store) {
		this.uuid = uuid;
		this.store = store;
	}

	public UUID getUuid() {
		return this.uuid;
	}

	public void subscribeStoreNotifications() {
		this.store.subscribe(this.subscriber);
	}

	public void unsubscribeStoreNotifications() {
		this.store.unsubscribe(this.subscriber);
	}

	public void setStoreNotificationFilter(List<StoreNotificationType> notificationTypes) {
		this.notificationTypesFilters = notificationTypes.stream().collect(Collectors.toSet());
	}

	public void clearStoreNotificationFilter() {
		this.notificationTypesFilters = null;
	}

	public void onStoreNotification(StoreNotification notification) {
		if (this.notificationTypesFilters != null && !this.notificationTypesFilters.contains(notification.getType())) {
			return;
		}

		System.out.println(String.format("[%s] %s\n\t%s", this.hashCode(), notification.getTitle(), notification.getDescription()));
	}

	@Override
	public int hashCode() {
		return this.uuid.hashCode();
	}
}

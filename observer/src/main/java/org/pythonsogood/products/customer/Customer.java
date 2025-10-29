package org.pythonsogood.products.customer;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.pythonsogood.enums.StoreNotificationType;
import org.pythonsogood.interfaces.Publisher;
import org.pythonsogood.interfaces.StoreNotification;

public class Customer {
	private String name;
	private UUID uuid = UUID.randomUUID();

	private StoreSubscriber subscriber = new StoreSubscriber(this);

	private Set<StoreNotificationType> notificationTypesFilters;

	public Customer(String name) {
		this.name = name;
	}

	public Customer(String name, UUID uuid) {
		this.name = name;
		this.uuid = uuid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UUID getUuid() {
		return this.uuid;
	}

	public void subscribeStoreNotifications(Publisher<StoreNotification> store) {
		store.subscribe(this.subscriber);
	}

	public void unsubscribeStoreNotifications(Publisher<StoreNotification> store) {
		store.unsubscribe(this.subscriber);
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

		System.out.println(String.format("[%s]\t%s", this.name, notification.toString()));
	}

	@Override
	public int hashCode() {
		return this.uuid.hashCode();
	}
}

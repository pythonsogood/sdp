package org.pythonsogood.products.notification;

import org.pythonsogood.enums.StoreNotificationType;
import org.pythonsogood.interfaces.StoreNotification;

public class AbstractStoreNotification implements StoreNotification {
	private StoreNotificationType type;
	private String title;
	private String description;

	public AbstractStoreNotification(StoreNotificationType type, String title, String description) {
		this.type = type;
		this.title = title;
		this.description = description;
	}

	public AbstractStoreNotification(StoreNotificationType type, String title) {
		this.type = type;
		this.title = title;
	}

	@Override
	public StoreNotificationType getType() {
		return this.type;
	}

	@Override
	public String getTitle() {
		return this.title;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public String toString() {
		if (this.description == null) {
			return this.getTitle();
		}

		return String.format("%s\n\t\t%s", this.getTitle(), this.getDescription());
	}
}

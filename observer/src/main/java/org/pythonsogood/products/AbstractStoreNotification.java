package org.pythonsogood.products;

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
}

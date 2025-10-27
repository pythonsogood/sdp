package org.pythonsogood.interfaces;

import org.pythonsogood.enums.StoreNotificationType;

public interface StoreNotification {
	StoreNotificationType getType();
	String getTitle();
	String getDescription();
}

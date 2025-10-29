package org.pythonsogood.products.customer;

import org.pythonsogood.interfaces.StoreNotification;
import org.pythonsogood.interfaces.Subscriber;

public class StoreSubscriber implements Subscriber<StoreNotification> {
	private Customer customer;

	public StoreSubscriber(Customer customer) {
		this.customer = customer;
	}

	@Override
	public void update(StoreNotification context) {
		this.customer.onStoreNotification(context);
	}

	@Override
	public int hashCode() {
		return this.customer.hashCode();
	}
}

package org.pythonsogood.products;

import java.util.HashSet;
import java.util.Set;

import org.pythonsogood.interfaces.Subscriber;

public abstract class AbstractPublisher<T> {
	private Set<Subscriber<T>> subscribers = new HashSet<>();

	public void subscribe(Subscriber<T> subscriber) {
		this.subscribers.add(subscriber);
	}

	public void unsubscribe(Subscriber<T> subscriber) {
		this.subscribers.remove(subscriber);
	}

	public boolean isSubscribed(Subscriber<T> subscriber) {
		return this.subscribers.contains(subscriber);
	}

	public void notifySubscribers(T context) {
		for (Subscriber<T> subscriber : this.subscribers) {
			subscriber.update(context);
		}
	}
}

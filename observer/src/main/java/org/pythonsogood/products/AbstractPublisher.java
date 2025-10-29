package org.pythonsogood.products;

import java.util.HashSet;
import java.util.Set;

import org.pythonsogood.interfaces.Publisher;
import org.pythonsogood.interfaces.Subscriber;

public abstract class AbstractPublisher<T> implements Publisher<T> {
	private Set<Subscriber<T>> subscribers = new HashSet<>();

	@Override
	public void subscribe(Subscriber<T> subscriber) {
		this.subscribers.add(subscriber);
	}

	@Override
	public void unsubscribe(Subscriber<T> subscriber) {
		this.subscribers.remove(subscriber);
	}

	@Override
	public boolean isSubscribed(Subscriber<T> subscriber) {
		return this.subscribers.contains(subscriber);
	}

	@Override
	public void notifySubscribers(T context) {
		for (Subscriber<T> subscriber : this.subscribers) {
			subscriber.update(context);
		}
	}
}

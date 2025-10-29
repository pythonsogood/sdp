package org.pythonsogood.interfaces;

public interface Publisher<T> {
	void subscribe(Subscriber<T> subscriber);
	void unsubscribe(Subscriber<T> subscriber);
	boolean isSubscribed(Subscriber<T> subscriber);
	void notifySubscribers(T context);
}

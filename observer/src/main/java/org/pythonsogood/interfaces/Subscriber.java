package org.pythonsogood.interfaces;

public interface Subscriber<T> {
	void update(T context);

	int hashCode();
}

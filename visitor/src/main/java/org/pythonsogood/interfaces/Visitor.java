package org.pythonsogood.interfaces;

public interface Visitor<T extends Element<T, K>, K> {
	K visit(T element);
}

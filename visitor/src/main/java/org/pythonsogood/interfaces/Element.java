package org.pythonsogood.interfaces;

public interface Element<T extends Element<T, K>, K> {
	K accept(Visitor<T, K> visitor);
}

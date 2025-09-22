package org.pythonsogood.interfaces;

public interface Value {
	public abstract double getValue();
	public abstract void setValue(double value);

	@Override
	public abstract String toString();
}

package org.pythonsogood.interfaces;

public interface Value {
	public abstract double getValue();
	public abstract void setValue(double value);

	public abstract int getExponent();
	public abstract void setExponent(int exponent);

	@Override
	public abstract String toString();
}

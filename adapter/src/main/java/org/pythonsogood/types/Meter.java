package org.pythonsogood.types;

import org.pythonsogood.interfaces.MetricValue;

public class Meter implements MetricValue {
	private double value;
	private int exponent = 1;

	public Meter(double value) {
		this.value = value;
	}

	public Meter(double value, int exponent) {
		this.value = value;
		this.exponent = exponent;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public int getExponent() {
		return exponent;
	}

	public void setExponent(int exponent) {
		this.exponent = exponent;
	}

	@Override
	public String toString() {
		if (this.exponent != 1) {
			return String.format("%s m^%s", this.value, this.exponent);
		}

		return String.format("%s m", this.value);
	}
}

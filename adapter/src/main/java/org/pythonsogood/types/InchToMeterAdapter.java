package org.pythonsogood.types;

import org.pythonsogood.interfaces.MetricValue;

public class InchToMeterAdapter implements MetricValue {
	private final double INCHES_IN_METER = 39.37;

	private Inch inches;

	public InchToMeterAdapter(Inch inches) {
		this.inches = inches;
	}

	public double getValue() {
		return this.inches.getValue() / INCHES_IN_METER;
	}

	public void setValue(double value) {
		this.inches.setValue(value * INCHES_IN_METER);
	}

	public double getInches() {
		return this.inches.getValue();
	}

	public void setInches(double inches) {
		this.inches.setValue(inches);
	}

	public int getExponent() {
		return this.inches.getExponent();
	}

	public void setExponent(int exponent) {
		this.inches.setExponent(exponent);
	}

	@Override
	public String toString() {
		if (this.getExponent() != 1) {
			return String.format("%sm (%s''^%s)", this.getValue(), this.getExponent(), this.getInches(), this.getExponent());
		}

		return String.format("%sm (%s'')", this.getValue(), this.getInches());
	}
}

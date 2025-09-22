package org.pythonsogood.types;

import org.pythonsogood.interfaces.MetricValue;
import org.pythonsogood.interfaces.Value;

public class MeterToInchAdapter implements Value {
	private final double INCHES_IN_METER = 39.37;

	private MetricValue meters;

	public MeterToInchAdapter(MetricValue meters) {
		this.meters = meters;
	}

	public double getValue() {
		return this.meters.getValue() * INCHES_IN_METER;
	}

	public void setValue(double value) {
		this.meters.setValue(value / INCHES_IN_METER);
	}

	public double getMeters() {
		return this.meters.getValue();
	}

	public void setMeters(double inches) {
		this.meters.setValue(inches);
	}

	public int getExponent() {
		return this.meters.getExponent();
	}

	public void setExponent(int exponent) {
		this.meters.setExponent(exponent);
	}

	@Override
	public String toString() {
		if (this.getExponent() != 1) {
			return String.format("%s ''^%s (%s m^%s)", this.getValue(), this.getExponent(), this.getMeters(), this.getExponent());
		}

		return String.format("%s '' (%s m)", this.getValue(), this.getMeters());
	}
}

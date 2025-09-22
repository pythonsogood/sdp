package org.pythonsogood.shapes;

import org.pythonsogood.interfaces.MetricValue;
import org.pythonsogood.interfaces.Shape;
import org.pythonsogood.types.Meter;

public class MetricSphere implements Shape {
	private MetricValue radius;

	public MetricSphere(MetricValue radius) {
		this.radius = radius;
	}

	public MetricValue getVolume() {
		return new Meter(4/3 * Math.PI * Math.pow(this.radius.getValue(), 3), 3);
	}

	public MetricValue getArea() {
		return new Meter(4 * Math.PI * Math.pow(this.radius.getValue(), 2), 2);
	}
}

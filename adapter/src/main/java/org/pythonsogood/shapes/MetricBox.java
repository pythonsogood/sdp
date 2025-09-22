package org.pythonsogood.shapes;

import org.pythonsogood.interfaces.MetricValue;
import org.pythonsogood.interfaces.Shape;
import org.pythonsogood.types.Meter;

public class MetricBox implements Shape {
	private MetricValue length;
	private MetricValue width;
	private MetricValue height;

	public MetricBox(MetricValue length, MetricValue width, MetricValue height) {
		this.length = length;
		this.width = width;
		this.height = height;
	}

	public MetricValue getVolume() {
		return new Meter(this.length.getValue() * this.width.getValue() * this.height.getValue(), 3);
	}

	public MetricValue getArea() {
		return new Meter(2 * (this.length.getValue() * this.width.getValue() + this.width.getValue() * this.height.getValue() + this.height.getValue() * this.length.getValue()), 2);
	}
}

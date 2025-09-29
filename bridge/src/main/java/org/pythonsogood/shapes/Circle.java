package org.pythonsogood.shapes;

import org.pythonsogood.interfaces.Render;
import org.pythonsogood.interfaces.Shape;

public class Circle extends Shape {
	private int radius;

	public Circle(int x, int y, int radius, Render render) {
		super(x, y, render);
		this.radius = radius;
	}

	public int getRadius() {
		return this.radius;
	}

	public void render() {
		this.getRender().renderCircle(this.getX(), this.getY(), this.getRadius());
	}
}

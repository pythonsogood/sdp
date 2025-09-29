package org.pythonsogood.shapes;

import org.pythonsogood.interfaces.Render;
import org.pythonsogood.interfaces.Shape;

public class Square extends Shape {
	private int length;

	public Square(int x, int y, int length, Render render) {
		super(x, y, render);
		this.length = length;
	}

	public int getLength() {
		return this.length;
	}

	public void render() {
		this.getRender().renderSquare(this.getX(), this.getY(), this.getLength());
	}
}

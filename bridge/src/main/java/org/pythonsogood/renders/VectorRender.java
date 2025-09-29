package org.pythonsogood.renders;

import org.pythonsogood.interfaces.Render;

public class VectorRender implements Render {
	public VectorRender() {}

	public void renderCircle(int x, int y, int radius) {
		System.out.println(String.format("Rendering vector circle at (%s, %s) with radius %s", x, y, radius));
	}

	public void renderSquare(int x, int y, int length) {
		System.out.println(String.format("Rendering vector square at (%s, %s) with length %s", x, y, length));
	}
}

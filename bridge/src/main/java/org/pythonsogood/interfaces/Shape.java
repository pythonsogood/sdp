package org.pythonsogood.interfaces;

public abstract class Shape {
	private int x = 0;
	private int y = 0;
	private Render render;

	public Shape(int x, int y, Render render) {
		this.x = x;
		this.y = y;
		this.render = render;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public Render getRender() {
		return this.render;
	}

	public abstract void render();
}

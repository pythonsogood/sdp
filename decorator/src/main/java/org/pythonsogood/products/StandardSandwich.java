package org.pythonsogood.products;

import org.pythonsogood.interfaces.Sandwich;

public class StandardSandwich implements Sandwich {
	@Override
	public double getCost() {
		return 5.0;
	}

	@Override
	public String getComponents() {
		return "Sandwich";
	}

	@Override
	public String toString() {
		return String.format("%s. cost: %s", this.getComponents(), this.getCost());
	}
}

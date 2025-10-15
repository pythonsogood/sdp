package org.pythonsogood.interfaces;

public abstract class SandwichIngredient implements Sandwich {
	private Sandwich sandwich;

	public SandwichIngredient(Sandwich sandwich) {
		this.sandwich = sandwich;
	}

	@Override
	public double getCost() {
		return this.sandwich.getCost();
	}

	@Override
	public String getComponents() {
		return this.sandwich.getComponents();
	}

	@Override
	public String toString() {
		return String.format("%s. cost: %s", this.getComponents(), this.getCost());
	}
}

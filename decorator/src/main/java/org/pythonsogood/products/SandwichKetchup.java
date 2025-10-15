package org.pythonsogood.products;

import org.pythonsogood.interfaces.Sandwich;
import org.pythonsogood.interfaces.SandwichIngredient;

public class SandwichKetchup extends SandwichIngredient {
	public SandwichKetchup(Sandwich sandwich) {
		super(sandwich);
	}

	@Override
	public double getCost() {
		return super.getCost() + 0.75;
	}

	@Override
	public String getComponents() {
		return super.getComponents() + " with ketchup";
	}
}

package org.pythonsogood.products;

import org.pythonsogood.interfaces.Sandwich;
import org.pythonsogood.interfaces.SandwichIngredient;

public class SandwichTomato extends SandwichIngredient {
	public SandwichTomato(Sandwich sandwich) {
		super(sandwich);
	}

	@Override
	public double getCost() {
		return super.getCost() + 1.0;
	}

	@Override
	public String getComponents() {
		return super.getComponents() + " with tomato";
	}
}

package org.pythonsogood.products;

import org.pythonsogood.interfaces.Sandwich;
import org.pythonsogood.interfaces.SandwichIngredient;

public class SandwichCheese extends SandwichIngredient {
	public SandwichCheese(Sandwich sandwich) {
		super(sandwich);
	}

	@Override
	public double getCost() {
		return super.getCost() + 1.5;
	}

	@Override
	public String getComponents() {
		return super.getComponents() + " with cheese";
	}
}

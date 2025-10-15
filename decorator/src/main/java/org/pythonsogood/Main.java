package org.pythonsogood;

import org.pythonsogood.interfaces.Sandwich;
import org.pythonsogood.products.SandwichCheese;
import org.pythonsogood.products.SandwichKetchup;
import org.pythonsogood.products.SandwichTomato;
import org.pythonsogood.products.StandardSandwich;

public class Main {
    public static void main(String[] args) {
        Sandwich standardSandwich = new StandardSandwich();
		Sandwich standardSandwichWithCheese = new SandwichCheese(new StandardSandwich());
		Sandwich standardSandwichWithDoubleCheese = new SandwichCheese(new SandwichCheese(new StandardSandwich()));
		Sandwich standardSandwichWithTomatoAndWithCheese = new SandwichCheese(new SandwichTomato(new StandardSandwich()));
		Sandwich standardSandwichWithKetchupAndWithTomatoAndWithCheese = new SandwichCheese(new SandwichTomato(new SandwichKetchup(new StandardSandwich())));

		System.out.println(standardSandwich);
		System.out.println(standardSandwichWithCheese);
		System.out.println(standardSandwichWithDoubleCheese);
		System.out.println(standardSandwichWithTomatoAndWithCheese);
		System.out.println(standardSandwichWithKetchupAndWithTomatoAndWithCheese);
    }
}
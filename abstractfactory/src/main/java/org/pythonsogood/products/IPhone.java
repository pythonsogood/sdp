package org.pythonsogood.products;

import org.pythonsogood.interfaces.Phone;

public class IPhone implements Phone {
	public void call() {
		System.out.println("Calling from IPhone");
	}
}

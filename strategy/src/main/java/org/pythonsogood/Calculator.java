package org.pythonsogood;

import org.pythonsogood.interfaces.BinaryOperation;

public class Calculator {
	private double value = 0.0;

	public Calculator() {}

	public Calculator(double initialValue) {
		this.value = initialValue;
	}

	public double getValue() {
		return this.value;
	}

	public double execute(BinaryOperation operation, double secondValue) {
		this.value = operation.execute(this.value, secondValue);

		return this.value;
	}

	public void clear() {
		this.value = 0;
	}
}

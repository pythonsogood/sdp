package org.pythonsogood.operations;

import org.pythonsogood.interfaces.BinaryOperation;

public class Divide implements BinaryOperation {
	@Override
	public double execute(double firstValue, double secondValue) {
		return firstValue / secondValue;
	}
}

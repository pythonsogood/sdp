package org.pythonsogood;

public class Main {
    public static void main(String[] args) {
		Car car = new Car.Builder()
			.setBrand("Tesla")
			.setModel("Model Y")
			.setYear(2023)
			.setEngine(Car.Engine.Electric)
			.setTransmission(Car.Transmission.Automatic)
			.build();

		System.out.println(car);
    }
}
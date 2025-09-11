package org.pythonsogood;

public class Car {
    private final String brand;
	private final String model;
	private final Integer year;
	private final Engine engine;
	private final Transmission transmission;

	public enum Engine { Electric, Gas };
	public enum Transmission { Manual, Automatic };

	private Car(Builder builder) {
		this.brand = builder.brand;
		this.model = builder.model;
		this.year = builder.year;
		this.engine = builder.engine;
		this.transmission = builder.transmission;
	}

	public static class Builder {
		private String brand;
		private String model;
		private Integer year;
		private Engine engine = Engine.Electric;
		private Transmission transmission = Transmission.Automatic;

		public Builder setBrand(String brand) {
			this.brand = brand;
			return this;
		}

		public Builder setModel(String model) {
			this.model = model;
			return this;
		}

		public Builder setYear(Integer year) {
			this.year = year;
			return this;
		}

		public Builder setEngine(Engine engine) {
			this.engine = engine;
			return this;
		}

		public Builder setTransmission(Transmission transmission) {
			this.transmission = transmission;
			return this;
		}

		private void validateBuild() {
			if (this.brand == null) {
				throw new IllegalStateException("Brand cannot be null!");
			}

			if (this.model == null) {
				throw new IllegalStateException("Model cannot be null!");
			}

			if (this.year == null) {
				throw new IllegalStateException("Year cannot be null!");
			}
		}

		public Car build() {
			this.validateBuild();
			return new Car(this);
		}
	}

	public String toString() {
		return String.format("Car{brand=%s, model=%s, year=%s, engine=%s, transmission=%s}", this.brand, this.model, this.year, this.engine, this.transmission);
	}
}
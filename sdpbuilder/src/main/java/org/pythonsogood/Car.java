package org.pythonsogood;

// Checklist:

// [x] Functions must be very small
// [x] Prefer bodies shorter than 20 lines; ideally one screen or fewer
// [x] Each block (if/else, loop) should be a single call at a uniform level of abstraction
// [x] Do one thing, and do it well
// [x] A function’s name defines its abstraction level; its internals should only implement that level
// [x] If you can extract a subtask and name it without merely restating code, the original function was doing too much
// [x] One level of abstraction per function
// [x] Avoid mixing high-level concepts (e.g., getHtml()) with low-level details (.append("\n"))
// [x] Follow the “step-down rule”: arrange functions so each introduces the next level of detail
// [x] Minimize nesting
// [x] Keep indent depth to one or two levels
// [x] Collapse conditionals into single-call blocks to maintain a clear, top-down reading flow

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
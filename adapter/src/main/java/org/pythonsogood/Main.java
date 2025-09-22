package org.pythonsogood;

import org.pythonsogood.shapes.MetricBox;
import org.pythonsogood.types.Inch;
import org.pythonsogood.types.InchToMeterAdapter;

public class Main {
    public static void main(String[] args) {
		Inch lengthInches = new Inch(1);
		Inch widthInches = new Inch(2);
		Inch heightInches = new Inch(3);

		MetricBox metricBox = new MetricBox(
			new InchToMeterAdapter(lengthInches),
			new InchToMeterAdapter(widthInches),
			new InchToMeterAdapter(heightInches)
		);

		System.out.println(String.format("Volume: %s, Area: %s", metricBox.getVolume(), metricBox.getArea()));
    }
}
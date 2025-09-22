package org.pythonsogood;

import org.pythonsogood.shapes.MetricBox;
import org.pythonsogood.shapes.MetricSphere;
import org.pythonsogood.types.Inch;
import org.pythonsogood.types.InchToMeterAdapter;
import org.pythonsogood.types.MeterToInchAdapter;

public class Main {
    public static void main(String[] args) {
		Inch lengthInches = new Inch(25);
		Inch widthInches = new Inch(35);
		Inch heightInches = new Inch(25);

		MetricBox metricBox = new MetricBox(
			new InchToMeterAdapter(lengthInches),
			new InchToMeterAdapter(widthInches),
			new InchToMeterAdapter(heightInches)
		);

		System.out.println(String.format("[Box] Volume: %s, Area: %s", new MeterToInchAdapter(metricBox.getVolume()), new MeterToInchAdapter(metricBox.getArea())));

		Inch radiusInches = new Inch(80);

		MetricSphere metricSphere = new MetricSphere(new InchToMeterAdapter(radiusInches));

		System.out.println(String.format("[Sphere] Volume: %s, Area: %s", new MeterToInchAdapter(metricSphere.getVolume()), new MeterToInchAdapter(metricSphere.getArea())));
    }
}
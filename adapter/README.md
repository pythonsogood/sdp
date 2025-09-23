# Assignment 3. Adapter Pattern

[![License: MIT](https://img.shields.io/badge/License-MIT-green.svg)](https://opensource.org/license/mit/)

## Overview

`Value` interface

```java
double getValue();
void setValue(double value);

int getExponent();
void setExponent(int exponent);

@Override
String toString();
```

`MetricValue` interface extends `Value`

`Shape` interface

```java
MetricValue getVolume();
MetricValue getArea();
```

`Meter`, `Inch` classes implements `MetricValue`

```java
double getValue();
void setValue(double value);

int getExponent();
void setExponent(int exponent);

@Override
String toString();
```

`InchToMeterAdapter`, `MeterToInchAdapter` classes implements `MetricValue`

```java
double getValue();
void setValue(double value);

int getExponent();
void setExponent(int exponent);

@Override
String toString();
```

`MetricBox`, `MetricSphere` classes implements `Shape`

```java
MetricValue getVolume();
MetricValue getArea();
```

### UML

![UML](/adapter/assets/uml.svg)

### Usage

```java
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
```

## Requirements

* [JDK 24](https://jdk.java.net/24/)[^1]
* [Apache Maven](https://maven.apache.org/install.html)


[^1]: Tested on [JDK 24](https://jdk.java.net/24/), but should run fine on [JDK 21](https://jdk.java.net/archive/) too

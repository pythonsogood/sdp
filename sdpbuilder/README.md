# Assignment 1. Builder

[![License: MIT](https://img.shields.io/badge/License-MIT-green.svg)](https://opensource.org/license/mit/)

## Overview

`Car` class

```java
private final String brand;
private final String model;
private final Integer year;
private final Engine engine;
private final Transmission transmission;
```

`Car.Builder` class

```java
setBrand(String brand)
setModel(String model)
setYear(Integer year)
setEngine(Engine engine)
setTransmission(Transmission transmission)

Car build()
```

`Engine` enum `Electric, Gas`

`Transmission` enum `Manual, Automatic`

### Builder usage

```java
Car car = new Car.Builder()
	.setBrand("Tesla")
	.setModel("Model Y")
	.setYear(2023)
	.setEngine(Car.Engine.Electric)
	.setTransmission(Car.Transmission.Automatic)
	.build();
```

## Requirements

* [JDK 24](https://jdk.java.net/24/)[^1]
* [Apache Maven](https://maven.apache.org/install.html)


[^1]: Tested on [JDK 24](https://jdk.java.net/24/), but should run fine on [JDK 21](https://jdk.java.net/archive/) too

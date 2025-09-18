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

## Principles of Clean Code

- [x] Functions must be very small
- [x] Prefer bodies shorter than 20 lines; ideally one screen or fewer
- [x] Each block (if/else, loop) should be a single call at a uniform level of abstraction
- [x] Do one thing, and do it well
- [x] A function’s name defines its abstraction level; its internals should only implement that level
- [x] If you can extract a subtask and name it without merely restating code, the original function was doing too much
- [x] One level of abstraction per function
- [x] Avoid mixing high-level concepts (e.g., getHtml()) with low-level details (.append("\n"))
- [x] Follow the “step-down rule”: arrange functions so each introduces the next level of detail
- [x] Minimize nesting
- [x] Keep indent depth to one or two levels
- [x] Collapse conditionals into single-call blocks to maintain a clear, top-down reading flow

## Requirements

* [JDK 24](https://jdk.java.net/24/)[^1]
* [Apache Maven](https://maven.apache.org/install.html)


[^1]: Tested on [JDK 24](https://jdk.java.net/24/), but should run fine on [JDK 21](https://jdk.java.net/archive/) too

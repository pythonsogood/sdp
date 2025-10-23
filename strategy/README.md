# Assignment 6. Strategy

[![License: MIT](https://img.shields.io/badge/License-MIT-green.svg)](https://opensource.org/license/mit/)

## Overview

`BinaryOperation` interface

```java
double execute(double firstValue, double secondValue);
```

`Add`, `Subtract`, `Multiply`, `Divide` classes implements `BinaryOperation`

```java
double execute(double firstValue, double secondValue);
```

`Calculator` class

```java
double getValue();
double execute(BinaryOperation operation, double secondValue);
void clear();
```

## UML

![UML](/strategy/assets/uml.svg)

## Requirements

* [JDK 21](https://jdk.java.net/archive/)
* [Apache Maven](https://maven.apache.org/install.html)

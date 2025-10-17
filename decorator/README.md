# Assignment 5. Decorator Pattern. [Facade pattern](/facade)

[![License: MIT](https://img.shields.io/badge/License-MIT-green.svg)](https://opensource.org/license/mit/)

## Overview

`Sandwich` interface

```java
double getCost();
String getComponents();
String toString();
```

`SandwichIngredient` abstract class implements `Sandwich`

```java
double getCost();
String getComponents();
String toString();
```

`SandwichCheese`, `SandwichKetchup`, `SandwichTomato` extends class `SandwichIngredient`

```java
double getCost();
String getComponents();
```

`StandardSandwich` class implements `Sandwich`

```java
double getCost();
String getComponents();
String toString();
```

### UML

![UML](/decorator/assets/uml.svg)

### Usage


## Requirements

* [JDK 24](https://jdk.java.net/24/)[^1]
* [Apache Maven](https://maven.apache.org/install.html)


[^1]: Tested on [JDK 24](https://jdk.java.net/24/), but should run fine on [JDK 21](https://jdk.java.net/archive/) too

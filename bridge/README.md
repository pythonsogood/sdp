# Assignment 4. Bridge Pattern

[![License: MIT](https://img.shields.io/badge/License-MIT-green.svg)](https://opensource.org/license/mit/)

## Overview

`Render` interface

```java
void renderCircle(int x, int y, int radius);
void renderSquare(int x, int y, int length);
```

`Shape` abstract class

```java
int getX();
int getY();
Render getRender();
abstract void render();
```

`PixelArtRender`, `VectorRender` classes implements `Render`

```java
void renderCircle(int x, int y, int radius);
void renderSquare(int x, int y, int length);
```

`Circle` class

```java
int getRadius();
void render();
```

`Square` class

```java
int getLength();
void render();
```

### UML

![UML](/bridge/assets/uml.svg)

### Usage

```java
Render pixelArtRender = new PixelArtRender();
Render vectorRender = new VectorRender();

Circle pixelArtCircle = new Circle(10, 10, 5, pixelArtRender);
pixelArtCircle.render();

Circle vectorCircle = new Circle(10, 10, 5, vectorRender);
vectorCircle.render();

Square pixelArtSquare = new Square(10, 10, 5, pixelArtRender);
pixelArtSquare.render();

Square vectorSquare = new Square(10, 10, 5, vectorRender);
vectorSquare.render();
```

## Requirements

* [JDK 24](https://jdk.java.net/24/)[^1]
* [Apache Maven](https://maven.apache.org/install.html)


[^1]: Tested on [JDK 24](https://jdk.java.net/24/), but should run fine on [JDK 21](https://jdk.java.net/archive/) too

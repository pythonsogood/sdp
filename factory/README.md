# Assignment 2. Factory Method / [Abstract Factory](/abstractfactory)

[![License: MIT](https://img.shields.io/badge/License-MIT-green.svg)](https://opensource.org/license/mit/)

## Overview

`Application` abstract class

```java
abstract void run();
```

`ApplicationFactory` abstract class

```java
abstract Application developApplication();
```

`AndroidApplication`, `IOSApplication` classes extends `Application`
```java
void run();
```

`AndroidApplicationFactory`, `IOSApplicationFactory` classes extends `ApplicationFactory`
```java
Application developApplication();
```

`Developer` class

```java
Application developApplication();
```

### UML

![UML](/factory/assets/uml.png)

### Usage

```java
AndroidApplicationFactory androidApplicationFactory = new AndroidApplicationFactory();
IOSApplicationFactory iOSApplicationFactory = new IOSApplicationFactory();

Developer androidDeveloper = new Developer(androidApplicationFactory);
Developer iOSDeveloper = new Developer(iOSApplicationFactory);

Application androidApplication = androidDeveloper.developApplication();
androidApplication.run();

Application iOSApplication = iOSDeveloper.developApplication();
iOSApplication.run();
```

## Requirements

* [JDK 24](https://jdk.java.net/24/)[^1]
* [Apache Maven](https://maven.apache.org/install.html)


[^1]: Tested on [JDK 24](https://jdk.java.net/24/), but should run fine on [JDK 21](https://jdk.java.net/archive/) too

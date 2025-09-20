# Assignment 2. [Factory Method](/factory) / Abstract Factory

[![License: MIT](https://img.shields.io/badge/License-MIT-green.svg)](https://opensource.org/license/mit/)

## Overview

`Laptop` interface

```java
void run();
```

`Phone` interface

```java
void call();
```

`DeviceFactory` interface

```java
Laptop createLaptop();
Phone createPhone();
```

`IPhone`, `MatePhone` classes implements `Phone`

```java
void call();
```

`MacBook`, `MateBook` classes implements `Laptop`

```java
void run();
```

`AppleDeviceFactory`, `HuaweiDeviceFactory` classes implements `DeviceFactory`
```java
Laptop createLaptop();
Phone createPhone();
```

### UML

![UML](/abstractfactory/assets/uml.png)

### Usage

```java
DeviceFactory appleDeviceFactory = new AppleDeviceFactory();
DeviceFactory huaweiDeviceFactory = new HuaweiDeviceFactory();

Laptop appleLaptop = appleDeviceFactory.createLaptop();
appleLaptop.run();

Phone applePhone = appleDeviceFactory.createPhone();
applePhone.call();

Laptop huaweiLaptop = huaweiDeviceFactory.createLaptop();
huaweiLaptop.run();

Phone huaweiPhone = huaweiDeviceFactory.createPhone();
huaweiPhone.call();
```

## Requirements

* [JDK 24](https://jdk.java.net/24/)[^1]
* [Apache Maven](https://maven.apache.org/install.html)


[^1]: Tested on [JDK 24](https://jdk.java.net/24/), but should run fine on [JDK 21](https://jdk.java.net/archive/) too

# Assignment 7. Observer

[![License: MIT](https://img.shields.io/badge/License-MIT-green.svg)](https://opensource.org/license/mit/)

## Overview

`StoreNotificationType` enum `NewItem, ItemPriceUpdate, ItemRemoved`

`StoreNotification` interface

```java
StoreNotificationType getType();
String getTitle();
String getDescription();
```

`AbstractStoreNotification` abstract class implements `StoreNotification`
```java
StoreNotificationType getType();
String getTitle();
String getDescription();
String toString();
```

`StoreNewItemNotification`, `StoreItemPriceUpdateNotification`, `StoreRemoveItemNotification` classes extends `AbstractStoreNotification`

`Subscriber` interface

```java
void update(T context);
int hashCode();
```

`StoreSubscriber` implements `Subscriber`

```java
void update(StoreNotification context);
int hashCode();
```

`Customer` class

```java
String getName();
void setName(String name);
UUID getUuid();
void subscribeStoreNotifications(Publisher<StoreNotification> store);
void unsubscribeStoreNotifications(Publisher<StoreNotification> store);
void setStoreNotificationFilter(List<StoreNotificationType> notificationTypes);
void clearStoreNotificationFilter();
void onStoreNotification(StoreNotification notification);
int hashCode();
```

`Publisher` interface

```java
void subscribe(Subscriber<T> subscriber);
void unsubscribe(Subscriber<T> subscriber);
boolean isSubscribed(Subscriber<T> subscriber);
void notifySubscribers(T context);
```

`AbstractPublisher` abstracts class implements `Publisher`

```java
void subscribe(Subscriber<T> subscriber);
void unsubscribe(Subscriber<T> subscriber);
boolean isSubscribed(Subscriber<T> subscriber);
void notifySubscribers(T context);
```

`Store` class extends `AbstractPublisher<StoreNotification>`

```java
List<StoreItem> getItems();
StoreItem addNewItem(String title, String description, float priceDollars);
void setItemPriceDollars(StoreItem item, float priceDollars);
boolean removeItem(StoreItem item);
```

`StoreItem` class

```java
String getTitle();
String getDescription();
void setDescription(String description);
float getPriceDollars();
void setPriceDollars(float priceDollars);
```

## UML

![UML](/observer/assets/uml.svg)

## Requirements

* [JDK 21](https://jdk.java.net/archive/)
* [Apache Maven](https://maven.apache.org/install.html)

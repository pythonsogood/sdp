# Assignment 8. Visitor

[![License: MIT](https://img.shields.io/badge/License-MIT-green.svg)](https://opensource.org/license/mit/)

## Overview

`Element` interface

```java
K accept(Visitor<T, K> visitor);
```

`Node` abstract class implements `Element<Node, NodeMetadata>`

```java
String getName();
Directory getParent();
NodePermissions getPermissions();
void setPermissions(NodePermissions permissions);
String getFullName();
String getPath();
String getPathWithFullName();
String getKey();
String getKey(Directory newParent);
String getKey(String newFullName);
abstract NodeMetadata accept(Visitor<Node, NodeMetadata> visitor);
static abstract class AbstractBuilder<T extends Node>;
```

`File` class extends `Node`

```java
String getExtension();
String getFullName()
NodeMetadata accept(Visitor<Node, NodeMetadata> visitor);
static class Builder extends Node.AbstractBuilder<File>;
```

`Directory` class extends `Node`

```java
NodeMetadata accept(Visitor<Node, NodeMetadata> visitor);
static class Builder extends Node.AbstractBuilder<Directory>;
```

`NodeMetadata` class

```java
String toString();
```

`NodePermission` enum `EXECUTE`, `READ`, `WRITE`

`NodePermissions` class

```java
Set<NodePermission> getOwnerPermissions();
Set<NodePermission> getGroupPermissions()
Set<NodePermission> getOtherPermissions();
void setOwnerPermissions(Set<NodePermission> permissions);
void addOwnerPermissions(NodePermission... permissions);
void removeOwnerPermissions(NodePermission... permissions);
void clearOwnerPermissions();
void setGroupPermissions(Set<NodePermission> permissions);
void addGroupPermissions(NodePermission... permissions);
void removeGroupPermissions(NodePermission... permissions);
void clearGroupPermissions();
void setOtherPermissions(Set<NodePermission> permissions);
void addOtherPermissions(NodePermission... permissions);
void removeOtherPermissions(NodePermission... permissions);
void clearOtherPermissions()
int toOctal();
String toString();
static class Builder;
```

`Visitor` interface

```java
K visit(T element);
```

`Archive` class implements `Visitor<Node, NodeMetadata>`

```java
NodeMetadata visit(Node node);
NodeMetadata visitFile(File file);
NodeMetadata visitDirectory(Directory directory);
void addNode(Node node);
void renameNode(Node node);
void removeNode(Node node);
void setNodeParent(Node node, Directory parent);
void setFileExtension(File file, String extension);
String listDir();
```

## UML

![UML](/visitor/assets/uml.svg)

## Requirements

* [JDK 21](https://jdk.java.net/archive/)
* [Apache Maven](https://maven.apache.org/install.html)

# Assignment 5. [Decorator pattern](/decorator). Facade Pattern

[![License: MIT](https://img.shields.io/badge/License-MIT-green.svg)](https://opensource.org/license/mit/)

## Overview

`AudioCodec` enum `MP3, AAC, OGG, FLAC, OPUS`

`VideoCodec` enum `H264, HEVC, VP8, VP9, AV1`

`AudioFormat` enum `AAC, FLAC, M4A, MP3, OGG, OPUS, WAV`

`VideoFormat` enum `MP4, AVI, WEBM, MKV`

`Audio` class

```java
String getFilename();
void setFilename(String filename);
AudioCodec getCodec();
void setCodec(AudioCodec codec);
AudioFormat getFormat();
void setFormat(AudioFormat format);
int getBitrate();
void setBitrate(int bitrate);
List<Byte> getBuffer();
void setBuffer(List<Byte> buffer);

boolean isAudioCodecValid();
List<AudioCodec> getCompatibleAudioCodecs();

String getExtension();
```

`Video` class

```java
String getFilename();
void setFilename(String filename);
AudioCodec getCodec();
void setCodec(AudioCodec codec);
AudioFormat getFormat();
void setFormat(AudioFormat format);
int getWidth();
void setWidth(int width);
int getHeight();
void setHeight(int height);
int getBitrate();
void setBitrate(int bitrate);
int getFramerate();
void setFramerate(int framerate);
List<Byte> getBuffer();
void setBuffer(List<Byte> buffer);
Audio getAudio();
void setAudio(Audio audio);

boolean isVideoCodecValid();
boolean isAudioCodecValid();
List<VideoCodec> getCompatibleVideoCodecs();
List<AudioCodec> getCompatibleAudioCodecs();

String getExtension();
```

`VideoConverter` class

```java
static void convert(Video video, VideoFormat format, VideoCodec codec);
static void convert(Video video, VideoFormat format);
```

### UML

![UML](/facade/assets/uml.svg)

### Usage


## Requirements

* [JDK 24](https://jdk.java.net/24/)[^1]
* [Apache Maven](https://maven.apache.org/install.html)


[^1]: Tested on [JDK 24](https://jdk.java.net/24/), but should run fine on [JDK 21](https://jdk.java.net/archive/) too

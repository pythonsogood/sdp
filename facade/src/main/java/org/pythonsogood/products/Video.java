package org.pythonsogood.products;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.pythonsogood.enums.AudioCodec;
import org.pythonsogood.enums.VideoCodec;
import org.pythonsogood.enums.VideoFormat;

public class Video {
	private static final HashMap<VideoFormat, List<VideoCodec>> COMPATIBLE_FORMAT_VIDEO_CODECS = new HashMap<>(Map.of(
		VideoFormat.MP4, List.of(VideoCodec.H264, VideoCodec.HEVC, VideoCodec.AV1, VideoCodec.VP8, VideoCodec.VP9),
		VideoFormat.AVI, List.of(VideoCodec.H264, VideoCodec.VP8, VideoCodec.VP9),
		VideoFormat.WEBM, List.of(VideoCodec.VP8, VideoCodec.VP9, VideoCodec.AV1),
		VideoFormat.MKV, List.of(VideoCodec.H264, VideoCodec.HEVC, VideoCodec.AV1, VideoCodec.VP8, VideoCodec.VP9)
	));

	private static final HashMap<VideoFormat, List<AudioCodec>> COMPATIBLE_FORMAT_AUDIO_CODECS = new HashMap<>(Map.of(
		VideoFormat.MP4, List.of(AudioCodec.AAC, AudioCodec.FLAC, AudioCodec.MP3, AudioCodec.OPUS),
		VideoFormat.AVI, List.of(AudioCodec.AAC, AudioCodec.FLAC, AudioCodec.MP3, AudioCodec.OPUS, AudioCodec.OGG),
		VideoFormat.WEBM, List.of(AudioCodec.OPUS),
		VideoFormat.MKV, List.of(AudioCodec.OPUS)
	));

	private static final HashMap<VideoFormat, String> EXTENSIONS = new HashMap<>(Map.of(
		VideoFormat.MP4, "mp4",
		VideoFormat.AVI, "avi",
		VideoFormat.WEBM, "webm",
		VideoFormat.MKV, "mkv"
	));

	private String filename;
	private VideoCodec codec;
	private VideoFormat format;
	private int width;
	private int height;
	private int bitrate;
	private int framerate;
	private List<Byte> buffer;

	private Audio audio;

	public Video(String filename, VideoCodec codec, VideoFormat format, int width, int height, int bitrate, int framerate, List<Byte> buffer) {
		this.filename = filename;
		this.codec = codec;
		this.format = format;
		this.width = width;
		this.height = height;
		this.bitrate = bitrate;
		this.framerate = framerate;
		this.buffer = buffer;
	}

	public Video(String filename, VideoCodec codec, VideoFormat format, int width, int height, int bitrate, int framerate) {
		this.filename = filename;
		this.codec = codec;
		this.format = format;
		this.width = width;
		this.height = height;
		this.bitrate = bitrate;
		this.framerate = framerate;
	}

	public Video(String filename, VideoCodec codec, VideoFormat format, int width, int height, int bitrate, int framerate, List<Byte> buffer, Audio audio) {
		this.filename = filename;
		this.codec = codec;
		this.format = format;
		this.width = width;
		this.height = height;
		this.bitrate = bitrate;
		this.framerate = framerate;
		this.buffer = buffer;
		this.audio = audio;
	}

	public Video(String filename, VideoCodec codec, VideoFormat format, int width, int height, int bitrate, int framerate, Audio audio) {
		this.filename = filename;
		this.codec = codec;
		this.format = format;
		this.width = width;
		this.height = height;
		this.bitrate = bitrate;
		this.framerate = framerate;
		this.audio = audio;
	}

	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public VideoCodec getCodec() {
		return this.codec;
	}

	public void setCodec(VideoCodec codec) {
		this.codec = codec;
	}

	public VideoFormat getFormat() {
		return this.format;
	}

	public void setFormat(VideoFormat format) {
		this.format = format;
	}

	public int getWidth() {
		return this.width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return this.height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getBitrate() {
		return this.bitrate;
	}

	public void setBitrate(int bitrate) {
		this.bitrate = bitrate;
	}

	public int getFramerate() {
		return this.framerate;
	}

	public void setFramerate(int framerate) {
		this.framerate = framerate;
	}

	public List<Byte> getBuffer() {
		return this.buffer;
	}

	public void setBuffer(List<Byte> buffer) {
		this.buffer = buffer;
	}

	public Audio getAudio() {
		return this.audio;
	}

	public void setAudio(Audio audio) {
		this.audio = audio;
	}

	public boolean isVideoCodecValid() {
		return Video.COMPATIBLE_FORMAT_VIDEO_CODECS.get(this.format).contains(this.codec);
	}

	public boolean isAudioCodecValid() {
		return Video.COMPATIBLE_FORMAT_AUDIO_CODECS.get(this.format).contains(this.audio.getCodec());
	}

	public List<VideoCodec> getCompatibleVideoCodecs() {
		return Video.COMPATIBLE_FORMAT_VIDEO_CODECS.get(this.format);
	}

	public List<AudioCodec> getCompatibleAudioCodecs() {
		return Video.COMPATIBLE_FORMAT_AUDIO_CODECS.get(this.format);
	}

	public String getExtension() {
		return Video.EXTENSIONS.get(this.format);
	}

	@Override
	public String toString() {
		return String.format("%s.%s, %sx%s %sfps (%s/%s, %s/%s Kbps)", this.getFilename(), this.getExtension(), this.getWidth(), this.getHeight(), this.getFramerate(), this.getCodec(), this.getAudio().getCodec(), (int) (this.getBitrate() / 1000), (int) (this.getAudio().getBitrate() / 1000));
	}
}

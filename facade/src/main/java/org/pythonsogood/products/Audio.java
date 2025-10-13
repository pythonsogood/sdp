package org.pythonsogood.products;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.pythonsogood.enums.AudioCodec;
import org.pythonsogood.enums.AudioFormat;

public class Audio {
	private static final HashMap<AudioFormat, List<AudioCodec>> COMPATIBLE_FORMAT_AUDIO_CODECS = new HashMap<>(Map.of(
		AudioFormat.AAC, List.of(AudioCodec.AAC),
		AudioFormat.FLAC, List.of(AudioCodec.FLAC),
		AudioFormat.M4A, List.of(AudioCodec.AAC),
		AudioFormat.MP3, List.of(AudioCodec.MP3),
		AudioFormat.OGG, List.of(AudioCodec.OGG),
		AudioFormat.OPUS, List.of(AudioCodec.OPUS),
		AudioFormat.WAV, List.of(AudioCodec.AAC, AudioCodec.FLAC, AudioCodec.MP3, AudioCodec.OGG, AudioCodec.OPUS)
	));

	private static final HashMap<AudioFormat, String> EXTENSIONS = new HashMap<>(Map.of(
		AudioFormat.AAC, "aac",
		AudioFormat.FLAC, "flac",
		AudioFormat.M4A, "m4a",
		AudioFormat.MP3, "mp3",
		AudioFormat.OGG, "ogg",
		AudioFormat.OPUS, "opus",
		AudioFormat.WAV, "wav"
	));

	private String filename;
	private AudioCodec codec;
	private AudioFormat format;
	private int bitrate;
	private List<Byte> buffer;

	public Audio(String filename, AudioCodec codec, AudioFormat format, int bitrate, List<Byte> buffer) {
		this.filename = filename;
		this.codec = codec;
		this.format = format;
		this.bitrate = bitrate;
		this.buffer = buffer;
	}

	public Audio(String filename, AudioCodec codec, AudioFormat format, int bitrate) {
		this.filename = filename;
		this.codec = codec;
		this.format = format;
		this.bitrate = bitrate;
	}

	public Audio(AudioCodec codec, int bitrate, List<Byte> buffer) {
		this.codec = codec;
		this.bitrate = bitrate;
		this.buffer = buffer;
	}

	public Audio(AudioCodec codec, int bitrate) {
		this.codec = codec;
		this.bitrate = bitrate;
	}

	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public AudioCodec getCodec() {
		return this.codec;
	}

	public void setCodec(AudioCodec codec) {
		this.codec = codec;
	}

	public AudioFormat getFormat() {
		return this.format;
	}

	public void setFormat(AudioFormat format) {
		this.format = format;
	}

	public int getBitrate() {
		return this.bitrate;
	}

	public void setBitrate(int bitrate) {
		this.bitrate = bitrate;
	}

	public List<Byte> getBuffer() {
		return this.buffer;
	}

	public void setBuffer(List<Byte> buffer) {
		this.buffer = buffer;
	}

	public boolean isAudioCodecValid() {
		return Audio.COMPATIBLE_FORMAT_AUDIO_CODECS.get(this.format).contains(this.codec);
	}

	public List<AudioCodec> getCompatibleAudioCodecs() {
		return Audio.COMPATIBLE_FORMAT_AUDIO_CODECS.get(this.format);
	}

	public String getExtension() {
		return Audio.EXTENSIONS.get(this.format);
	}

	@Override
	public String toString() {
		return String.format("%s.%s, (%s, %s Kbps)", this.getFilename(), this.getExtension(), this.getCodec(), (int) (this.getBitrate() / 1000));
	}
}

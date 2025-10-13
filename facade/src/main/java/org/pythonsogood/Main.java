package org.pythonsogood;

import org.pythonsogood.enums.AudioCodec;
import org.pythonsogood.enums.VideoCodec;
import org.pythonsogood.enums.VideoFormat;
import org.pythonsogood.products.Audio;
import org.pythonsogood.products.Video;

public class Main {
    public static void main(String[] args) {
		Video film = new Video(
			"film",
			VideoCodec.HEVC,
			VideoFormat.MKV,
			1920,
			1080,
			10000000,
			30,
			new Audio(AudioCodec.OPUS, 192000)
		);

        System.out.println(film);

		VideoConverter.convert(film, VideoFormat.MP4, VideoCodec.AV1);

		System.out.println(film);
    }
}
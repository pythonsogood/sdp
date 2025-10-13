package org.pythonsogood;

import org.pythonsogood.enums.VideoCodec;
import org.pythonsogood.enums.VideoFormat;
import org.pythonsogood.products.Audio;
import org.pythonsogood.products.Video;

public class VideoConverter {
	private static int getRecommendedBitrate(VideoCodec codec, int resolution, int fps) {
		if (fps <= 45) {
			switch (codec) {
				case H264:
					return (int) Math.round(resolution * 6.5);

				case HEVC:
					return resolution * 5;

				case VP8:
					return (int) Math.round(resolution * 4.5);

				case VP9:
					return resolution * 4;

				case AV1:
					return resolution * 3;

				default:
					return resolution * 7;
			}
		} else {
			switch (codec) {
				case H264:
					return resolution * 9;

				case HEVC:
					return resolution * 8;

				case VP8:
					return (int) Math.round(resolution * 7.5);

				case VP9:
					return resolution * 7;

				case AV1:
					return resolution * 4;

				default:
					return resolution * 9;
			}
		}
	}

	public static void convert(Video video, VideoFormat format, VideoCodec codec) {
		if (video.getFormat() != format) {
			video.setFormat(format);
		}

		if (codec != null) {
			video.setCodec(codec);
		}

		if (!video.isVideoCodecValid()) {
			video.setCodec(video.getCompatibleVideoCodecs().get(0));
		}

		Audio audio = video.getAudio();

		if (!video.isAudioCodecValid()) {
			audio.setCodec(video.getCompatibleAudioCodecs().get(0));
		}

		int recommendedBitrate = VideoConverter.getRecommendedBitrate(video.getCodec(), video.getWidth() * video.getHeight(), video.getFramerate());

		if (Math.abs(video.getBitrate() - recommendedBitrate) > 2500000) {
			video.setBitrate(recommendedBitrate);
		}
	}

	public static void convert(Video video, VideoFormat format) {
		VideoConverter.convert(video, format, null);
	}
}

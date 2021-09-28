package de.hsvoss.vision_tweet_ng_backend.converter;

import de.hsvoss.vision_tweet_ng_backend.apimodel.TweetRequestDTO;
import de.hsvoss.vision_tweet_ng_backend.domain.Tweet;
import org.springframework.core.convert.converter.Converter;

import java.util.UUID;

public class DtoToTweet implements Converter<TweetRequestDTO, Tweet> {
    @Override
    public Tweet convert(TweetRequestDTO source) {
        return Tweet.builder()
                .id(UUID.randomUUID())
                .message(source.getMessage())
                .avatarUrl(source.getAvatarUrl())
                .user(source.getUser())
                .liked(source.isLiked())
                .build();

    }
}

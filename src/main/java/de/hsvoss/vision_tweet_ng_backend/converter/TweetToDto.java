package de.hsvoss.vision_tweet_ng_backend.converter;

import de.hsvoss.vision_tweet_ng_backend.apimodel.TweetResponseDTO;
import de.hsvoss.vision_tweet_ng_backend.domain.Tweet;
import org.springframework.core.convert.converter.Converter;

public class TweetToDto implements Converter<Tweet, TweetResponseDTO> {
    @Override
    public TweetResponseDTO convert(Tweet source) {
        return TweetResponseDTO.builder()
                .id(source.getId())
                .message(source.getMessage())
                .avatarUrl(source.getAvatarUrl())
                .user(source.getUser())
                .liked(source.isLiked())
                .build();

    }
}

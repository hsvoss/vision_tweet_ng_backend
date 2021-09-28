package de.hsvoss.vision_tweet_ng_backend.apimodel;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TweetRequestDTO {

    private String message;
    private String user;
    private String avatarUrl;
    private boolean liked;
}

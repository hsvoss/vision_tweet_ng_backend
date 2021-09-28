package de.hsvoss.vision_tweet_ng_backend.apimodel;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class TweetResponseDTO {

    private UUID id;
    private String message;
    private String user;
    private String avatarUrl;
    private boolean liked;

}

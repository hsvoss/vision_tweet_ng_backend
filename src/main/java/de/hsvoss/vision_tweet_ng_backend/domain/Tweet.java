package de.hsvoss.vision_tweet_ng_backend.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Data
@Builder
public class Tweet {

    @Id
    private UUID id;
    private String message;
    private String user;
    private String avatarUrl;
    private boolean liked;
}

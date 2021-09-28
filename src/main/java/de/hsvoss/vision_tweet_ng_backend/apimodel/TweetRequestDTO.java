package de.hsvoss.vision_tweet_ng_backend.apimodel;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TweetRequestDTO {

    @Schema(example = "Hallo Welt!")
    private String message;
    @Schema(description = "Des vollständige Username", example = "Micky", required = true)
    private String user;
    @Schema(example = "https://www.micky-maus.de/content/images/characters/navigation/Micky.jpg")
    private String avatarUrl;
    @Schema(deprecated = true)
    private boolean liked;
}

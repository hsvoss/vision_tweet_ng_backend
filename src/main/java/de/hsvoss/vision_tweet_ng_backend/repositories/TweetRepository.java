package de.hsvoss.vision_tweet_ng_backend.repositories;

import de.hsvoss.vision_tweet_ng_backend.domain.Tweet;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TweetRepository extends CrudRepository<Tweet, UUID> {
}

package de.hsvoss.vision_tweet_ng_backend.services;

import de.hsvoss.vision_tweet_ng_backend.domain.Tweet;
import de.hsvoss.vision_tweet_ng_backend.repositories.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TweetService {

    @Autowired
    TweetRepository repository;


    public Tweet addTweet(Tweet tweet) {
        return repository.save(tweet);
    }

    public Tweet updateTweet(Tweet tweet) {
        return repository.save(tweet);
    }

    public Optional<Tweet> getTweet(UUID id) {
        return repository.findById(id);
    }

    public List<Tweet> getAllTweets() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public void deleteTweet(UUID id) {
        repository.deleteById(id);

    }

}

package de.hsvoss.vision_tweet_ng_backend.controller;

import de.hsvoss.vision_tweet_ng_backend.apimodel.TweetRequestDTO;
import de.hsvoss.vision_tweet_ng_backend.apimodel.TweetResponseDTO;
import de.hsvoss.vision_tweet_ng_backend.domain.Tweet;
import de.hsvoss.vision_tweet_ng_backend.services.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.UUID;

@RestController
public class TweetsController {
//    https://vision-tweet-ng-backend.herokuapp.com/
//    https://docs.microsoft.com/de-de/azure/architecture/best-practices/api-design

//    @Autowired
    ConversionService conversionService;

    TweetService tweetService;

    public TweetsController(ConversionService conversionService, TweetService tweetService) {
        this.conversionService = conversionService;
        this.tweetService = tweetService;
    }

    @GetMapping(path = "/sayhello")
    String sayHello() {
        return "Hallo Welt!!!";
    }

    @GetMapping(path = "tweets")
    List<TweetResponseDTO> getAllTweets() {

        List<Tweet> allTweets = tweetService.getAllTweets();

//        Tweet tweet;
//
        List<TweetResponseDTO> convert = conversionService.convert(allTweets, List.class);

//        TweetResponseDTO tweetResponseDTO = new TweetResponseDTO();
//        tweetResponseDTO.setMessage("Hallo Welt 2");
        return convert;
    }

    @GetMapping(path = "tweets/{id}")
    TweetResponseDTO getOneTweet(@PathParam("id") UUID id) {

//        TweetResponseDTO tweetResponseDTO = new TweetResponseDTO();
//        tweetResponseDTO.setMessage("Hallo Welt 2");
        return null;
    }

    @PostMapping(path = "tweets")
    TweetResponseDTO createTweet(@RequestBody TweetRequestDTO request) {
        Tweet mappedRequest = conversionService.convert(request, Tweet.class);

        Tweet erstellteTweet = tweetService.addTweet(mappedRequest);
        return conversionService.convert(erstellteTweet, TweetResponseDTO.class);

    }

    @DeleteMapping(path = "tweets/{id}")
    void deleteOneTweet(@PathParam("id") UUID id) {

    }

    @PutMapping(path = "tweets/{id}")
    TweetResponseDTO createTweet(@PathParam("id") UUID id,
                                 @RequestBody TweetRequestDTO request) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }


}

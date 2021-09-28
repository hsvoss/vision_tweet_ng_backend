package de.hsvoss.vision_tweet_ng_backend.controller;

import de.hsvoss.vision_tweet_ng_backend.apimodel.TweetRequestDTO;
import de.hsvoss.vision_tweet_ng_backend.apimodel.TweetResponseDTO;
import de.hsvoss.vision_tweet_ng_backend.domain.Tweet;
import de.hsvoss.vision_tweet_ng_backend.services.TweetService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "all tweets"),
            @ApiResponse(responseCode = "404", description = "no tweets")
    })
    List<TweetResponseDTO> getAllTweets() {

        List<Tweet> allTweets = tweetService.getAllTweets();
        return conversionService.convert(allTweets, List.class);
    }

    @GetMapping("tweets/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "the tweet"),
            @ApiResponse(responseCode = "404", description = "no tweet for the id")
    })
    TweetResponseDTO getTweet(@PathVariable("id") UUID id) {
        Tweet tweet = tweetService.getTweet(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return conversionService.convert(tweet, TweetResponseDTO.class);
    }


    @PostMapping(path = "tweets")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "tweet created"),
            @ApiResponse(responseCode = "400", description = "can not create tweet")
    })
    TweetResponseDTO createTweet(@RequestBody TweetRequestDTO request) {

        Tweet mappedRequest = conversionService.convert(request, Tweet.class);
        Tweet erstellterTweet = tweetService.addTweet(mappedRequest);
        return conversionService.convert(erstellterTweet, TweetResponseDTO.class);

    }

    @DeleteMapping(path = "tweets/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "tweet deleted"),
            @ApiResponse(responseCode = "404", description = "no tweet for the id")
    })
    void deleteOneTweet(@PathVariable("id") UUID id) {
        tweetService.deleteTweet(id);
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "tweets/{id}")
    TweetResponseDTO updateTweet(@PathVariable("id") UUID id,
                                 @RequestBody TweetRequestDTO request) {
        Tweet mappedRequest = conversionService.convert(request, Tweet.class);

        Tweet erstellteTweet = tweetService.updateTweet(mappedRequest);
        return conversionService.convert(erstellteTweet, TweetResponseDTO.class);
    }


}

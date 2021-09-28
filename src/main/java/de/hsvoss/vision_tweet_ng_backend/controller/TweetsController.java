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

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;
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

    @GetMapping("tweets/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "the tweet"),
            @ApiResponse(responseCode = "404", description = "no tweet for the id")
    })
    TweetResponseDTO getTweet(@PathVariable("id") UUID id) {
        Optional<Tweet> tweet = tweetService.getTweet(id);
        if (!tweet.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            return conversionService.convert(tweet, TweetResponseDTO.class);
        }

    }


    @PostMapping(path = "tweets")
    TweetResponseDTO createTweet(@RequestBody TweetRequestDTO request) {
        Tweet mappedRequest = conversionService.convert(request, Tweet.class);

        Tweet erstellteTweet = tweetService.addTweet(mappedRequest);
        return conversionService.convert(erstellteTweet, TweetResponseDTO.class);

    }

    @DeleteMapping(path = "tweets/{id}")
    void deleteOneTweet(@PathParam("id") UUID id) {
        tweetService.deleteTweet(id);
    }

    @PutMapping(path = "tweets/{id}")
    TweetResponseDTO updateTweet(@PathParam("id") UUID id,
                                 @RequestBody TweetRequestDTO request) {
        Tweet mappedRequest = conversionService.convert(request, Tweet.class);

        Tweet erstellteTweet = tweetService.updateTweet(mappedRequest);
        return conversionService.convert(erstellteTweet, TweetResponseDTO.class);
    }


}

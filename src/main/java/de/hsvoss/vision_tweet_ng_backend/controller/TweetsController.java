package de.hsvoss.vision_tweet_ng_backend.controller;

import de.hsvoss.vision_tweet_ng_backend.apimodel.TweetResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class TweetsController {
//    https://vision-tweet-ng-backend.herokuapp.com/
//    https://docs.microsoft.com/de-de/azure/architecture/best-practices/api-design

    @GetMapping(path = "/sayhello")
    String sayHello() {
        return "Hallo Welt!!!";
    }

    @GetMapping(path = "tweets")
    List<TweetResponseDTO> getAllTweets(){

        TweetResponseDTO tweetResponseDTO = new TweetResponseDTO();
        tweetResponseDTO.setMessage("Hallo Welt 2");
        return List.of(tweetResponseDTO);
    }

}

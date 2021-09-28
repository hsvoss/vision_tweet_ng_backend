package de.hsvoss.vision_tweet_ng_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TweetsController {
//    https://vision-tweet-ng-backend.herokuapp.com/

    @GetMapping(path = "/sayhello")
    String sayHello() {
        return "Hallo Welt!!!";
    }

}

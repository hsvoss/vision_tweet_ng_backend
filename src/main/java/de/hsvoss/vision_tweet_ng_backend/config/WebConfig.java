package de.hsvoss.vision_tweet_ng_backend.config;

import de.hsvoss.vision_tweet_ng_backend.converter.DtoToTweet;
import de.hsvoss.vision_tweet_ng_backend.converter.TweetToDto;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new DtoToTweet());
        registry.addConverter(new TweetToDto());
    }
}


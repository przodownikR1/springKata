package pl.java.scalatech.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import pl.java.scalatech.domain.User;

/**
 * @author przodownik
 * Module name :    springKata
 * Creating time :  26 maj 2014
 */
@Profile("second")
@Configuration
public class SecondConf {

    @Bean
    public User getUser(){
        return new User("przodownikB","123b");
    }
}

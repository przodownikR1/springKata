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
@Profile("first")
@Configuration
public class FirstConf {
    
    @Bean
    public User getUser() {
        return new User("przodownik", "123a");
    }

}

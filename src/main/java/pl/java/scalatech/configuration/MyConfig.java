package pl.java.scalatech.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @author Sławomir Borowiec
 *         Module name : spring4features
 *         Creating time : 3 kwi 2014 23:59:28
 */
@Configuration
public class MyConfig {
    @Autowired
    private Environment env;

    @Bean
    public String createValue() {
        if (env.getProperty("user.country").equals("PL")) { return "przodownik"; }
        return "foreign";
    }
}

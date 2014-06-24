package pl.java.scalatech.test.lifecycle;

import java.util.Properties;

import lombok.extern.slf4j.Slf4j;

import org.fest.assertions.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.java.scalatech.lifecycle.CarConfig;

/**
 * @author przodownik
 * Module name :    springKata
 * Creating time :  28 maj 2014
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:contextLoaderTest1.xml"})
@Slf4j
public class BootstrapContextTest {
    @Autowired
    private CarConfig carConfig;
    
    @Value("#{ systemProperties }")
    private Properties systemProperties;
    
    @Value("#{ systemProperties['user.home'] }")
    private String userHome;
    
  
    @Test
    public void shouldContextLoad(){
        Assertions.assertThat(carConfig).isInstanceOf(CarConfig.class).isNotNull();
    }
    
    @Test
    public void shouldSystemPropertiesLoad(){
         log.info("+++  systemProperties {}",systemProperties );
         Assertions.assertThat(userHome).isNotEmpty();
    }
}

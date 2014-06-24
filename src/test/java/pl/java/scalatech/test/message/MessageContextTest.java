package pl.java.scalatech.test.message;

import lombok.extern.slf4j.Slf4j;

import org.fest.assertions.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.java.scalatech.message.Singer;

/**
 * @author przodownik
 * Module name :    springKata
 * Creating time :  28 maj 2014
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:messageContext.xml" })
@Slf4j
public class MessageContextTest {
    @Autowired
    private Singer singer;
    
    @Test
    public void shouldMessageLoad() {
        Assertions.assertThat(true);
    }
    @Test
    public void shouldSingerSing(){
        log.info("####   song title :  {} ",singer.singSong("metallica.master_of_puppets",new String [] {"=> slawek" , "favourite song"}));
    }
}

package pl.java.scalatech.test.lifecycle;

import org.fest.assertions.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author przodownik
 * Module name :    springKata
 * Creating time :  28 maj 2014
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:init_destroy.xml"})
public class InitDestroyTest {
    @Test
    public void shouldInitDestroyMethodInvoke(){
        Assertions.assertThat(true);
    }

}

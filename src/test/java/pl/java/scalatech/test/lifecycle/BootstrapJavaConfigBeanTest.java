package pl.java.scalatech.test.lifecycle;

import org.fest.assertions.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.java.scalatech.lifecycle.CarJavaConfig;
import pl.java.scalatech.lifecycle.handler.BeanHandlerProcessor;
import pl.java.scalatech.lifecycle.handler.ResourceLoaderHandler;

/**
 * @author przodownik
 * Module name :    springKata
 * Creating time :  28 maj 2014
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { CarJavaConfig.class,ResourceLoaderHandler.class,BeanHandlerProcessor.class})
public class BootstrapJavaConfigBeanTest {

    @Test
    public void shouldBootstrapLoad(){
        Assertions.assertThat(true);
    }
}

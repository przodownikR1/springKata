package pl.java.scalatech.test.lifecycle;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.java.scalatech.lifecycle.Car;
import pl.java.scalatech.lifecycle.CarConfig;
import pl.java.scalatech.lifecycle.handler.ResourceLoaderHandler;

/**
 * @author przodownik
 * Module name :    springKata
 * Creating time :  28 maj 2014
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { Car.class , CarConfig.class, ResourceLoaderHandler.class})
public class LifeCycleBeanTest {
    @Test
    public void shouldBeanBootstrap(){
        
    }
}

package pl.java.scalatech.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import pl.java.scalatech.lifecycle.handler.ResourceAwareHandler;

/**
 * @author przodownik
 * Module name :    springKata
 * Creating time :  28 maj 2014
 */
public class CarJavaConfig {
    
    @Bean(destroyMethod="myDestroyMethod",initMethod="myInitMethod")
    @Scope(value="singleton")
    public Car car(){
        return new Car();
    }
    
    @Bean(initMethod="showFileContent")
    public ResourceAwareHandler resourceAwareHandler(){
        return new ResourceAwareHandler();
    }
    
    
}

package pl.java.scalatech.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;

/**
 * @author przodownik
 * Module name :    springKata
 * Creating time :  28 maj 2014
 */
@Slf4j
@Component
public class CarConfig {

    @PreDestroy
    public void destroy() throws Exception {
         log.info("++++    destroyBean @@ {}",this.getClass().getSimpleName());
        
    }

    @PostConstruct
    public void init() throws Exception {
        log.info("+++    afterPropertiesBean @@  -> init {}",this.getClass().getSimpleName());
        
    } 
    
}

package pl.java.scalatech.lifecycle.handler;

import lombok.extern.slf4j.Slf4j;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
/**
 * @author przodownik
 * Module name :    springKata
 * Creating time :  28 maj 2014
 */
@Slf4j
@Component
public class ResourceLoaderHandler implements ResourceLoaderAware{

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        log.info("++++  resourceLoaderHander :  {} ", resourceLoader);
    }

}

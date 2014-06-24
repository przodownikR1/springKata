package pl.java.scalatech.lifecycle.handler;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author przodownik
 *         Module name : springKata
 *         Creating time : 28 maj 2014
 */
@Slf4j
@Component
public class BeanHandlerProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("####       postProcessBeforeInitialization   bean :   {}   name :  {}", bean, beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("####       postProcessAfterInitialization   bean :   {}   name :  {}", bean, beanName);
        return bean;
    }

}

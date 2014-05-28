package pl.java.scalatech.lifecycle;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author przodownik
 *         Module name : springKata
 *         Creating time : 28 maj 2014
 */
@Slf4j
@Component
public class Car implements InitializingBean, DisposableBean, BeanNameAware,BeanFactoryAware {

    @Override
    public void destroy() throws Exception {
        log.info("++++    destroyBean  {}", this.getClass().getSimpleName());

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("+++    afterPropertiesBean  {}", this.getClass().getSimpleName());

    }

    @Override
    public void setBeanName(String name) {
        log.info("+++    the name of the bean is  {}", name);
        
    }

    public void myInitMethod() {
        log.info("+++    myInitMethod  {}", this.getClass().getSimpleName());
    }

    public void myDestroyMethod() {
        log.info("+++    myDestroyMethod  {}", this.getClass().getSimpleName());
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

        
    }

}

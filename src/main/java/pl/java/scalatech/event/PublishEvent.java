package pl.java.scalatech.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * @author przodownik
 * Module name :    springKata
 * Creating time :  28 maj 2014
 */
@Component
public class PublishEvent implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;

    }

    public void sendEvent() {

        MyEvent event = new MyEvent(this, "yamahar1", 2);
        applicationEventPublisher.publishEvent(event);
    }
}

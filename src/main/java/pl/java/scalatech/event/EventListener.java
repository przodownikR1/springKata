package pl.java.scalatech.event;

import lombok.extern.slf4j.Slf4j;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class EventListener implements ApplicationListener<MyEvent> {

    @Override
    public void onApplicationEvent(MyEvent event) {
           log.info("+++  eventListener - > {}",event);
        
    }

}

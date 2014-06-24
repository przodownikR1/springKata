package pl.java.scalatech.test.event;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.java.scalatech.event.EventListener;
import pl.java.scalatech.event.PublishEvent;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { EventListener.class,PublishEvent.class})
public class EventTest {
    @Autowired
    private PublishEvent publishEvent;
    
    @Test
    public void shouldListenEvent(){
        publishEvent.sendEvent();
    }
}

package pl.java.scalatech.jms;

import javax.jms.Message;
import javax.jms.MessageListener;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author przodownik
 *         Module name : jmsSpringKata
 *         Creating time : 10:22:23 PM
 */
@Transactional
@Slf4j
public class QueueReceiver implements MessageListener {

    @Autowired 
    private Counter counter;
    
    @Override
    public void onMessage(Message message) {
        log.info("+++   MDB  ----->  receive a message : {}", message);
        counter.getCountMessage().getAndIncrement();
    }

}

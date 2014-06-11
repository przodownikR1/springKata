package pl.java.scalatech.jms;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * @author przodownik
 *         Module name : jmsSpringKata
 *         Creating time : 10:22:27 PM
 */
@Component
@Slf4j
public class Producer {
    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessage(String destination, String message) {
        log.info("message send {} ", message);
        jmsTemplate.convertAndSend(destination, message);

    }
}

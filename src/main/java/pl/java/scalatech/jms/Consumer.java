package pl.java.scalatech.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * @author przodownik
 *         Module name : jmsSpringKata
 *         Creating time : 10:21:07 PM
 */
@Component
@Slf4j
public class Consumer {

    @Autowired
    private JmsTemplate jmsTemplate;

    public String receiveMessage(String destination) throws JMSException {
        TextMessage message = (TextMessage) jmsTemplate.receive(destination);
        log.info("Consumer ------------- > message receive {} : ", message);
        
        return message.getText();
        
    }

}

package pl.java.scalatech.jms;

import java.util.HashMap;
import java.util.Map;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessagePostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author przodownik
 *         Module name : jmsSpringKata
 *         Creating time : 10:23:43 PM
 */
@Component
public class SendingMapMessage {

    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    @Qualifier("queueA")
    private Queue queueA;

    public void sendWithConversion() {
        Map<String, Object> map = new HashMap<>();
        map.put("Name", "Mark");
        map.put("Age", new Integer(47));
        jmsTemplate.convertAndSend(queueA, map, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws JMSException {
                message.setIntProperty("AccountID", 1234);
                message.setJMSCorrelationID("123-00001");
                return message;
            }
        });
    }
}

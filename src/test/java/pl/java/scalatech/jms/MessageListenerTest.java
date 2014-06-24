package pl.java.scalatech.jms;

import java.util.Queue;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:listener_reply.xml" })
@Slf4j
public class MessageListenerTest {
    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private Destination inbox;
    @Test
    public void shouldReply(){
        jmsTemplate.send(new MessageCreator() {
            
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage message = session.createTextMessage("spring test message ");
                message.setIntProperty("MESSAGE_SPRING", 1);
                message.setJMSPriority(6);
                message.setJMSCorrelationID("return_");
                
                message.setJMSReplyTo(inbox);
                return message;
            }
        });
        log.info("+++ should reply");
    }
    
}

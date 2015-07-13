package pl.java.scalatech.jms;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.listener.SessionAwareMessageListener;
/**
 * @author Sławomir Borowiec 
 * Module name : jmsSpringKata
 * Creating time :  24 cze 2014 13:09:34
 
 */
@Slf4j
public class AwareMessageListener implements SessionAwareMessageListener<Message>{

    @Autowired
    private Destination queueA;
    
    @Override
    public void onMessage(Message message, Session session) throws JMSException {
       log.info("+++       consume message  {}" ,((TextMessage)message).getText());
      
    }

}

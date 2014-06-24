package pl.java.scalatech.jms;

import java.util.OptionalLong;
import java.util.Random;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import lombok.extern.slf4j.Slf4j;

import org.neo4j.cypher.internal.compiler.v2_0.functions.Rand;
import org.springframework.jms.listener.SessionAwareMessageListener;
/**
 * @author Sławomir Borowiec 
 * Module name : jmsSpringKata
 * Creating time :  24 cze 2014 13:09:34
 
 */
@Slf4j
public class AwareMessageListener implements SessionAwareMessageListener<Message>{

    @Override
    public void onMessage(Message message, Session session) throws JMSException {
       log.info("+++       consume message  {}" ,((TextMessage)message).getText());
        TextMessage newMessage = session.createTextMessage("reply to you");
        OptionalLong rand = new Random().longs().findFirst();
        newMessage.setJMSMessageID("_reply.."+rand.getAsLong());
        newMessage.setJMSCorrelationID("reply_");
        MessageProducer mp = session.createProducer(message.getJMSReplyTo());
        log.info("+++      send reply....");
        mp.send(newMessage);
    }

}

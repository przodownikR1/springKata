package pl.java.scalatech.jms;

import lombok.extern.slf4j.Slf4j;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Sławomir Borowiec
 *         Module name : jmsSpringKata
 *         Creating time : 9 cze 2014 12:21:57
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@Slf4j
@ActiveProfiles(value = { "normal", "mdb" })
public class MDBTest {

    private final static String DESTINATION = "queueA";
    private final static String EXAMPLE_MSQ = "hello amq";
    @Autowired
    private Counter counter;

    @Autowired
    private Producer producer;

    @Test
    @Ignore
    public void shouldMDBGetMessages() throws InterruptedException {
        for (int i = 0; i < 200; i++) {
            producer.sendMessage(DESTINATION, EXAMPLE_MSQ);
        }
    }

    @Test
    public void shouldReadMessages() throws InterruptedException {
        Thread.sleep(1000);
        System.err.println(counter.getCountMessage().get());
        log.info("++++++++++   count processing  messages number {} ", counter.getCountMessage().get());
    }
}

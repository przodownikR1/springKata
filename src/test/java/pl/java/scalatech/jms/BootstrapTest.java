package pl.java.scalatech.jms;

import java.util.Arrays;

import javax.jms.JMSException;

import lombok.extern.slf4j.Slf4j;

import org.fest.assertions.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@Slf4j
@ActiveProfiles(value = "normal")
public class BootstrapTest {
    
    private final static String DESTINATION = "queueA";
    private final static String EXAMPLE_MSQ = "hello amq";
    @Autowired
    private Consumer consumer;
    @Autowired
    private Producer producer;

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void shouldBoostrapWork() throws InterruptedException {
        log.info("+++  {}", Arrays.toString(applicationContext.getBeanDefinitionNames()));
      
    }

    @Test
    public void shouldProductMessage() {
        producer.sendMessage(DESTINATION,EXAMPLE_MSQ);
    }

    @Test
    public void shouldConsumeMessage() throws JMSException {
        Assertions.assertThat(consumer.receiveMessage(DESTINATION)).isEqualTo(EXAMPLE_MSQ);
        //log.info("Message   {}",message);
    }
}

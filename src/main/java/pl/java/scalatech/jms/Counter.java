package pl.java.scalatech.jms;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Component;

import lombok.Getter;

/**
 * @author Sławomir Borowiec 
 * Module name : jmsSpringKata
 * Creating time :  9 cze 2014 12:56:39
 
 */
@Component
public class Counter {
  @Getter  
  private AtomicInteger countMessage = new AtomicInteger();
}

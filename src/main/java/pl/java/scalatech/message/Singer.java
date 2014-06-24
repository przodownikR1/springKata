package pl.java.scalatech.message;

import java.util.Locale;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

/**
 * @author przodownik
 *         Module name : springKata
 *         Creating time : 28 maj 2014
 */
@Component
@Slf4j
public class Singer  implements MessageSourceAware {
    @Autowired
    private MessageSource messageSource;

    @Autowired
    private Locale locale;

    
      @Override
      public void setMessageSource(MessageSource messageSource) {
      this.messageSource = messageSource;
      log.info("+++  =>  MessageSourceAware {}",messageSource);
      }
     

    public String singSong(String songName, String ... vars) {
        return messageSource.getMessage(songName, vars, locale);
    }

}

package pl.java.scalatech.concurrent;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author przodownik
 * Module name :    springKata
 * Creating time :  28 maj 2014
 */
@Slf4j
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgileBean implements Runnable {
    private String name;
    public void run() {
        try {
            log.info("Agile {} bean working ................... ",name );
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            log.error("{}", e);
        }

    }

}

package pl.java.scalatech.event;

import lombok.Data;

import org.springframework.context.ApplicationEvent;

/**
 * @author przodownik
 * Module name :    springKata
 * Creating time :  28 maj 2014
 */
@Data
public class MyEvent extends ApplicationEvent {

    private String name;
    private int count;

    public MyEvent(Object source, String name, int count) {
        super(source);
        this.count = count;
        this.name = name;

    }

    /**
     * 
     */
    private static final long serialVersionUID = -4784467434706597849L;

}

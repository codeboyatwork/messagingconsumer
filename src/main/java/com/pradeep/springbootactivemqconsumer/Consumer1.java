package com.pradeep.springbootactivemqconsumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer1 extends Consumer{

    @JmsListener(destination = "messaging.preprocessor")
    public void listener(String message) {
    	super.listener(message);
        System.out.println("  Consumer 1 <=====> Received Message: " + message);
    }
}

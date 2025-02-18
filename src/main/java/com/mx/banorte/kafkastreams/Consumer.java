package com.mx.banorte.kafkastreams;


import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class Consumer {

     @Incoming("prod-topic")
     public void receive(String incomingMessage) {
         System.out.print("Mensaje consumido " + incomingMessage);
     }


}

package com.mx.banorte.util;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;


@ApplicationScoped
public class MessageProducer {

    @Inject
    @Channel("dev-topic") // @CHANEL indica el topico donde se enviaran los mensajes
    Emitter<String> requestEmitter;
    public void send(String incomingMessage) {
        requestEmitter.send(incomingMessage);

    }
    
}

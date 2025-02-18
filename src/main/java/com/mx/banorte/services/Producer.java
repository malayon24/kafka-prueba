package com.mx.banorte.services;

import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mx.banorte.model.Message;
import com.mx.banorte.util.MessageProducer;


@Path("/message")
public class Producer {

    @Inject
    MessageProducer messageProducer;    

    @POST
    @Path("/producer")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String createRequest(String body) throws Exception {

        Jsonb jsonBody = JsonbBuilder.create();
        try {

            Message me = jsonBody.fromJson(body, Message.class);

            String message = me.getMensaje();
            int replicas = me.getReplicas();
 
            for (int i = 0; i < replicas; i++) {
                messageProducer.send(body);
                
            }

            return message;

        } catch (Exception e) {
            return "Error en servicio Producer";

        } finally {
            jsonBody.close();
        }

    }

}




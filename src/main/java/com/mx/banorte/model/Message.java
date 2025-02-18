package com.mx.banorte.model;

import javax.json.bind.annotation.JsonbProperty;

public class Message {

    @JsonbProperty("Mensaje")
    private String mensaje;

    @JsonbProperty("Replicas")   
    private int replicas;



    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getReplicas() {
        return replicas;
    }

    public void setReplicas(int replicas) {
        this.replicas = replicas;
    }

        



    

    
    
}

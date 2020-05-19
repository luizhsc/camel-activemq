package com.activemq.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @JmsListener(destination = "everis-obj")
    public void consumerEverisObj(String mensagem){
        System.out.println("Mensagem recebida (everis-obj) -> "+mensagem);
    }
    
    @JmsListener(destination = "everis-teste")
    public void consumerEverisTeste(String mensagem){
        System.out.println("Mensagem recebida (everis-teste) -> "+mensagem);
    }

}
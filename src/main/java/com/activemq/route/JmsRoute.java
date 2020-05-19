package com.activemq.route;

import java.time.LocalDateTime;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class JmsRoute extends RouteBuilder{
	
	@Override
	public void configure() throws Exception {
		from("timer:everis?period=1000")
			.setBody(simple("Mensagem:  ${date:now:dd-MM-yyyy HH:mm:ss}"))
				.to("jms:queue:everis-teste");
		
		from("timer:everis2?period=4000")
			.process(new Processor() {
	            @Override
	            public void process(Exchange exchange) throws Exception {
	              exchange.getIn().setBody("Teste body: minuto: " + LocalDateTime.now().getMinute() + " segundo:" + LocalDateTime.now().getSecond());
	            }
	        })
			.to("jms:queue:everis-obj");
	}
}

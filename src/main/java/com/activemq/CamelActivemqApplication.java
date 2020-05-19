package com.activemq;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.activemq.route.JmsRoute;
import com.activemq.util.UtilApp;

@SpringBootApplication
public class CamelActivemqApplication {

	@Autowired  
	UtilApp utilApp;
	
	public static void main(String[] args) {
		SpringApplication.run(CamelActivemqApplication.class, args);
	}
	
	@PostConstruct
	private void init() throws Exception {
		List<Object> listaRoutes = new ArrayList<>();
		listaRoutes.add(new JmsRoute());
		utilApp.runContextCamel(listaRoutes,0,true);
		
	}  
}
package com.sahildiwan.restful.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;


@SpringBootApplication
public class RestfulJpaCrudApplication implements CommandLineRunner { 
	
	static Logger log=LoggerFactory.getLogger(RestfulJpaCrudApplication.class);
	
	public void run(String... args) throws Exception {
		//Start-UP Tasks
		 log.info("MS - Launched.... ");
		} 

	
	public static void main(String[] args) {
		log.info("MS - Begin "); 
		SpringApplication.run(RestfulJpaCrudApplication.class, args);
		log.info("MS - End "); 
	}


}

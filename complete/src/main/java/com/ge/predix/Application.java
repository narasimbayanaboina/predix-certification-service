package com.ge.predix;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.ge.predix.certification.domain.Certattemp;
import com.ge.predix.certification.domain.Certtestitemactivity;
import com.ge.predix.certification.domain.Model;
import com.ge.predix.certification.repositories.CertModelRepository;
import com.ge.predix.certification.repositories.CertattempRepository;
import com.ge.predix.certification.repositories.CerttestitemactivityRepository;
@Configuration
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	@Autowired
	private DataSource dataSource;

	public void run(String... args) throws Exception {
		org.apache.tomcat.jdbc.pool.DataSource tomcat = (org.apache.tomcat.jdbc.pool.DataSource) dataSource;
		System.err.println(tomcat.getDriverClassName() + ", " + tomcat.getUrl());
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	
	@Bean
	public CommandLineRunner demo(CertModelRepository repository) {
		return (args) -> {

			// fetch all customers
			log.debug("Model found with findAll():");
		
			log.debug("-------------------------------");
			for (Model customer : repository.findAll()) {
			//	System.out.println(customer.toString());
				log.debug("CertModel:"+customer.toString());
				//System.out.println("attempts:"+customer.getCertattemps()) ;
			}
			log.debug("-------------------------------");

		};
	}
	
	@Bean
	public CommandLineRunner demo1(CertattempRepository repository) {
		return (args) -> {

			// fetch all customers
			log.debug("Certattemp found with findAll():");
			log.debug("-------------------------------");
			for (Certattemp customer : repository.findAll()) {
			//	System.out.println(customer.toString());
				log.debug("Certattemp:"+customer.toString());
				log.debug("models for Certattemp :"+customer.getId()+ " "+customer.getModel()) ;
		
			}
			log.debug("-------------------------------");

		};
	}
	
	@Bean
	public CommandLineRunner demo2(CerttestitemactivityRepository repository) {
		return (args) -> {

			// fetch all customers
			log.info("Certtestitemactivity found with findAll():");
			log.info("-------------------------------");
			for (Certtestitemactivity customer : repository.findAll()) {
			//	System.out.println(customer.toString());
				log.info("Certtestitemactivity:"+customer.toString());
				log.info("models for Certattemp :"+customer.getCertteststep().getStepname()+ " ") ;
		
			}
			log.info("-------------------------------");

		};
	}
	
	@Bean
	public CommandLineRunner demo3(CertattempRepository repository) {
		return (args) -> {

			// fetch all customers
			log.info("CertattempRepository found with findAll():");
			log.info("-------------------------------");
			for (Certattemp customer : repository.findByModelid(2)) {
			//	System.out.println(customer.toString());
				log.info("CertattempRepository:"+customer.toString());
			
		
			}
			log.info("-------------------------------");

		};
	}
	
	
	
	

}

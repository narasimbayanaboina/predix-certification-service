package com.ge.predix.certification.config;

import javax.sql.DataSource;

import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
@Profile("cloud")
public class CloudConfig extends AbstractCloudConfig {

	@Bean (destroyMethod= "close")
    public DataSource dataSource() {
		System.out.println("********Loading cloud profile*******");
        return connectionFactory().dataSource();
    } 
	


}
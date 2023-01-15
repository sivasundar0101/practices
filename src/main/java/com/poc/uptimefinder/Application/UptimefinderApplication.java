package com.poc.uptimefinder.Application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import com.poc.uptimefinder.controller.Uptimcontroller;
import com.poc.uptimefinder.model.URLentity;

//@ComponentScan("com.poc.uptimefinder.controller")
@EntityScan(basePackageClasses = URLentity.class,basePackages = {"com.poc.uptimefinder.model"})


//@ComponentScan("com.poc.uptimefinder.services" )
//
//@EnableJpaRepositories ("com.poc.uptimefinder.repository")
@ComponentScan(basePackages="com.poc.uptimefinder")

@EnableJpaRepositories("com.poc.uptimefinder.repository")
@SpringBootApplication
public class UptimefinderApplication {
	public static void main(String[] args) {
		SpringApplication.run(UptimefinderApplication.class, args);
	}

}

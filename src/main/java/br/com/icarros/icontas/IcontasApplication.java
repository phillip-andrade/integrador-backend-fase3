package br.com.icarros.icontas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableAutoConfiguration(exclude = {
//        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
//        org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class})
@SpringBootApplication
public class IcontasApplication {

	public static void main(String[] args) {
		SpringApplication.run(IcontasApplication.class, args);
	}

}
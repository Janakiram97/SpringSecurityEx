package com.example.SpringSecuritysection4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
/*@EnableJpaRepositories("com.example.SpringSecuritysection4.repository")
//if repository present outside of SpringBootApplication and to scan repositories we need to use this annotation
@EntityScan("com.example.SpringSecuritysection4.model") //if entity present outside of SpringBootApplication and to scan entities*/
public class EazyBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EazyBackendApplication.class, args);
		System.out.println("Spring Security Application started...");
	}

}

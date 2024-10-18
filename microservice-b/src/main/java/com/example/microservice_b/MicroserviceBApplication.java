package com.example.microservice_b;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class MicroserviceBApplication {

  public static void main(String[] args) {
    SpringApplication.run(MicroserviceBApplication.class, args);
  }
}



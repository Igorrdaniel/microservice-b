package com.example.microservice_b.domain.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
public class ServiceBController {

  private final DiscoveryClient discoveryClient;
  private final RestClient restClient;

  public ServiceBController(DiscoveryClient discoveryClient, RestClient.Builder restClientBuilder) {
    this.discoveryClient = discoveryClient;
    restClient = restClientBuilder.build();
  }

  @GetMapping("/hello-eureka")
  public String helloWorld() {
    ServiceInstance serviceInstance = discoveryClient.getInstances("microservice-a").getFirst();

    return restClient
        .get()
        .uri(serviceInstance.getUri() + "/hello-world")
        .retrieve()
        .body(String.class);
  }
}

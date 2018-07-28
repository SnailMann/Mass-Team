package com.hailion.mass.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired  
    private LoadBalancerClient loadBalancerClient;  

    @GetMapping("/booking/order/{money}")
    public String placeAnOrder(@PathVariable("money") Integer in_iMoney) {
    	this.loadBalancerClient.choose("booking");
        return restTemplate.getForEntity("http://booking/booking/order/{money}", String.class,in_iMoney).getBody();
    }

    @GetMapping("/booking/order")
    public String placeAnOrder() {
        this.loadBalancerClient.choose("booking");
        return restTemplate.getForEntity("http://booking/booking/order", String.class).getBody();
    }


    
}
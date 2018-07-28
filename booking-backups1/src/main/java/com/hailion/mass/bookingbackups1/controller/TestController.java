package com.hailion.mass.bookingbackups1.controller;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class TestController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @GetMapping("/booking/order/{money}")
    public String placeAnOrder(@PathVariable("money") Integer in_money){
        RestTemplate restTemplate=new RestTemplate();
        return restTemplate.getForObject("http://localhost:8082//payment/pay/{in_money}", String.class,in_money);
    }


    @GetMapping("/booking/order")
    public String placeAnOrder(){
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/booking/test host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", parameter:" + null);
        return "Booking : place an order now "+ "\nPort: "+instance.getPort();
    }
}

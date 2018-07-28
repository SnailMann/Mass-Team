package com.hailion.mass.payment.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class TestController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @GetMapping("/payment/pay/{money}")
    public String payMoney(@PathVariable("money") Integer in_iMoney){
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/payment/pay host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", parameter:" + in_iMoney);
        return "Payment : pay money now "+ "\nPort:"+instance.getPort();
    }
}

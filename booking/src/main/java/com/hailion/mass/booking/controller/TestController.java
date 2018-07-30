package com.hailion.mass.booking.controller;


import com.hailion.mass.booking.Service.OrderService;
import com.hailion.mass.booking.entity.Order;
import org.apache.log4j.Logger;
import org.apache.tomcat.jni.Local;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@RestController
public class TestController {


    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;
    @Autowired
    private OrderService orderService;

    @GetMapping("/booking/order/{money}")
    public String placeAnOrder(@PathVariable("money") Integer in_money) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:8082//payment/pay/{in_money}", String.class, in_money);
    }


    @GetMapping("/booking/order")
    public String placeAnOrder() {
        ServiceInstance instance = client.getLocalServiceInstance();
        Order order = new Order();
        order.setOrderId("20180730");
        order.setUserId("1001");
        order.setStartTime(LocalDateTime.now());
        order.setEndTime(LocalDateTime.now().plusHours(2));
        order.setExpectTime(LocalDateTime.now().plusHours(2));
        order.setOrderStatus(1);
        order.setOrderStatus(1);
        order.setScheme(1);
        order.setWeight(90);
        order.setQuantity(2);
        order.setTotalPrice(BigDecimal.valueOf(90));


        orderService.insertAnOrder(order);
        return "Booking : place an order now " + "\nPort: " + instance.getPort();
    }

    @GetMapping("/booking/delete/{orderId}")
    public String deleteAnOrder(@PathVariable String orderId){
        orderService.deleteAnOrderById(orderId);
        return "delete order of " + orderId;
    }


}

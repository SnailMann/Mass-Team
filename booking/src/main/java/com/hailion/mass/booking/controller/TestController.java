package com.hailion.mass.booking.controller;


import com.hailion.mass.booking.service.OrderService;
import com.hailion.mass.booking.entity.OrderDO;
import com.hailion.mass.booking.service.client.PaymentClient;
import org.apache.log4j.Logger;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@RestController
public class TestController {


    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;
    @Autowired
    private OrderService orderService;
    @Autowired
    private PaymentClient paymentClient;

    @GetMapping("/booking/order/{money}")
    public String placeAnOrder(@PathVariable("money") Integer in_money) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:8082//payment/pay/{in_money}", String.class, in_money);

       /* return paymentClient.payMoney(in_money);*/
    }


    @GetMapping("/booking/order")
    public String placeAnOrder() {
        ServiceInstance instance = client.getLocalServiceInstance();
        OrderDO order = new OrderDO();
        order.setOrderId("20180730");
        order.setUserId("1001");
        order.setStartTime(LocalDateTime.now());
        order.setCreateTime(LocalDateTime.now().plusHours(2));
        order.setExpectTime(LocalDateTime.now().plusHours(2));
        order.setOrderStatus(1);
        order.setOrderType(1);
        order.setOrderStatus(1);
        order.setScheme(1);
        order.setWeight(90);
        order.setQuantity(2);
        order.setTotalPrice(BigDecimal.valueOf(90));


        orderService.insertOrder(order);
        return "Booking : place an order now " + "\nPort: " + instance.getPort();
    }

    @GetMapping("/booking/delete/{orderId}")
    public String deleteAnOrder(@PathVariable String orderId){
        orderService.deleteOrderById(orderId);
        return "delete order of " + orderId;
    }

    @GetMapping("/booking/get/{orderId}")
    public OrderDO getOrderDO(@PathVariable String orderId){
        OrderDO orderDO = orderService.getOrderDOById(orderId);
        return orderDO;
    }

    @GetMapping("/booking/list")
    public List<OrderDO> listOrderDO(){
        List<OrderDO> orderDOList = orderService.listOrderDO();
        return orderDOList;
    }

    @GetMapping("/booking/test")
    public String test(){
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/booking/test host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", parameter:" + null);
        return "Booking test " + "\nPort: " + instance.getPort();
    }

}

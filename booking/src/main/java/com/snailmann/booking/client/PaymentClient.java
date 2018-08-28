package com.snailmann.booking.client;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient("payment")
public interface PaymentClient {

    @RequestMapping(value = "/payment/pay/{money}",method = RequestMethod.GET)
    String payMoney(@PathVariable("money") Integer in_iMoney);
}

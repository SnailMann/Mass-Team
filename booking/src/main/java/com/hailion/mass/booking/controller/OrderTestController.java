package com.hailion.mass.booking.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hailion.mass.booking.client.PaymentClient;
import com.hailion.mass.booking.entity.Order;
import com.hailion.mass.booking.entity.OrderDO;
import com.hailion.mass.booking.service.OrderService;


@Controller
public class OrderTestController {
	
    @Autowired
    private OrderService orderService;

    
   /**
    *  跳转到订单页面
    * @return
    */

	@RequestMapping("/booking/orderRequest")
	public String orderRequest() {
		return "insertOrder";
	}
	//添加订单
	@PostMapping("/booking/order")
    public String placeAnOrder(Order order) {
        orderService.insertOrder(order);
        return "redirect:/booking/list";
    }
	//查询订单
	@GetMapping("/booking/list")
    public String listOrder(HttpServletRequest request){
        ArrayList<Order> orderList = (ArrayList<Order>) orderService.listOrder();
        System.out.println(orderList);
       request.setAttribute("orderList", orderList);
        return "orderList";
    }
    //	取消订单
	@GetMapping("/booking/cancel")
    public String cancelOrder(Order order){
		orderService.updateOrder(order);
       return "redirect:/booking/list";
    }
	//删除订单
	 @GetMapping("/booking/delete")
	    public String deleteAnOrder(Order order){
	        orderService.deleteOrderById(order.getOrderId());
	        return "redirect:/booking/list";
	  }
	
}

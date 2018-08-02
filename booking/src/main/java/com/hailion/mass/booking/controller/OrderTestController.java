package com.hailion.mass.booking.controller;


import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.hailion.mass.booking.entity.Order;
import com.hailion.mass.booking.service.OrderService;


@Controller
public class OrderTestController {
	
    @Autowired
    private OrderService orderService;

    
   /**
    *  跳转到订单页面
    * @return
    */
	@GetMapping("/booking/orderRequest")
	public String orderRequest() {
		return "insertOrder";
	}
	//添加订单
	@PostMapping("/booking/order")
    public String placeAnOrder(Order order) {
        orderService.insertOrder(order);
        return "redirect:/booking/list";
    }

    /**
     * 查询订单
     * @param request
     * @return
     */
	@GetMapping("/booking/list")
    public String listOrder(HttpServletRequest request){
        ArrayList<Order> orderList = (ArrayList<Order>) orderService.listOrder();
        System.out.println(orderList);
        request.setAttribute("orderList", orderList);
        return "orderList";
    }

    /**
     * 取消订单
     * @param order
     * @return
     */
	@GetMapping("/booking/cancel")
    public String cancelOrder(Order order){
		orderService.updateOrder(order);
       return "redirect:/booking/list";
    }

    /**
     * 删除订单
     * @param order
     * @return
     */
	 @GetMapping("/booking/delete")
	    public String deleteAnOrder(Order order){
	        orderService.deleteOrderById(order.getOrderId());
	        return "redirect:/booking/list";
	  }
	
}

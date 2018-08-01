package com.hailion.mass.booking.service;


import com.hailion.mass.booking.entity.Order;
import com.hailion.mass.booking.entity.OrderDO;


import java.util.List;


public interface OrderService {

    public void insertOrder(Order order);
    public void deleteOrderById(String orderId);
    public Order getOrderById(String orderId);
    public List<Order> listOrder();
    public int updateOrder(Order order);

}

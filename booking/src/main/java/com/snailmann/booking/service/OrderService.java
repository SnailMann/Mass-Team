package com.snailmann.booking.service;



import java.util.List;

import com.snailmann.booking.entity.Order;


public interface OrderService {

    public void insertOrder(Order order);
    public void deleteOrderById(String orderId);
    public Order getOrderById(String orderId);
    public List<Order> listOrder();
    public int updateOrder(Order order);

}

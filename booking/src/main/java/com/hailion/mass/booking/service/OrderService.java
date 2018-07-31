package com.hailion.mass.booking.service;


import com.hailion.mass.booking.entity.OrderDO;

import java.util.List;


public interface OrderService {

    public void insertOrder(OrderDO order);
    public void deleteOrderById(String orderId);
    public OrderDO getOrderDOById(String orderId);
    public List<OrderDO> listOrderDO();

}

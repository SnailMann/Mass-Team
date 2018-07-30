package com.hailion.mass.booking.Service.impl;

import com.hailion.mass.booking.Service.OrderService;
import com.hailion.mass.booking.dao.OrderMapper;
import com.hailion.mass.booking.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Override
    public void insertAnOrder(Order order) {
        orderMapper.insertOrder(order);
    }

    @Override
    public void deleteAnOrderById(String orderId) {
        orderMapper.deleteOrderById(orderId);
    }
}

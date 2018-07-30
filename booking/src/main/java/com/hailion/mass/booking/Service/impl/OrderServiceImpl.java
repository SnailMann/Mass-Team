package com.hailion.mass.booking.Service.impl;

import com.hailion.mass.booking.Service.OrderService;
import com.hailion.mass.booking.dao.OrderMapper;
import com.hailion.mass.booking.entity.OrderDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Override
    public void insertOrder(OrderDO order) {
        orderMapper.insertOrder(order);
    }

    @Override
    public void deleteOrderById(String orderId) {
        orderMapper.deleteOrderById(orderId);
    }

    @Override
    public OrderDO getOrderDOById(String orderId) {
        return orderMapper.getOrder(orderId);

    }

    @Override
    public List<OrderDO> listOrderDO() {
        return orderMapper.listOrder();
    }
}

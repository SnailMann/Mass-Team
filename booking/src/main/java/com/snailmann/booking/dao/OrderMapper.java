package com.snailmann.booking.dao;



import com.snailmann.booking.entity.Order;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface OrderMapper {

    public void insertOrder(Order orderDO);
    public void deleteOrderById(String orderId);
    public Order getOrder(String orderId);
    public List<Order> listOrder();
    public int updateOrder(Order order);
}

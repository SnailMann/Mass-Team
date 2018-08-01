package com.hailion.mass.booking.dao;

import com.hailion.mass.booking.entity.Order;
import com.hailion.mass.booking.entity.OrderDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;



public interface OrderMapper {

    public void insertOrder(Order orderDO);
    public void deleteOrderById(String orderId);
    public Order getOrder(String orderId);
    public List<Order> listOrder();
    public int updateOrder(Order order);
}

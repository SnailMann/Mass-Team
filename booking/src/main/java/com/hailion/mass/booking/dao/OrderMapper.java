package com.hailion.mass.booking.dao;

import com.hailion.mass.booking.entity.OrderDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;



public interface OrderMapper {

    public void insertOrder(OrderDO orderDO);
    public void deleteOrderById(String orderId);
    public OrderDO getOrder(String orderId);
    public List<OrderDO> listOrder();
}

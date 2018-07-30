package com.hailion.mass.booking.dao;

import com.hailion.mass.booking.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;



public interface OrderMapper {

    public void insertOrder(Order order);
    public void deleteOrderById(String Id);
}

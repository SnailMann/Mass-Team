package com.hailion.mass.booking.Service;


import com.hailion.mass.booking.dao.OrderMapper;
import com.hailion.mass.booking.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface OrderService {

    public void insertAnOrder(Order order);
    public void deleteAnOrderById(String orderId);

}

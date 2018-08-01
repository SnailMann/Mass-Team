package com.hailion.mass.booking.service.impl;

import com.hailion.mass.booking.service.OrderService;
import com.hailion.mass.booking.dao.OrderMapper;
import com.hailion.mass.booking.entity.Order;
import com.hailion.mass.booking.entity.OrderDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;
    
    @Transactional(readOnly=false)
    @Override
    public void insertOrder(Order order) {
    	//生产随机订单，依旧有1%重复
    	int r1=(int)(Math.random()*(10));//产生2个0-9的随机数
    	int r2=(int)(Math.random()*(10));
    	long now = System.currentTimeMillis();//一个13位的时间戳
    	String paymentID =String.valueOf(r1)+String.valueOf(r2)+String.valueOf(now);// 订单ID
    	
    	order.setOrderId(paymentID);
        order.setUserId("1001");
        //默认0 未支付
        order.setOrderStatus(0);
        order.setScheme(1);
        orderMapper.insertOrder(order);
    }

    @Override
    public void deleteOrderById(String orderId) {
        orderMapper.deleteOrderById(orderId);
    }

    @Override
    public Order getOrderById(String orderId) {
        return orderMapper.getOrder(orderId);

    }

    @Override
    public List<Order> listOrder() {
        return orderMapper.listOrder();
    }

	@Override
	public int updateOrder(Order order) {
		// TODO Auto-generated method stub
		return orderMapper.updateOrder(order);
	}
}

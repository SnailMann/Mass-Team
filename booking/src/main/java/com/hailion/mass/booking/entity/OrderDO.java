package com.hailion.mass.booking.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.format.annotation.DateTimeFormat;

public class OrderDO {

    String orderId;
    String userId;
    LocalDateTime startTime;
    LocalDateTime createTime;
    LocalDateTime expectTime;
    Integer orderStatus;
    Integer orderType;
    Integer weight;
    Integer quantity;
    Integer scheme;
    BigDecimal totalPrice;

    public OrderDO() { }

    public OrderDO(String orderId, String userId, LocalDateTime startTime, LocalDateTime createTime, LocalDateTime expectTime, Integer orderStatus, Integer orderType, Integer weight, Integer quantity, Integer scheme, BigDecimal totalPrice) {
        this.orderId = orderId;
        this.userId = userId;
        this.startTime = startTime;
        this.createTime = createTime;
        this.expectTime = expectTime;
        this.orderStatus = orderStatus;
        this.orderType = orderType;
        this.weight = weight;
        this.quantity = quantity;
        this.scheme = scheme;
        this.totalPrice = totalPrice;
    }



    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getExpectTime() {
        return expectTime;
    }

    public void setExpectTime(LocalDateTime expectTime) {
        this.expectTime = expectTime;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getScheme() {
        return scheme;
    }

    public void setScheme(Integer scheme) {
        this.scheme = scheme;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDO order = (OrderDO) o;
        return Objects.equals(orderId, order.orderId) &&
                Objects.equals(userId, order.userId) &&
                Objects.equals(startTime, order.startTime) &&
                Objects.equals(createTime, order.createTime) &&
                Objects.equals(expectTime, order.expectTime) &&
                Objects.equals(orderStatus, order.orderStatus) &&
                Objects.equals(orderType, order.orderType) &&
                Objects.equals(weight, order.weight) &&
                Objects.equals(quantity, order.quantity) &&
                Objects.equals(scheme, order.scheme) &&
                Objects.equals(totalPrice, order.totalPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, userId, startTime, createTime, expectTime, orderStatus, orderType, weight, quantity, scheme, totalPrice);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", userId='" + userId + '\'' +
                ", startTime=" + startTime +
                ", createTime=" + createTime +
                ", expectTime=" + expectTime +
                ", orderStatus=" + orderStatus +
                ", orderType=" + orderType +
                ", weight=" + weight +
                ", quantity=" + quantity +
                ", scheme=" + scheme +
                ", totalPrice=" + totalPrice +
                '}';
    }
}

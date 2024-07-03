package org.skillovilla.level1;

public class Order {
    private final String orderId;
    private OrderStatus status;

    public Order(String orderId) {
        this.orderId = orderId;
        this.status = OrderStatus.PENDING;
    }

    public void updateStatus(OrderStatus newStatus) {
        this.status = newStatus;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public String getOrderId() {
        return orderId;
    }
}

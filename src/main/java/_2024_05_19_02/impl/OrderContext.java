package _20240519_02.impl;

import _20240519_02.BaseContext;
import _20240519_02.impl.Order;

public class OrderContext implements BaseContext {
    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}



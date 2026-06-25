package org.example.factories;

import org.example.models.*;
import org.example.strategies.PaymentStrategy;

import java.util.List;

public interface OrderFactory {
    Order createOrder(User user, Cart cart, Restaurant restaurant, List<MenuItem> menuItems
    , PaymentStrategy paymentStrategy,double totalcost,String orderType);
}

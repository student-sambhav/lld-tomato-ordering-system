package org.example;

import org.example.models.Order;
import org.example.models.Restaurant;
import org.example.models.User;
import org.example.strategies.UpiPaymentStrategy;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        TomatoApp tomato = new TomatoApp();

        // Simulate a user coming in (Happy Flow)
        User user = new User(101, "Aditya", "Delhi");
        System.out.println("User: " + user.getName() + " is active.");

        // User searches for restaurants by location
        List<Restaurant> restaurantList = tomato.searchRestaurants("Delhi");

        if (restaurantList.isEmpty()) {
            System.out.println("No restaurants found!");
            return;
        }

        System.out.println("Found Restaurants:");
        for (Restaurant restaurant : restaurantList) {
            System.out.println(" - " + restaurant.getName());
        }

        // User selects a restaurant
        tomato.selectRestaurant(user, restaurantList.get(0));
        System.out.println("Selected restaurant: " + restaurantList.get(0).getName());

        // User adds items to the cart
        tomato.addToCart(user, "P1");
        tomato.addToCart(user, "P2");

        tomato.printUserCart(user);

        // User checks out
        Order order = tomato.checkoutNow(
                user,
                "Delivery",
                new UpiPaymentStrategy("1234567890")
        );

        // User pays
        tomato.payForOrder(user, order);
    }
}
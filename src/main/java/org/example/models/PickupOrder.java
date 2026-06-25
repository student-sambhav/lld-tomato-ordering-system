package org.example.models;

public class PickupOrder extends Order{
    private String restaurantAddress;
    public PickupOrder(){
        restaurantAddress="";
    }
    @Override
    public String getType(){
        return "Pickup";
    }
    public void setRestaurantAddress(String add){
        restaurantAddress=add;
    }
    public String getRestaurantAddress(){
        return restaurantAddress;
    }
}

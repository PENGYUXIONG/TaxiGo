package com.example.pengyuxiong.taxigo.Model;

import android.location.Location;

import java.sql.Time;


public class Navigation{
    private Location Driver_lcoation;
    private Location Start_location;
    private Location Target_location;
    private Time Received_order_time;
    private Time Pick_up_time;
    private Time Arrive_time;
    private float Distance;
    private float Estimated_price;

    // when passenger post the task
    public Navigation(Location start_location, Location target_location){
        this.Start_location = start_location;
        this.Target_location = target_location;
    }

    // for the sake of driver to get tasks in certain range
    public Navigation(Location start_location, Location target_location, float distance, float estimated_price){
        this.Start_location = start_location;
        this.Target_location = target_location;
        this.Distance = distance;
        this.Estimated_price = estimated_price;
    }

    // when a driver accept task
    public Navigation(Location start_location, Location driver_lcoation, Location target_location,
                      Time received_roder_time, float distance, float estimated_price){
        this.Start_location = start_location;
        this.Driver_lcoation = driver_lcoation;
        this.Target_location = target_location;
        this.Received_order_time = received_roder_time;
        this.Distance = distance;
        this.Estimated_price = estimated_price;
    }

    // when driver pick up the passenger or goods
    public Navigation(Location start_location, Location driver_lcoation, Location target_location,
                      Time received_roder_time, Time pick_up_time, float distance, float estimated_price){
        this.Start_location = start_location;
        this.Driver_lcoation = driver_lcoation;
        this.Target_location = target_location;
        this.Received_order_time = received_roder_time;
        this.Pick_up_time = pick_up_time;
        this.Distance = distance;
        this.Estimated_price = estimated_price;
    }

    // when passenger regards the task as done
    public Navigation(Location start_location, Location driver_lcoation, Location target_location,
                      Time received_roder_time, Time pick_up_time, Time arrive_time, float distance, float estimated_price){
        this.Start_location = start_location;
        this.Driver_lcoation = driver_lcoation;
        this.Target_location = target_location;
        this.Received_order_time = received_roder_time;
        this.Pick_up_time = pick_up_time;
        this.Arrive_time = arrive_time;
        this.Distance = distance;
        this.Estimated_price = estimated_price;
    }

    public float getEstimated_price() {
        return Estimated_price;
    }

    public float getDistance() {
        return Distance;
    }

    public Time getArrive_time() {
        return Arrive_time;
    }

    public Time getReceived_order_time() {
        return Received_order_time;
    }

    public Time getPick_up_time() {
        return Pick_up_time;
    }

    public Location getTarget_location() {
        return Target_location;
    }

    public Location getStart_location() {
        return Start_location;
    }

    public Location getDriver_lcoation() {
        return Driver_lcoation;
    }

    public void setEstimated_price(float estimated_price) {
        this.Estimated_price = estimated_price;
    }

    public void setDistance(float distance) {

        this.Distance = distance;
    }

    public void setArrive_time(Time arrive_time) {

        this.Arrive_time = arrive_time;
    }

    public void setPick_up_time(Time pick_up_time) {

        this.Pick_up_time = pick_up_time;
    }

    public void setReceived_order_time(Time received_order_time) {

        this.Received_order_time = received_order_time;
    }

}

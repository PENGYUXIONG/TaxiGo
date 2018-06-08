package com.example.pengyuxiong.taxigo.Model.Task;

import android.graphics.Bitmap;
import android.location.Location;

import java.sql.Time;

import com.example.pengyuxiong.taxigo.Model.Navigation;

public abstract class Task {
    private int Passenger_id;
    private int Driver_id;
    private Navigation navigation;
    private String Task_status;
    private float Price;
    private Bitmap Picture;
    private String Description;

    public Task(){

    }

    // requested task
    public Task(int passenger_id, Navigation navigation1, String task_status){
        this.Passenger_id = passenger_id;
        this.navigation = navigation1;
        this.Task_status = task_status;
    }

    public Task(int passenger_id, Navigation navigation1, String task_status, Bitmap picture){
        this.Passenger_id = passenger_id;
        this.navigation = navigation1;
        this.Task_status = task_status;
        this.Picture = picture;
    }

    public Task(int passenger_id, Navigation navigation1, String task_status, String description){
        this.Passenger_id = passenger_id;
        this.navigation = navigation1;
        this.Task_status = task_status;
        this.Description = description;
    }

    public Task(int passenger_id, Navigation navigation1, String task_status,
                Bitmap picture, String description){
        this.Passenger_id = passenger_id;
        this.navigation = navigation1;
        this.Task_status = task_status;
        this.Picture = picture;
        this.Description = description;
    }

    // assigned task and complete task
    public Task(int passenger_id, int driver_id, Navigation navigation1, String task_status) {
        this.Passenger_id = passenger_id;
        this.Driver_id = driver_id;
        this.navigation = navigation1;
        this.Task_status = task_status;
    }

    public Task(int passenger_id, int driver_id, Navigation navigation1, String task_status, Bitmap picture){
        this.Passenger_id = passenger_id;
        this.Driver_id= driver_id;
        this.navigation = navigation1;
        this.Task_status = task_status;
        this.Picture = picture;
    }

    public Task(int passenger_id, int driver_id, Navigation navigation1, String task_status, String description){
        this.Passenger_id = passenger_id;
        this.Driver_id = driver_id;
        this.navigation = navigation1;
        this.Task_status = task_status;
        this.Description = description;
    }

    public Task(int passenger_id, int driver_id, Navigation navigation1, String task_status,
                Bitmap picture, String description){
        this.Passenger_id = passenger_id;
        this.Driver_id = driver_id;
        this.navigation = navigation1;
        this.Task_status = task_status;
        this.Picture = picture;
        this.Description = description;
    }

    // getter and setter
    public int getPassenger_id() {
        return Passenger_id;
    }

    public int getDriver_id() {
        return Driver_id;
    }

    public Navigation getNavigation() {
        return navigation;
    }

    public String getTask_status() {
        return Task_status;
    }

    public float getPrice() {
        return Price;
    }

    public Bitmap getPicture() {
        return Picture;
    }

    public String getDescription() {
        return Description;
    }

    public void setPassenger_id(int passenger_id) {
        this.Passenger_id = passenger_id;
    }

    public void setDriver_id(int driver_id) {
        this.Driver_id = driver_id;
    }

    public void setTask_status(String task_status) {
        this.Task_status = task_status;
    }

    public void setPrice(float price) {
        this.Price = price;
    }

    public void setPicture(Bitmap picture) {
        this.Picture = picture;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    // getter and setter from navagation mdoel
    public float getEstimated_price() {
        return navigation.getEstimated_price();
    }

    public float getDistance() {
        return navigation.getDistance();
    }

    public Time getArrive_time() {
        return navigation.getArrive_time();
    }

    public Time getReceived_order_time() {
        return navigation.getReceived_order_time();
    }

    public Time getPick_up_time() {
        return navigation.getPick_up_time();
    }

    public Location getTarget_location() {
        return navigation.getTarget_location();
    }

    public Location getStart_location() {
        return navigation.getStart_location();
    }

    public Location getDriver_lcoation() {
        return navigation.getDriver_lcoation();
    }

    public void setEstimated_price(float estimated_price) {
        this.navigation.setEstimated_price(estimated_price);
    }

    public void setDistance(float distance) {

        this.navigation.setDistance(distance);
    }

    public void setArrive_time(Time arrive_time) {

        this.navigation.setArrive_time(arrive_time);
    }

    public void setPick_up_time(Time pick_up_time) {

        this.navigation.setPick_up_time(pick_up_time);
    }

    public void setReceived_order_time(Time received_order_time) {

        this.navigation.setReceived_order_time(received_order_time);
    }

}

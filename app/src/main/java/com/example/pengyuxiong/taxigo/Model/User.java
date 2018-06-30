package com.example.pengyuxiong.taxigo.Model;

import android.graphics.Bitmap;

public class User {
    private String User_id;
    private String Password;
    private String Name;
    private String Primary_address;
    private int Telephone_num;
    private String Email;
    private Bitmap Potrait;
    private String User_type;
    private float Rating;
    private Truck truck;

    public User(){

    }

    public User(String user_id, String password, String name, String primary_address, int telephone_num,
                String email, String user_type){
        this.User_id = user_id;
        this.Password = password;
        this.Name = name;
        this.Primary_address = primary_address;
        this.Telephone_num = telephone_num;
        this.Email = email;
        this.User_type = user_type;
    }

    public User(String user_id, String password, String name, String primary_address, int telephone_num,
                String email, String user_type, Bitmap potrait){
        this.User_id = user_id;
        this.Password = password;
        this.Name = name;
        this.Primary_address = primary_address;
        this.Telephone_num = telephone_num;
        this.Email = email;
        this.User_type = user_type;
        this.Potrait = potrait;
    }

    public User(String user_id, String password, String name, String primary_address, int telephone_num,
                String email, String user_type, Bitmap potrait, float rating, Truck truck){
        this.User_id = user_id;
        this.Password = password;
        this.Name = name;
        this.Primary_address = primary_address;
        this.Telephone_num = telephone_num;
        this.Email = email;
        this.User_type = user_type;
        this.Potrait = potrait;
        this.Rating = rating;
        this.truck = truck;
    }

    // getters and setters
    public String getUser_id() {
        return User_id;
    }

    public String getPassword() {
        return Password;
    }

    public String getName() {
        return Name;
    }

    public String getPrimary_address() {
        return Primary_address;
    }

    public int getTelephone_num() {
        return Telephone_num;
    }

    public String getEmail() {
        return Email;
    }

    public Bitmap getPotrait() {
        return Potrait;
    }

    public String getUser_type() {
        return User_type;
    }

    public float getRating() {
        return Rating;
    }

    public Truck getTruck() {
        return truck;
    }

    public void setUser_id(String user_id) {
        this.User_id = user_id;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setPrimary_address(String primary_address) {
        this.Primary_address = primary_address;
    }

    public void setTelephone_num(int telephone_num) {
        this.Telephone_num = telephone_num;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public void setPotrait(Bitmap potrait) {
        this.Potrait = potrait;
    }

    public void setUser_type(String user_type) {
        this.User_type = user_type;
    }

    public void setRating(float rating) {
        this.Rating = rating;
    }

    // truck getters and setters
    public String getPlate_num() {
        return this.truck.getPlate_num();
    }

    public String getTruck_brand(){
        return this.truck.getTruck_brand();
    }

    public String getTruck_type(){
        return this.truck.getTruck_type();
    }

    public String getTruck_color(){
        return this.truck.getTruck_color();
    }

    public void setPlate_num(String plate_num){
        this.truck.setPlate_num(plate_num);
    }

    public void setTruck_color(String truck_color) {
        this.truck.setTruck_color(truck_color);
    }

    public void setTruck_type(String truck_type){
        this.truck.setTruck_type(truck_type);
    }

    public void setTruck_brand(String truck_brand){
        this.truck.setTruck_brand(truck_brand);
    }
}

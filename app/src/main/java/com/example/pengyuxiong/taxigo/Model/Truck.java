package com.example.pengyuxiong.taxigo.Model;

public class Truck {
    private String Plate_num;
    private String Truck_color;
    private String Truck_type;
    private String Truck_brand;

    public Truck(){}

    public Truck(String plate_num, String truck_color, String truck_type, String truck_brand){
        plate_num = this.Plate_num;
        truck_color = this.Truck_color;
        truck_brand = this.Truck_brand;
        truck_type = this.Truck_type;
    }

    public String getPlate_num() {
        return this.Plate_num;
    }

    public String getTruck_brand(){
        return this.Truck_brand;
    }

    public String getTruck_type(){
        return this.Truck_type;
    }

    public String getTruck_color(){
        return this.Truck_color;
    }

    public void setPlate_num(String plate_num){
        this.Plate_num = plate_num;
    }

    public void setTruck_color(String truck_color) {
        this.Truck_color = truck_color;
    }

    public void setTruck_type(String truck_type){
        this.Truck_type = truck_type;
    }

    public void setTruck_brand(String truck_brand){
        this.Truck_brand = truck_brand;
    }
}

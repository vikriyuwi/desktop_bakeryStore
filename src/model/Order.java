/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author fikriyuwi
 */
public class Order {
    
    String date;
    String customerName;
    DryCake DryCakes;
    WetCake WetCakes;

//    public Order(String date, String customerName, DryCake drycake, WetCake wetcake) {
//        this.date = date;
//        this.customerName = customerName;
//        this.DryCakes = drycake;
//        this.WetCakes = wetcake;
//    }
//    
//    public Order(String date, String customerName, DryCake drycake) {
//        this.date = date;
//        this.customerName = customerName;
//        this.DryCakes = drycake;
//    }
//    
//    public Order(String date, String customerName, WetCake wetcake) {
//        this.date = date;
//        this.customerName = customerName;
//        this.WetCakes = wetcake;
//    }
    
    public Order(String date, String customerName) {
        this.date = date;
        this.customerName = customerName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public DryCake getDryCakes() {
        return DryCakes;
    }

    public void setDryCakes(DryCake DryCakes) {
        this.DryCakes = DryCakes;
    }

    public WetCake getWetCakes() {
        return WetCakes;
    }

    public void setWetCakes(WetCake WetCakes) {
        this.WetCakes = WetCakes;
    }
    
}

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
public class OrderCollection {
    static ArrayList<Order> OrderCol = new ArrayList<>();
    
//    public static void addDataCollection(String date, String customerName, DryCake drycake, WetCake wetcake)
//    {
//        OrderCol.add(new Order(date,customerName,drycake,wetcake));
//    }
//    
//    public static void addDataCollection(String date, String customerName, DryCake drycake)
//    {
//        OrderCol.add(new Order(date,customerName,drycake));
//    }
//    
//    public static void addDataCollection(String date, String customerName, WetCake wetcake)
//    {
//        OrderCol.add(new Order(date,customerName,wetcake));
//    }
    
    public static void addDataCollection(String date, String customerName)
    {
        OrderCol.add(new Order(date,customerName));
    }
    
    public static ArrayList<Order> getDataCollection()
    {
        return OrderCol;
    }
    
    public static int getSize()
    {
        return OrderCol.size();
    }
    
    public static Order getData(int index)
    {
        return OrderCol.get(index);
    }
    
    public static void removeData(int index)
    {
        OrderCol.remove(index);
    }
    
    public static void updateData(int index, String date, String customerName, int amount)
    {
        OrderCol.get(index).setDate(date);
        OrderCol.get(index).setCustomerName(customerName);
    }
    
    public static void updateDryCake(int index, DryCake drycake)
    {
        OrderCol.get(index).setDryCakes(drycake);
    }
    
    public static void updateWetCake(int index, WetCake wetcake)
    {
        OrderCol.get(index).setWetCakes(wetcake);
    }
}

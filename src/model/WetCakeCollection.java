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
public class WetCakeCollection {
    static ArrayList<WetCake> WetCakeCol = new ArrayList<>();
    
    public static void addDataCollection(String name, int price, String filling)
    {
        WetCakeCol.add(new WetCake(name,price,filling));
    }
    
    public static ArrayList<WetCake> getDataCollection()
    {
        return WetCakeCol;
    }
    
    public static int getSize()
    {
        return WetCakeCol.size();
    }
    
    public static WetCake getData(int index)
    {
        return WetCakeCol.get(index);
    }
    
    public static WetCake findData(String name)
    {
        int find = -1;
        for (int i = 0; i < WetCakeCollection.getSize(); i++) {
            if (WetCakeCol.get(i).name.equals(name)) {
                find = i;
            }
        }
        
        if (find >= 0) {
            return WetCakeCol.get(find);
        } else {
            return null;
        }
    }
    
    public static int findId(String name)
    {
        int find = -1;
        for (int i = 0; i < WetCakeCollection.getSize(); i++) {
            if (WetCakeCol.get(i).name.equals(name)) {
                find = i;
            }
        }
        return find;
    }
    
    public static void removeData(int index)
    {
        WetCakeCol.remove(index);
    }
    
    public static void updateData(int index, String name, int price, String filling)
    {
        WetCakeCol.get(index).setName(name);
        WetCakeCol.get(index).setPrice(price);
        WetCakeCol.get(index).setFilling(filling);
    }
}

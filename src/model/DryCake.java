/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author fikriyuwi
 */
public class DryCake<D> extends Cake {
    // kemasan dalam satuan gram
    private D weight;

    public DryCake(String name, int price, D weight) {
        super(name,price);
        this.weight = weight;
    }

    public D getWeight() {
        return weight;
    }

    public void setWeight(D weight) {
        this.weight = weight;
    }
    
    @Override
    public void printCakeData()
    {
        System.out.println("Name     : " + name);
        System.out.println("Price    : " + String.valueOf(price));
        System.out.println("Weight   : " + String.valueOf(this.weight + "\n"));
    }

}

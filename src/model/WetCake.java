/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author fikriyuwi
 */
public class WetCake<W> extends Cake{
    // variasi isian
    private W filling;

    public WetCake(String name, int price, W filling) {
        super(name,price);
        this.filling = filling;
    }

    public W getFilling() {
        return filling;
    }

    public void setFilling(W filling) {
        this.filling = filling;
    }
}

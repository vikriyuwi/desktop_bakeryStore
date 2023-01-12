/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import model.Order;

/**
 * FXML Controller class
 *
 * @author fikriyuwi
 */
public class OrderItemController implements Initializable {

    @FXML
    private Label lblDate;

    @FXML
    private Label lblId;

    @FXML
    private Label lblName;

    @FXML
    private Label lblPrice;
    
    public void setData(Order order, int i)
    {
        lblId.setText(String.valueOf((i+1)));
        lblDate.setText(order.getDate());
        lblName.setText(order.getCustomerName());
        
        int price = 0;
        
        if(order.getDryCakes() != null)
        {
            price += order.getDryCakes().price;
        }
        
        if(order.getWetCakes() != null)
        {
            price += order.getWetCakes().price;
        }
        
        lblPrice.setText("Rp " + String.valueOf(price));
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

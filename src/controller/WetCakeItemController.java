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
import model.WetCake;

/**
 * FXML Controller class
 *
 * @author fikriyuwi
 */
public class WetCakeItemController implements Initializable {

    @FXML
    private Label lblFilling;

    @FXML
    private Label lblId;

    @FXML
    private Label lblName;

    @FXML
    private Label lblPrice;
    
    public void setData(WetCake cake, int i)
    {
        lblId.setText(String.valueOf((i+1)));
        lblName.setText(cake.getName());
        lblPrice.setText(String.valueOf(cake.getPrice()));
        lblFilling.setText(String.valueOf(cake.getFilling()));
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}

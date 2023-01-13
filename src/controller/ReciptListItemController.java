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
public class ReciptListItemController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label lblId;

    @FXML
    private Label lblName;

    @FXML
    private Label lblPrice;
    
    @FXML
    private Label lblDesc;
    
    public void setData(int i, String name, String price, String Desc)
    {
        lblId.setText(String.valueOf(i));
        lblName.setText(name);
        lblPrice.setText("Rp " + price);
        lblDesc.setText(Desc);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

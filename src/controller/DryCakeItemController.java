/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.DryCake;

/**
 *
 * @author fikriyuwi
 */
public class DryCakeItemController implements Initializable {
    
    
    @FXML
    private Button btnDelete;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnView;

    @FXML
    private Label lblId;

    @FXML
    private Label lblName;

    @FXML
    private Label lblPrice;

    @FXML
    private Label lblWeight;
    
    public void setData(DryCake cake, int i)
    {
        lblId.setText(String.valueOf((i+1)));
        lblName.setText(cake.getName());
        lblPrice.setText(String.valueOf(cake.getPrice()));
        lblWeight.setText(String.valueOf(cake.getWeight()) + " g");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
    
}

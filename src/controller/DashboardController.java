/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.DryCake;

/**
 *
 * @author fikriyuwi
 */
public class DashboardController implements Initializable{
    
    @FXML
    private AnchorPane mainPanel;
    
    public void changePage(ActionEvent event, String page) throws IOException
    {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(page));
            Parent root = loader.load();
            mainPanel.getChildren().setAll(root);
        } catch (IOException ex) {
            Logger.getLogger(mainViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void changeToDryCakeView(ActionEvent event) throws IOException {
        changePage(event,"/view/DryCakeView.fxml");
    }

    @FXML
    void changeToOrderView(ActionEvent event) throws IOException {
        changePage(event,"/view/OrderView.fxml");
    }

    @FXML
    void changeToWetCakeView(ActionEvent event) throws IOException {
        changePage(event,"/view/WetCakeView.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
}

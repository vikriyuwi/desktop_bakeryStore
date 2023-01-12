/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.OrderCollection;

/**
 *
 * @author fikriyuwi
 */
public class OrderController implements Initializable {
    
    @FXML
    private VBox OrderLayout;
    
    @FXML
    private Label lblFilling;

    @FXML
    private Label lblId;

    @FXML
    private Label lblName;

    @FXML
    private Label lblPrice;

    @FXML
    private AnchorPane mainPanel;

    @FXML
    private TextField tfIdOrder;

    @FXML
    void addData(ActionEvent event) {

    }

    @FXML
    void btnDeleteDataOrder(ActionEvent event) {

    }

    @FXML
    void btnEditDataOrder(ActionEvent event) {

    }

    @FXML
    void btnPrintDataOrder(ActionEvent event) {

    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int i = 0; i < OrderCollection.getSize(); i++) {
            
            System.out.println(OrderCollection.getData(i).getCustomerName());
            FXMLLoader item = new FXMLLoader();
            item.setLocation(getClass().getResource("/item/OrderItem.fxml"));

            try {
                HBox hBox = item.load();
                OrderItemController dcic = item.getController();
                dcic.setData(OrderCollection.getData(i),i);
                
                OrderLayout.getChildren().add(hBox);
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
    
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
}

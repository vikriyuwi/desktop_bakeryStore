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
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.WetCakeCollection;

/**
 *
 * @author fikriyuwi
 */
public class WetCakeController implements Initializable {

    @FXML
    private AnchorPane mainPanel;
    
    @FXML
    private VBox WetCakeLayout;

    @FXML
    private TextField tfIdWetCake;

    
    // add cake
    @FXML
    private Pane paneAddCake;

    @FXML
    private TextField tfFilling;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfPrice;
    
    
    // update cake
    @FXML
    private Pane paneUpdateCake;

    @FXML
    private TextField tfFillingUpdate;

    @FXML
    private TextField tfNameUpdate;

    @FXML
    private TextField tfPriceUpdate;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        paneAddCake.setVisible(false);
        paneUpdateCake.setVisible(false);
        for (int i = 0; i < model.WetCakeCollection.getSize(); i++) {
            FXMLLoader item = new FXMLLoader();
            item.setLocation(getClass().getResource("/item/WetCakeItem.fxml"));

            try {
                HBox hBox = item.load();
                WetCakeItemController dcic = item.getController();
                dcic.setData(model.WetCakeCollection.getData(i),i);
                
                WetCakeLayout.getChildren().add(hBox);
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
    
    // add data
    @FXML
    void addData(ActionEvent event) {
        paneAddCake.setVisible(true);
    }
    
    @FXML
    void storeData(ActionEvent event) throws IOException {
        if ((tfName.getText().isEmpty() || tfPrice.getText().isEmpty())||tfFilling.getText().isEmpty()) {
            showWarningMessage("Make sure there is no field is empty");
        } else {
            WetCakeCollection.addDataCollection(tfName.getText(),Integer.parseInt(tfPrice.getText()),tfFilling.getText());
            FXMLLoader loader = new FXMLLoader();        
            loader.setLocation(getClass().getResource("/view/WetCakeView.fxml"));

            Parent root = loader.load();
            mainPanel.getChildren().setAll(root);
        }
    }
    
    @FXML
    void cancelStore(ActionEvent event) {
        paneAddCake.setVisible(false);
    }
    
    // delete
    @FXML
    void btnDeleteDataWetCake(ActionEvent event) throws IOException {
        if (!tfIdWetCake.getText().isEmpty()) {
            int id = Integer.valueOf(tfIdWetCake.getText())-1;
            if(id >=0 && id < WetCakeCollection.getSize())
            {
                WetCakeCollection.removeData(id);
                FXMLLoader loader = new FXMLLoader();      

                loader.setLocation(getClass().getResource("/view/WetCakeView.fxml"));

                Parent root = loader.load();
                mainPanel.getChildren().setAll(root);
            } else {
                showWarningMessage("Id cake is out of data");
            }
        } else {
            showWarningMessage("Make sure id cake field is not empty");
        }
    }
    
    // edit data
    @FXML
    void btnEditDataWetCake(ActionEvent event) {
        if (!tfIdWetCake.getText().isEmpty()) {
            int id = Integer.valueOf(tfIdWetCake.getText())-1;
            if(id >=0 && id < WetCakeCollection.getSize())
            {
                tfNameUpdate.setText(WetCakeCollection.getData(id).name);
                tfPriceUpdate.setText(String.valueOf(WetCakeCollection.getData(id).price));
                tfFillingUpdate.setText(String.valueOf(WetCakeCollection.getData(id).getFilling()));
                paneUpdateCake.setVisible(true);
            } else {
                showWarningMessage("Id cake is out of data");
            }
        } else {
            showWarningMessage("Make sure id cake field is not empty");
        }
    }
    
    @FXML
    void updateData(ActionEvent event) throws IOException {
        int id = Integer.valueOf(tfIdWetCake.getText())-1;
        
        if(id >= 0 && id < WetCakeCollection.getSize())
        {
            if ((tfName.getText().isEmpty() || tfPrice.getText().isEmpty())||tfFilling.getText().isEmpty()) {
                showWarningMessage("Make you there is no field is empty");
            } else {
                WetCakeCollection.updateData(id,tfNameUpdate.getText(),Integer.parseInt(tfPriceUpdate.getText()),tfFillingUpdate.getText());
                paneUpdateCake.setVisible(true);

                FXMLLoader loader = new FXMLLoader();        
                loader.setLocation(getClass().getResource("/view/WetCakeView.fxml"));

                Parent root = loader.load();
                mainPanel.getChildren().setAll(root);
            }
        }
    }
    
    @FXML
    void cancelUpdate(ActionEvent event) {
        paneUpdateCake.setVisible(false);
    }
    
    public void showWarningMessage(String message)
    {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning!");
        alert.setHeaderText("Opps..");
        alert.setContentText(message);
        alert.showAndWait();
    }
}

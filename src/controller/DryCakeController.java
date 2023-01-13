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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.DryCake;
import model.DryCakeCollection;

/**
 *
 * @author fikriyuwi
 */
public class DryCakeController implements Initializable {
    
    @FXML
    private AnchorPane mainPanel;
    
    @FXML
    private VBox DryCakeLayout; 
    
    @FXML
    private Pane paneAddCake;
    
    @FXML
    private Pane paneUpdateCake;
    
    @FXML
    private Button btnAddData;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnSave;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfPrice;

    @FXML
    private TextField tfWeight;
    
    @FXML
    private TextField tfNameUpdate;

    @FXML
    private TextField tfPriceUpdate;

    @FXML
    private TextField tfWeightUpdate;
    
    @FXML
    private TextField tfIdDryCake;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        paneAddCake.setVisible(false);
        paneUpdateCake.setVisible(false);
        for (int i = 0; i < DryCakeCollection.getSize(); i++) {
            FXMLLoader item = new FXMLLoader();
            item.setLocation(getClass().getResource("/item/DryCakeItem.fxml"));

            try {
                HBox hBox = item.load();
                DryCakeItemController dcic = item.getController();
                dcic.setData(DryCakeCollection.getData(i),i);
                
                DryCakeLayout.getChildren().add(hBox);
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    @FXML
    void addData(ActionEvent event) {
        paneAddCake.setVisible(true);
    }

    @FXML
    void cancelData(ActionEvent event) {
        paneAddCake.setVisible(false);
    }
    
    @FXML
    public void storeData(ActionEvent event) throws IOException {
        if((tfName.getText().isEmpty() || tfPrice.getText().isEmpty() ) || tfWeight.getText().isEmpty())
        {
            showWarningMessage("Make you there is no field is empty");
        } else {
            String name = tfName.getText();
            int price = Integer.parseInt(tfPrice.getText());
            double weight = Double.parseDouble(tfWeight.getText());
            DryCakeCollection.addDataCollection(name,price,weight);
            FXMLLoader loader = new FXMLLoader();        
            loader.setLocation(getClass().getResource("/view/DryCakeView.fxml"));

            Parent root = loader.load();
            mainPanel.getChildren().setAll(root);
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
    
     @FXML
    void btnDeleteDataDryCake(ActionEvent event) throws IOException {
        if (!tfIdDryCake.getText().isEmpty()) {
            int id = Integer.valueOf(tfIdDryCake.getText())-1;
            if(id >=0 && id < DryCakeCollection.getSize())
            {
                DryCakeCollection.removeData(id);
                FXMLLoader loader = new FXMLLoader();      

                loader.setLocation(getClass().getResource("/view/DryCakeView.fxml"));

                Parent root = loader.load();
                mainPanel.getChildren().setAll(root);
            } else {
                showWarningMessage("Id cake is out of data");
            }
        } else {
            showWarningMessage("Make sure id cake field is not empty");
        }
    }

    @FXML
    void btnEditDataDryCake(ActionEvent event) throws IOException {
        if (!tfIdDryCake.getText().isEmpty()) {
            int id = Integer.valueOf(tfIdDryCake.getText())-1;
            if(id >=0 && id < DryCakeCollection.getSize())
            {
                tfNameUpdate.setText(DryCakeCollection.getData(id).name);
                tfPriceUpdate.setText(String.valueOf(DryCakeCollection.getData(id).price));
                tfWeightUpdate.setText(String.valueOf(DryCakeCollection.getData(id).weight));
                paneUpdateCake.setVisible(true);
            } else {
                showWarningMessage("Id cake is out of data");
            }
        } else {
            showWarningMessage("Make sure id cake field is not empty");
        }
    }
    
    @FXML
    void btnUpdateData(ActionEvent event) throws IOException {
        int id = Integer.valueOf(tfIdDryCake.getText())-1;
        
        if(id >= 0 && id < DryCakeCollection.getSize())
        {
            if((tfName.getText().isEmpty() || tfPrice.getText().isEmpty() ) || tfWeight.getText().isEmpty())
            {
                showWarningMessage("Make you there is no field is empty");
            } else {
                DryCakeCollection.updateData(id,tfNameUpdate.getText(),Integer.parseInt(tfPriceUpdate.getText()),Double.parseDouble(tfWeightUpdate.getText()));
                paneUpdateCake.setVisible(true);

                FXMLLoader loader = new FXMLLoader();        
                loader.setLocation(getClass().getResource("/view/DryCakeView.fxml"));

                Parent root = loader.load();
                mainPanel.getChildren().setAll(root);
            }
        }
    }
    
    @FXML
    void btnCancelUpdate(ActionEvent event) throws IOException {
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

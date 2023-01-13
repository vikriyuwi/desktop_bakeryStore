/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.DryCakeCollection;
import model.OrderCollection;
import model.WetCakeCollection;

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
    
    // add data
    @FXML
    private Pane paneMakeOrder;
    
    @FXML
    private TextField tfName;
    
    
    @FXML
    private ChoiceBox<String> cbDryCake;

    @FXML
    private ChoiceBox<String> cbWetCake;
    
    @FXML
    void addData(ActionEvent event) {
        paneMakeOrder.setVisible(true);
    }

    @FXML
    private DatePicker dpDate;
    
    @FXML
    void storeData(ActionEvent event) throws IOException {
        int dcSelected = cbDryCake.getSelectionModel().getSelectedIndex();
        int wcSelected = cbWetCake.getSelectionModel().getSelectedIndex();
            
        if(tfName.getText().isEmpty() || dpDate.getValue() == null) {
            showWarningMessage("Make sure name and date is filled");
        } else {
            if (dcSelected < 0 && wcSelected < 0) {
                showWarningMessage("Please select Dry Cake or Wet Cake");
            } else {
                OrderCollection.addDataCollection(String.valueOf(dpDate.getValue()), tfName.getText());

                if (dcSelected >= 0) {
                    OrderCollection.updateDryCake((OrderCollection.getSize()-1), DryCakeCollection.getData(dcSelected));
                }

                if (wcSelected >= 0) {
                    OrderCollection.updateWetCake((OrderCollection.getSize()-1), WetCakeCollection.getData(wcSelected));
                }

                FXMLLoader loader = new FXMLLoader();        
                loader.setLocation(getClass().getResource("/view/OrderView.fxml"));

                Parent root = loader.load();
                mainPanel.getChildren().setAll(root);
            }
        }
    }
    
    @FXML
    void cancelStore(ActionEvent event) {
        paneMakeOrder.setVisible(false);
    }
    
    // delete
    @FXML
    void btnDeleteDataOrder(ActionEvent event) throws IOException {
        if (!tfIdOrder.getText().isEmpty()) {
            int id = Integer.valueOf(tfIdOrder.getText())-1;
            if(id >=0 && id < OrderCollection.getSize())
            {
                OrderCollection.removeData(id);
                
                FXMLLoader loader = new FXMLLoader();        
                loader.setLocation(getClass().getResource("/view/OrderView.fxml"));

                Parent root = loader.load();
                mainPanel.getChildren().setAll(root);
            } else {
                showWarningMessage("Id order is out of data");
            }
        } else {
            showWarningMessage("Make sure id order field is not empty");
        }
    }
    
    // update data
    @FXML
    private Pane paneUpdateOrder;
    
    @FXML
    private TextField tfNameUpdate;
    
    @FXML
    private ChoiceBox<String> cbDryCakeUpdate;

    @FXML
    private ChoiceBox<String> cbWetCakeUpdate;
    
    @FXML
    private DatePicker dpDateUpdate;
    
    @FXML
    void btnEditDataOrder(ActionEvent event) {
        if (!tfIdOrder.getText().isEmpty()) {
            int id = Integer.valueOf(tfIdOrder.getText())-1;
            if(id >=0 && id < OrderCollection.getSize()) {
                cbDryCakeUpdate.getSelectionModel().select("");
                cbDryCakeUpdate.getSelectionModel().select("");
                
                tfNameUpdate.setText(OrderCollection.getData(id).getCustomerName());
                dpDateUpdate.setValue(LocalDate.parse(OrderCollection.getData(id).getDate()));
                
                if(OrderCollection.getData(id).getDryCakes() != null)
                {
                    cbDryCakeUpdate.getSelectionModel().select(OrderCollection.getData(id).getDryCakes().name);
                }
                
                if(OrderCollection.getData(id).getWetCakes() != null)
                {
                    cbWetCakeUpdate.getSelectionModel().select(OrderCollection.getData(id).getWetCakes().name);
                }
                paneUpdateOrder.setVisible(true);
            } else {
                showWarningMessage("Id order is out of data");
            }
        } else {
            showWarningMessage("Make sure id order field is not empty");
        }
    }
    
    @FXML
    void updateData(ActionEvent event) throws IOException {
        if (!tfIdOrder.getText().isEmpty()) {
            int id = Integer.valueOf(tfIdOrder.getText())-1;
            int dcSelected = cbDryCakeUpdate.getSelectionModel().getSelectedIndex();
            int wcSelected = cbWetCakeUpdate.getSelectionModel().getSelectedIndex();

            if(tfNameUpdate.getText().isEmpty() || dpDateUpdate.getValue() == null) {
                showWarningMessage("Make sure name and date is filled");
            } else {
                if (dcSelected < 0 && wcSelected < 0) {
                    showWarningMessage("Please select Dry Cake or Wet Cake");
                } else {
                    OrderCollection.updateData(id, String.valueOf(dpDateUpdate.getValue()), tfNameUpdate.getText());

                    if (dcSelected >= 0) {
                        OrderCollection.updateDryCake(id, DryCakeCollection.getData(dcSelected));
                    }

                    if (wcSelected >= 0) {
                        OrderCollection.updateWetCake(id, WetCakeCollection.getData(wcSelected));
                    }

                    FXMLLoader loader = new FXMLLoader();        
                    loader.setLocation(getClass().getResource("/view/OrderView.fxml"));

                    Parent root = loader.load();
                    mainPanel.getChildren().setAll(root);
                }
            }
        } else {
            showWarningMessage("Make sure id order field is not empty");
        }
    }

    @FXML
    void cancelUpdate(ActionEvent event) {
        paneUpdateOrder.setVisible(false);
    } 

    //print
    
    @FXML
    private Pane panePrint;
    
    @FXML
    private Label lblNameRecipt;
    
    @FXML
    private Label lblDateRecipt;
            
    @FXML
    private Label lblTotalRecipt;
    
    @FXML
    private VBox paneReciptList;
            
    @FXML
    void btnPrintDataOrder(ActionEvent event) {
        if (!tfIdOrder.getText().isEmpty()) {
            int id = Integer.valueOf(tfIdOrder.getText())-1;
            if(id >=0 && id < OrderCollection.getSize()) {
                lblNameRecipt.setText(OrderCollection.getData(id).getCustomerName());
                lblDateRecipt.setText(OrderCollection.getData(id).getDate());
                
                int price = 0;
        
                if(OrderCollection.getData(id).getDryCakes() != null)
                {
                    price += OrderCollection.getData(id).getDryCakes().price;
                }

                if(OrderCollection.getData(id).getWetCakes() != null)
                {
                    price += OrderCollection.getData(id).getWetCakes().price;
                }
                
                int num = 1;
                if(OrderCollection.getData(id).getDryCakes() != null)
                {
                    FXMLLoader item = new FXMLLoader();
                    item.setLocation(getClass().getResource("/item/ReciptListItem.fxml"));

                    try {
                        HBox hBox = item.load();
                        ReciptListItemController dcic = item.getController();
                        dcic.setData(num, OrderCollection.getData(id).getDryCakes().name, String.valueOf(OrderCollection.getData(id).getDryCakes().price), String.valueOf(OrderCollection.getData(id).getDryCakes().weight + " g"));
//                        ReciptListItemController dcic = item.getController();
//                        dcic.setData(OrderCollection.getData(i),i);

                        paneReciptList.getChildren().add(hBox);
                    } catch(IOException e) {
                        e.printStackTrace();
                    }
                }
                
                if(OrderCollection.getData(id).getWetCakes() != null)
                {
                    if (OrderCollection.getData(id).getDryCakes() == null) {
                        num = 1;
                    } else {
                        num = 2;
                    }
                    
                    FXMLLoader item = new FXMLLoader();
                    item.setLocation(getClass().getResource("/item/ReciptListItem.fxml"));

                    try {
                        HBox hBox = item.load();
                        ReciptListItemController dcic = item.getController();
                        dcic.setData(num, OrderCollection.getData(id).getWetCakes().name, String.valueOf(OrderCollection.getData(id).getWetCakes().price), String.valueOf(OrderCollection.getData(id).getWetCakes().filling));

                        paneReciptList.getChildren().add(hBox);
                    } catch(IOException e) {
                        e.printStackTrace();
                    }
                }

                lblTotalRecipt.setText("Rp " + String.valueOf(price));
                panePrint.setVisible(true);
            } else {
                showWarningMessage("Id order is oout of data");
            }
        } else {
            showWarningMessage("Make sure id order field is not empty");
        }
    }
    
    @FXML
    public void cancelPrint (ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();        
        loader.setLocation(getClass().getResource("/view/OrderView.fxml"));

        Parent root = loader.load();
        mainPanel.getChildren().setAll(root);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        paneMakeOrder.setVisible(false);
        paneUpdateOrder.setVisible(false);
        panePrint.setVisible(false);
        
        for (int i = 0; i < OrderCollection.getSize(); i++) {
            
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
        
        for (int i = 0; i < DryCakeCollection.getSize(); i++) {
            String name = DryCakeCollection.getData(i).getName();
            cbDryCake.getItems().add(name);
            cbDryCakeUpdate.getItems().add(name);
        }

        for (int i = 0; i < WetCakeCollection.getSize(); i++) {
            String name = WetCakeCollection.getData(i).getName();
            cbWetCake.getItems().add(name);
            cbWetCakeUpdate.getItems().add(name);
        }
    }
    
    public void showWarningMessage(String message)
    {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning!");
        alert.setHeaderText("Opps..");
        alert.setContentText(message);
        alert.showAndWait();
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package bakerystore;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.DryCakeCollection;
import model.OrderCollection;
import model.WetCakeCollection;

/**
 *
 * @author fikriyuwi
 */
public class BakeryStore extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        DryCakeCollection.addDataCollection("Putri Salju",120000,250);
        DryCakeCollection.addDataCollection("Kue Bangkit",85000,500);
        DryCakeCollection.addDataCollection("Kue Kering",80000,500);
        
        WetCakeCollection.addDataCollection("Nagasari", 2000, "Chocolate");
        WetCakeCollection.addDataCollection("Lemper", 3000, "Chicken");
        WetCakeCollection.addDataCollection("Lumia", 5000, "Chicken Cheese");
        
        OrderCollection.addDataCollection("2022-10-08", "Anis");
        OrderCollection.updateDryCake((OrderCollection.getSize()-1), DryCakeCollection.getData(0));
        OrderCollection.addDataCollection("2022-12-11", "Yono");
        OrderCollection.updateWetCake((OrderCollection.getSize()-1), WetCakeCollection.getData(1));
        OrderCollection.addDataCollection("2023-01-08", "Puja");
        OrderCollection.updateDryCake((OrderCollection.getSize()-1), DryCakeCollection.getData(2));
        OrderCollection.updateWetCake((OrderCollection.getSize()-1), WetCakeCollection.getData(2));

        Parent root = FXMLLoader.load(getClass().getResource("/view/MainView.fxml"));
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

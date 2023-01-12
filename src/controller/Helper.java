/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author fikriyuwi
 */
public class Helper {
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    public void changePage(ActionEvent event, String page) throws IOException
    {
        System.out.println(page);
        
        Parent root = FXMLLoader.load(getClass().getResource(page));
        
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
        
//        Node node = (Node) event.getSource();
//        Stage stage = (Stage) node.getScene().getWindow();
//        
//        Parent root = null;
//        
//        try {
//            root = FXMLLoader.load(getClass().getClassLoader().getResource(page));
//            System.out.println(page);
//        } catch (IOException e) {
//            System.out.println(e);
//        }
//        
//        Scene scene = new Scene(root);
//        
//        stage.setScene(scene);
//        stage.show();
    }
}

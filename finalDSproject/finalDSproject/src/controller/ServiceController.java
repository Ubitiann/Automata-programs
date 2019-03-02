/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hp
 */
public class ServiceController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label label;

    @FXML
    private Button wd_button;

    @FXML
    private Button dep_button;

    @FXML
    private Button newac_button;

    @FXML
    private Button mpro_button;

    @FXML
    private Button other_button;
    
    @FXML
    private Button exit;
    @FXML
    private AnchorPane rootpane;

    @FXML
    void cashdeposit(ActionEvent event) throws IOException {

       AnchorPane pane=FXMLLoader.load(getClass().getResource("/view/cwcd1.fxml"));
       rootpane.getChildren().setAll(pane);
  }

    @FXML
    void monthlyprofit(ActionEvent event) throws IOException {
        
        AnchorPane pane=FXMLLoader.load(getClass().getResource("/view/Profit.fxml"));
        rootpane.getChildren().setAll(pane);
    }

    @FXML
    void newaccount(ActionEvent event) throws IOException {
      
        AnchorPane pane=FXMLLoader.load(getClass().getResource("/view/new1.fxml"));
        rootpane.getChildren().setAll(pane);
    }

    @FXML
    void others(ActionEvent event) throws IOException {
      
        AnchorPane pane=FXMLLoader.load(getClass().getResource("/view/Others.fxml"));
        rootpane.getChildren().setAll(pane);
    }

    @FXML
    void withdrawl(ActionEvent event) throws IOException {

       AnchorPane pane=FXMLLoader.load(getClass().getResource("/view/cwcd.fxml"));
        rootpane.getChildren().setAll(pane);
    }
    
    @FXML
    void exit(ActionEvent event) {
        try {

            AnchorPane pane=FXMLLoader.load(getClass().getResource("/view/FXMLDocument.fxml"));
            rootpane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(ServiceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
    }    
    
}

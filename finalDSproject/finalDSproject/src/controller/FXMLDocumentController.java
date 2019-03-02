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
 *
 * @author Hp
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;


    @FXML
    private Button admin;
    
    @FXML
    private Button button;
    
    @FXML
    private Button exit;
    @FXML
    private AnchorPane rootpane;

    @FXML
    void handleAdminAction(ActionEvent event) throws IOException {
       
        AnchorPane pane=FXMLLoader.load(getClass().getResource("/view/admin.fxml"));
        rootpane.getChildren().setAll(pane);
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        try {
            
            AnchorPane pane=FXMLLoader.load(getClass().getResource("/view/service.fxml"));
            rootpane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    void exit(ActionEvent event) {
        Stage stage=(Stage) exit.getScene().getWindow();
        stage.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

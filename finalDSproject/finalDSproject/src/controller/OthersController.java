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
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hp
 */
public class OthersController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private RadioButton fd;

    @FXML
    private RadioButton uinfo;

    @FXML
    private RadioButton chkbal;
    
    @FXML
    private Button exit;
    @FXML
    private AnchorPane rootpane;

    @FXML
    void FixedDeposit(ActionEvent event) throws IOException {

      AnchorPane pane=FXMLLoader.load(getClass().getResource("/view/fixdep.fxml"));
        rootpane.getChildren().setAll(pane);
    }

    @FXML
    void checkbalance(ActionEvent event) throws IOException {
        
        AnchorPane pane=FXMLLoader.load(getClass().getResource("/view/chbalance.fxml"));
        rootpane.getChildren().setAll(pane);
    }

    @FXML
    void updateinformation(ActionEvent event) throws IOException {
        AnchorPane pane=FXMLLoader.load(getClass().getResource("/view/Profinfo.fxml"));
        rootpane.getChildren().setAll(pane);
    }
    
    @FXML
    void exit(ActionEvent event) {
        try {

            AnchorPane pane=FXMLLoader.load(getClass().getResource("/view/service.fxml"));
            rootpane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(OthersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

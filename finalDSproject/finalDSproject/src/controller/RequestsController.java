/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hp
 */
public class RequestsController extends HeadOffice implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button yes;

    @FXML
    private Button no;
    
    @FXML
    private Button back;
    
    @FXML
    private Label check;

    @FXML
    private TextField title;

    @FXML
    private TextField branchcode;

    @FXML
    private TextField accountbalance;

    @FXML
    private TextField contact;

    @FXML
    private TextField address;

    @FXML
    private TextField cnic;

    @FXML
    private TextField district;

    @FXML
    private TextField province;

    @FXML
    private TextField accountype;

    private int a;

    HeadOffice hf = new HeadOffice();
    @FXML
    private AnchorPane rootpane;

    @FXML
    void title(ActionEvent event) throws FileNotFoundException, IOException {
        try {
            a = checkRequests();
        } catch (IOException ex) {
            Logger.getLogger(RequestsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (a == 1) {
            check.setText("No request");
        } else {
            title.setText(name);
        }
    }

    @FXML
    void branchcode(ActionEvent event) {
        branchcode.setText(br_code);
    }

    @FXML
    void accountbalance(ActionEvent event) {
        accountbalance.setText(bal);
    }

    @FXML
    void contact(ActionEvent event) {
        contact.setText(phone);
    }

    @FXML
    void address(ActionEvent event) {
        address.setText(add);
    }

    @FXML
    void cnic(ActionEvent event) {
        cnic.setText(nic);
    }

    @FXML
    void district(ActionEvent event) {
        district.setText(dist);
    }

    @FXML
    void province(ActionEvent event) {
        province.setText(prov);
    }

    @FXML
    void accountype(ActionEvent event) {
        accountype.setText(type);
    }

    void nobutton(ActionEvent event) throws IOException {
        Customers.remove(1);
        File f1 = new File(path_requests);
        FileOutputStream fos = new FileOutputStream(f1);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        for (int j = 0; j < Customers.size(); j++) {
            bw.write(Customers.get(j));
        }
        bw.close();
        
       AnchorPane pane=FXMLLoader.load(getClass().getResource("/view/Requests.fxml"));
       rootpane.getChildren().setAll(pane);
    }

    @FXML
    void yesbutton(ActionEvent event) throws IOException {
        Writer output = new BufferedWriter(new FileWriter(path1, true));
        output.append("\n");
        output.append(Customers.get(1));
        output.close();
        Customers.remove(1);
        File f1 = new File(path_requests);
        FileOutputStream fos = new FileOutputStream(f1);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        for (int j = 0; j < Customers.size(); j++) {
            bw.write(Customers.get(j));
            bw.write("\n");
        }
        bw.close();
        
        AnchorPane pane=FXMLLoader.load(getClass().getResource("/view/Requests.fxml"));
        rootpane.getChildren().setAll(pane);
    }
    
    @FXML
    void back(ActionEvent event){
        try {

            AnchorPane pane=FXMLLoader.load(getClass().getResource("/view/admin2.fxml"));
            rootpane.getChildren().setAll(pane);
        } catch (IOException ex) { 
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

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
import javafx.scene.control.PasswordField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hp
 */
public class AdminController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private PasswordField Adminpassword;

    @FXML
    private Label pass_correct;

//    @FXML
//    private Button submitpass;
//    
    @FXML
    private Button back;

    HeadOffice hf = new HeadOffice();
    public int check;
    @FXML
    private AnchorPane rootpane;

    
    void Checkpassword() throws IOException, InterruptedException {
        try {
            check = hf.checkpassward(Adminpassword);
        } catch (IOException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (check == 1) {
            
            pass_correct.setText("Correct ");
           Thread.sleep(3000);
            AnchorPane pane=FXMLLoader.load(getClass().getResource("/view/admin2.fxml"));
            rootpane.getChildren().setAll(pane);
        } else {
            pass_correct.setText("Incorrect ");
            Thread.sleep(1000);
        }
    }
//
//    @FXML
//    void Adminpasswordsubmit(ActionEvent event) throws IOException {
//    
//        if (check == 1) {
//            Stage stage = (Stage) submitpass.getScene().getWindow();
//            stage.close();
//            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/admin2.fxml"));
//            Parent root1 = (Parent) fxmlLoader.load();
//            Stage st = new Stage();
//            st.setScene(new Scene(root1));
//            st.show();
//        }
//    }
    
    @FXML
    void back(ActionEvent event){
        try {

            AnchorPane pane=FXMLLoader.load(getClass().getResource("/view/FXMLDocument.fxml"));
            rootpane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       Adminpassword.setOnKeyPressed((KeyEvent e)->{
           switch (e.getCode()) {
               case ENTER:
           {
               try {
                   Checkpassword();
               } catch (IOException ex) {
                   Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
               } catch (InterruptedException ex) {
                   Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
                   break;
               default:
                 break;
           }
       });
    }    
    
}

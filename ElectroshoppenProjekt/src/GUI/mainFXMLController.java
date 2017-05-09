/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author MER
 */
public class mainFXMLController implements Initializable {

    @FXML
    private Button loginBTN;
    @FXML
    private Button registerBTN;
    @FXML
    private AnchorPane mainPane;
    
    
    @FXML
    public void goToLogin(ActionEvent e) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("loginFXML.fxml"));
            mainPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(mainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

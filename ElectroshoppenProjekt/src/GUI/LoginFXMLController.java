/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Authentication.Login;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import elecetroshoppenprojekt.Authenticateable;
import elecetroshoppenprojekt.Webshop;

/**
 * FXML Controller class
 *
 * @author MER
 */
public class LoginFXMLController implements Initializable {
    
    private Authenticateable authenticate;
    
    @FXML
    private TextField userField;
    @FXML
    private TextField passField;
    @FXML
    private Button loginBTN;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.authenticate = new Webshop();
    }    

    @FXML
    private void login(ActionEvent event) {
        
        this.authenticate.newLogin(this.userField.getText(), this.passField.getText());
        this.authenticate.doLogin();
    }
    
}
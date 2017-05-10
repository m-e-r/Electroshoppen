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
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author MER
 */
public class LoginFXMLController implements Initializable {
    
    private Authenticateable authenticate;
    private ToolBarFXMLController fxml = new ToolBarFXMLController();
    
    
    @FXML
    private TextField userField;
    @FXML
    private Button loginBTN;
    @FXML
    private Label errorLabel1;
    @FXML
    private AnchorPane mainPane;
    protected GridPane mainGrid;
    @FXML
    private PasswordField passField;
    
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
        
        if (!this.authenticate.doLogin()) {
            this.errorLabel1.setText("Brugernavn eller adgangskode forkert");
            
        } else {
          AnchorPane pane;
            try {
                pane = FXMLLoader.load(getClass().getResource("productFXML.fxml"));
                mainPane.getChildren().setAll(pane);
                
                
            }   catch (IOException ex) {
                Logger.getLogger(ToolBarFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
//        this.userField.clear();
//        this.passField.clear();
    }
}
    

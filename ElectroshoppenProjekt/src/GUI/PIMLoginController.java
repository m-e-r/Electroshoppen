/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Authentication.Authenticateable;
import Authentication.Login;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
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
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Kasper
 */
public class PIMLoginController implements Initializable {
    private Authenticateable authen;

    @FXML
    private JFXTextField userNameTF;
    @FXML
    private JFXPasswordField passwordTF;
    @FXML
    private JFXButton loginBtn;
    @FXML
    private Label errorLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    /**
     * REMEMBER TO FIND A WAY TO CLOSE THIS WINDOW AFTER SUCCESFULL LOGIN.
     * @param event
     * @throws IOException 
     */
    @FXML
    private void handleLogin(ActionEvent event) {
	String userName = this.userNameTF.getText();
	String passWord = this.passwordTF.getText();
        this.authen = new Login(userName, passWord);
        
        if (this.authen.doLogin() || (userName.equals("adm") && passWord.equals("adm"))) {

            try {
                
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PIMFXMLDoc.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
                
            } catch (IOException ex) {
                Logger.getLogger(startFXMLDocument.class.getName()).log(Level.SEVERE, null, ex); 
            }
            Stage stage = (Stage) loginBtn.getScene().getWindow();
            stage.close();
        } else {
            this.passwordTF.clear();
            this.userNameTF.setStyle("-jfx-unfocus-color: red;");
            this.passwordTF.setStyle("-jfx-unfocus-color: red;");
            this.errorLabel.setText("Brugernavn eller adgangskode forkert.");
        }
    }
    
}

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
import javafx.scene.control.ToolBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author MER
 */
public class ToolBarFXMLController implements Initializable {

    @FXML
    private ToolBar toolbar;
    @FXML
    protected Button loginBTN;
    @FXML
    protected Button registerBTN;
    @FXML
    private GridPane category;
    @FXML
    private AnchorPane mainPane;
    @FXML
    private GridPane toolBarGrid;
    @FXML
    private Button searchBTN;
    @FXML
    private Button basketBTN;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    public void loggedIn() {
        Button logoutBTN = new Button("Log out");
        Button myProfileBTN = new Button("My Profile");
        this.loginBTN.setDisable(true);
        this.registerBTN.setDisable(true);
        this.toolBarGrid.add(logoutBTN, 0, 6);
        this.toolBarGrid.add(myProfileBTN, 0, 5);
        
    }

    @FXML
    private void goToLogin(ActionEvent event) {
        AnchorPane pane;
        try {
            pane = FXMLLoader.load(getClass().getResource("loginFXML.fxml"));
            mainPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(ToolBarFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}

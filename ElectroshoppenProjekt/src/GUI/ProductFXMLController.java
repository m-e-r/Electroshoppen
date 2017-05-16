/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author MER
 */
public class ProductFXMLController implements Initializable {

    @FXML
    private ImageView productIV;
    @FXML
    private TextArea productTA;
    @FXML
    private Button addBTN;
    @FXML
    private Button gobackBTN;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.gobackBTN.setStyle("-fx-background-image: url(arrow.PNG");
    }    

    @FXML
    private void addToBasket(ActionEvent event) {
    }

    @FXML
    private void goToProducts(ActionEvent event) {
    }
    
}

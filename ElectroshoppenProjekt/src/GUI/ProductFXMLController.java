/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Facade.Facade;
import Facade.iFacade;
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
    iFacade facade;
    private long productId;
    
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
        this.facade = new Facade();

    }
    
    
    
    @FXML
    private void addToBasket(ActionEvent event) {
    }
    
    public void goBackToProducts (ActionEvent event) {
        
    }
    
    public void setProductId(long id) {
        this.productId = id;
        String [] s = facade.searchProduct(productId).toString().split(";");
        
        for (int i = 0; i < s.length -1; i++) {
            this.productTA.appendText(s[i]);
        }
    }
    
    }

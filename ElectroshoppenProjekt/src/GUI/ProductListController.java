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
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Tobias Dahl
 */
public class ProductListController implements Initializable {
    ObservableList<?> products;
    ObservableList<?> categories;
    
    private iFacade facade;
    
    @FXML
    private ListView<?> productList;
    @FXML
    private ListView<?> categoryList;
    @FXML
    private TextField searchTextfield;
   
    /**
     * Initializes the controller class.
     */
    
    public void initialize(URL url, ResourceBundle rb) {
        this.facade = new Facade();        
        
        this.products = FXCollections.observableArrayList();
        this.categories = FXCollections.observableArrayList();
             
        
    }    
    
    /**
     * Eksempel på brug af interfacet uden at kende til Product klassen.
     */
    public void setTextField() {
        searchTextfield.setText(facade.searchProduct(0).getProductName());
    }

    
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import ProductStuff.Product;
import ProductStuff.ProductCatalog;
import ProductStuff.ProductCategory;
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
    ObservableList<Product> products;
    ObservableList<ProductCategory> categories;
    
    @FXML
    private ListView<Product> productList;
    @FXML
    private ListView<ProductCategory> categoryList;
    @FXML
    private TextField searchTextfield;
   
    /**
     * Initializes the controller class.
     */
    
    public void initialize(URL url, ResourceBundle rb) {
        ProductCatalog productCat = new ProductCatalog();
        
        
        this.products = FXCollections.observableArrayList();
        this.categories = FXCollections.observableArrayList();
        
        this.productList = new ListView<Product>();
        this.productList.setItems(products);
       
        this.categoryList = new ListView<ProductCategory>();
        this.categoryList.setItems(categories);
        
        
        
    }    

    
    
    
    
}

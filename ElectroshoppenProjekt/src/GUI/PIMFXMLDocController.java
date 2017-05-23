/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Facade.Facade;
import Facade.iFacade;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Jacob
 */
public class PIMFXMLDocController implements Initializable {
    private iFacade facade;
    private ObservableList<String> productsNameForView;
    private ArrayList<?> productsFromSearch;
    private HashMap<Long, String[]> productsById;
    
    
    @FXML
    private ListView<String> productsLV;
    @FXML
    private TextField searchTF;   
    @FXML
    private JFXButton serchBTN;
    @FXML
    private TextArea productInfoTA;
    @FXML
    private TextField nameTF;
    @FXML
    private TextField priceTF;
    @FXML
    private TextField descriptionTF;
    @FXML
    private JFXButton changeBtn;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.facade = new Facade();
        this.productsById = new HashMap();
        
    }    
    
    
    /**
     * Fills the lists and shows results in the listview.
     * @param event 
     */
    @FXML
    private void handleSearch() {
        this.productsFromSearch = new ArrayList(this.facade.searchProductsFromText(this.searchTF.getText()));
        this.productsNameForView = FXCollections.observableArrayList();

        
        
        for (int i = 0; i < this.productsFromSearch.size(); i++) {
            String[] productInfo = this.productsFromSearch.get(i).toString().split(";");

            this.productsById.put(Long.parseLong(productInfo[4]), productInfo);
            this.productsNameForView.add(productInfo[4] + "\t" + productInfo[0]);
        }
        
        this.productsLV.setItems(this.productsNameForView);
        
        System.out.println(this.productsFromSearch);
    }
    
    
    /**
     * Sets the product information in the textarea when a product is selected
     * in the listview.
     * @param event 
     */
    @FXML
    private void handleShowProduct() {
        String selectedProduct = this.productsLV.getSelectionModel().getSelectedItem();
        long productNumber = Long.parseLong(selectedProduct.split("\t")[0]);
        
        String[] productInfo = this.productsById.get(productNumber);
        
        //Set the text up nicely
        StringBuilder str = new StringBuilder();
        str.append("Produkt nummer: ")
            .append(productInfo[4])
            .append("\n")
                
            .append("Navn: ")
            .append(productInfo[0])
            .append("\n")
        
            .append("Pris: ")
            .append(productInfo[1])
            .append("\n")
        
            .append("Kategori: ")
            .append(productInfo[3])
            .append("\n")
        
            
                
            .append("Beskrivelse: ")
            .append(productInfo[2]);
        
        String productShow = new String(str);
        this.productInfoTA.setText(productShow);
     
    }

    @FXML
    private void handleChangeProduct(ActionEvent event) {
        String selectedProduct = this.productsLV.getSelectionModel().getSelectedItem();
        long productNumber = Long.parseLong(selectedProduct.split("\t")[0]);
        
        String name = this.nameTF.getText();
        String price = this.priceTF.getText();
        String description = this.descriptionTF.getText();

        if (!name.equals("")) {
            this.productsById.get(productNumber)[0] = name;
            this.facade.editName(productNumber, name);
            
            this.handleShowProduct();
        }
        
        if (!price.equals("")) {
            this.productsById.get(productNumber)[1] = price;
            this.facade.editPrice(productNumber, Double.parseDouble(price));
            
            this.handleShowProduct();
        }
        
        if (!description.equals("")) {
            this.productsById.get(productNumber)[2] = description;
            this.facade.editDescription(productNumber, description);
            
            this.handleShowProduct();
        }
    }
    

    
}

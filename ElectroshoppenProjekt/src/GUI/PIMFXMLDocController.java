/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Facade.Facade;
import Facade.iFacade;
import ProductStuff.ProductCategory;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.DoubleValidator;
import com.jfoenix.validation.NumberValidator;
import com.jfoenix.validation.RequiredFieldValidator;
import java.awt.Paint;
import static java.lang.Math.abs;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javax.swing.Icon;

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
    private RequiredFieldValidator textValidator;
    private DoubleValidator doubleValidator;
    
    private long crId;
    private String crName, crDescription, category;
    private double crPrice;
    private ProductCategory crCategory;
    private ArrayList<ProductCategory> categories;
    
    
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
    private JFXButton changeBtn;
    @FXML
    private TextArea descriptionTA;
    @FXML
    private JFXTextField createNameTF;
    @FXML
    private JFXTextField createPriceTF;
    @FXML
    private JFXTextArea createDescriptionTA;
    @FXML
    private JFXComboBox<ProductCategory> createCategoryBox;
    @FXML
    private JFXTextArea createShowTA;
    @FXML
    private JFXButton createCheckBtn;
    @FXML
    private JFXButton createAddBtn;
    @FXML
    private JFXTextField crIdTF;
    @FXML
    private JFXButton crIdGenBtn;
    @FXML
    private Label createLabel;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.facade = new Facade();
        this.productsById = new HashMap();
        this.createAddBtn.setDisable(true);
        this.categories = new ArrayList();
        this.handleIdGenerate();

        
        //Fill category box
        for (ProductCategory pc : ProductCategory.values()) {
            this.categories.add(pc);
        }
        this.createCategoryBox.getItems().addAll(this.categories);
        
    }    
    
    
    /**
     * Set up the product nicely in text.
     * @return 
     */
    private String displayProduct() {
        StringBuilder str = new StringBuilder();
        str.append("Produkt nummer: ")
            .append(this.crId)
            .append("\n")
                
            .append("Navn: ")
            .append(this.crName)
            .append("\n")
        
            .append("Pris: ")
            .append(this.crPrice)
            .append("kr.")
            .append("\n")
        
            .append("Kategori: ")
            .append(this.category)
            .append("\n")
                        
            .append("Beskrivelse: ")
            .append(this.crDescription);
        
        String productShow = new String(str);
        return productShow;
    }
    
    //MARK: Edit methods
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
        this.crName = productInfo[0];
        this.crId = Long.parseLong(productInfo[4]);
        this.crPrice = Double.parseDouble(productInfo[1]);
        this.category = productInfo[3];
        this.crDescription = productInfo[2];
        
        //Set the text up nicely

        this.productInfoTA.setText(this.displayProduct());
     
    }
    
    
    @FXML
    private void handleChangeProduct(ActionEvent event) {
        String selectedProduct = this.productsLV.getSelectionModel().getSelectedItem();
        long productNumber = Long.parseLong(selectedProduct.split("\t")[0]);
        
        String name = this.nameTF.getText();
        String price = this.priceTF.getText();
        String description = this.descriptionTA.getText();

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
    
    
    
    
    
    
    
    
    
    
    //MARK: Create methods
    @FXML
    private boolean handleCreateCheck() {
        this.createLabel.setText("Preview");
        
        if (this.validateName() & this.validatePrice() & this.validateDescription() & this.validateCategory()) {
            this.createAddBtn.setDisable(false);
            this.createShowTA.clear();
            this.createShowTA.setText(this.displayProduct());
            return true;
            
        } else {
            this.createAddBtn.setDisable(true);
            return false;
        }
    }
    

    //Validator methods used in handleCreateCheck()
    private boolean validateId() {
//        this.numberValidator = new NumberValidator();
//        this.textValidator = new
//        this.numberValidator.setMessage("Skal være et tal!");
//        this.createIdTF.getValidators().add(this.numberValidator);

//        try {
//            this.crId = Long.parseLong(this.createIdTF.getText());
//            System.out.println(this.createIdTF.getText());
//        } catch (NumberFormatException e) {
//            this.createIdTF.clear();
//            this.createIdTF.setStyle("-jfx-unfocus-color: red;");
//            this.createIdTF.validate();
//            this.createIdTF.getActiveValidator().setMessage("Skal være et tal!");            
//            System.out.println("Could NOT parse");
//            return false;
//        }
        
//        if (this.createIdTF.validate()) {       
//
//            if (this.facade.searchProduct(this.crId) != null) {           
//                this.createIdTF.clear();
//                this.createIdTF.setStyle("-jfx-unfocus-color: red;");
//                this.createIdTF.validate();
//                this.createIdTF.getActiveValidator().setMessage("Produktnummer " + this.crId + " findes allerede");
//                System.out.println("Did find product");
//                return false;
//
//            } else {
//                this.createIdTF.setStyle("-jfx-unfocus-color: ;");
//                this.createIdTF.validate();
//                System.out.println("Did NOT find product");
//                return true;
//            }   
//            
//        } else {
//            return false;
//        }

        return true;
    }
    
    private boolean validateName() {
        this.textValidator = new RequiredFieldValidator();
        this.textValidator.setStyle("-jfx-text-inner-color: red;");        
        this.textValidator.setMessage("Mangler navn!");
        
        this.createNameTF.getValidators().add(this.textValidator);

        if (!this.createNameTF.validate()) {
            this.createNameTF.setStyle("-jfx-unfocus-color: red;");
            this.createNameTF.clear();
            this.crName = "";
            return false;
            
        } else {
            this.createNameTF.setStyle("-jfx-unfocus-color: green;");
            this.crName = this.createNameTF.getText();
            return true;
        }        
    }
    
    private boolean validatePrice() {
        this.doubleValidator = new DoubleValidator();
        this.doubleValidator.setStyle("-jfx-text-inner-color: red;"); 
        this.doubleValidator.setMessage("Format: 299.95");
        
        this.createPriceTF.getValidators().add(this.doubleValidator);
        
        if (!this.createPriceTF.validate()) {
            this.createPriceTF.setStyle("-jfx-unfocus-color: red;");
            this.createPriceTF.clear();
            this.crPrice = 0;
            return false;
            
        } else {
            this.createPriceTF.setStyle("-jfx-unfocus-color: green;");
            this.crPrice = Double.parseDouble(this.createPriceTF.getText());
            return true;
        }
    }
    
    private boolean validateDescription() {
        this.textValidator = new RequiredFieldValidator();
        this.textValidator.setStyle("-jfx-text-inner-color: red;");        
        this.textValidator.setMessage("Mangler beskrivelse!");
        
        this.createDescriptionTA.getValidators().add(this.textValidator);

        if (!this.createDescriptionTA.validate()) {
            this.createDescriptionTA.setStyle("-jfx-unfocus-color: red;");
            this.createDescriptionTA.clear();
            this.crDescription = "";
            return false;
            
        } else {
            this.createDescriptionTA.setStyle("-jfx-unfocus-color: green;");
            this.crDescription = this.createDescriptionTA.getText();
            return true;
        }  
    }
    
    private boolean validateCategory() {
        this.crCategory = this.createCategoryBox.getSelectionModel().getSelectedItem();
        
        if (this.crCategory == null) {
            this.createCategoryBox.setStyle("-jfx-unfocus-color: red;");
            this.category = null;
            return false;
            
        } else {
            this.createCategoryBox.setStyle("-jfx-unfocus-color: green;");
            this.category = this.crCategory.toString();
            return true;
        }
    }

    
    /**
     * Generates a new random id and sets it.
     */
    @FXML
    private void handleIdGenerate() {
        do {
            this.crId = Math.abs(this.crId = new Random().nextLong() / new Date().getTime());
            
        } while (this.facade.searchProduct(this.crId) != null);
        this.crIdTF.setText(String.valueOf(this.crId));
    }
    
    
    /**
     * Creates the product and saves it to the database.
     * @param event 
     */
    @FXML
    private void handleCreateAdd(ActionEvent event) {
        
        if (this.handleCreateCheck()) {
            this.facade.newProduct(this.crName, this.crId, this.crPrice, this.crDescription, this.crCategory);
            this.facade.addProductToDatabase();
            this.createNameTF.clear();
            this.createPriceTF.clear();
            this.createDescriptionTA.clear();
            this.handleIdGenerate();
            this.createLabel.setText("Produktet er tilføjet!");
            
        } else {
            System.out.println("nej");
        }


    }

    

    
}

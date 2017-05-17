/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Facade.Facade;
import Facade.iFacade;
import com.jfoenix.controls.JFXToggleButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author MER
 */
public class FxmlDocumentController implements Initializable {
    
    iFacade facade;
    ObservableList<?> products;
    ObservableList<?> categories;
    
    @FXML
    private AnchorPane mainPane;
    @FXML
    private TabPane tabPane;
    @FXML
    private Tab productTab;
    @FXML
    private ScrollPane productScroll;
    @FXML
    private GridPane productGrid;
    @FXML
    private Tab loginTab;
    @FXML
    private Tab registerTab;
    @FXML
    private Label phoneLabel;
    @FXML
    private Label codeLabel;
    @FXML
    private Button loginBTN;
    @FXML
    private Button searchBTN;
    @FXML
    private Button registerBTN;
    @FXML
    private TextField fNameTF;
    @FXML
    private TextField mailTF;
    @FXML
    private TextField lNameTF;
    @FXML
    private TextField regPhoneTF;
    @FXML
    private TextField adressTF;
    @FXML
    private TextField postnrTF;
    @FXML
    private TextField cityTF;
    @FXML
    private TextField searchTF;
    @FXML
    private GridPane loginGrid;
    @FXML
    private GridPane registerGrid;
    @FXML
    private TextField logPhoneTF;
    @FXML
    private TextField logPassTF;
    @FXML
    private JFXToggleButton toggleCustomer;
    @FXML
    private Button productBTN;
    @FXML
    private Label productLabel;
    @FXML
    private GridPane pGrid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.facade = new Facade();
        
    }    
    
//    private void updateProducts () {
//        for (int i = 0; i < this.products; i++) {
//            this.productLabel.setText(this.products.get(i).getName());
//            this.pGrid.add(this.productLabel, 0, 1);
//            this.productGrid.add(this.pGrid, i, i);
//        }
//    }
    
    @FXML
    private void searchProducts(ActionEvent event) {
        this.products = (ObservableList<?>) facade.searchProductsFromText(this.searchTF.getText());
//        for (int i = 0; i < this.products; i++) {
//            this.products.get(i).
//        }
    }

    @FXML
    private void login(Event event) {
        
//        this.webshop.newLogin(this.logPhoneTF.getText(), this.logPassTF.getText());
//        
//        if (this.webshop.doLogin()) {
//            this.tabPane.getSelectionModel().select(0);
//        } else {
//            Label label = new Label("Det indtastede telefonnr. eller kode er forkert. Venligst prøv igen");
//            this.loginGrid.add(label, 4, 2);
//        }
    }

    @FXML
    private void register(ActionEvent event) {
        
    }
    
    @FXML
    private void goToProducts(ActionEvent event) {
        AnchorPane pane;
        try {
            pane = FXMLLoader.load(getClass().getResource("productFXML.fxml"));
            mainPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(FxmlDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Authentication.Authenticateable;
import Authentication.Create;
import Authentication.Login;
import Facade.Facade;
import Facade.iFacade;
import WEBSHOP.Address;
import com.jfoenix.controls.JFXToggleButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author MER
 */
public class webshopFXMLController implements Initializable {
    Authenticateable authen;
    iFacade facade;
    
    ObservableList<?> products;
    ObservableList<?> categories;
    ObservableList<?> loginNodes;
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
    private TextField addressTF;
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
    private TextArea productTA;
    @FXML
    private GridPane pGrid;
    @FXML
    private Button pBTN;
    @FXML
    private TextField numberTF;
    @FXML
    private TextField addressTF2;
    @FXML
    private PasswordField regPassField;
    @FXML
    private TextField cvrTF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.facade = new Facade();
//        this.toggleCustomer.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                
//            }
//        });
        
    }    
    
//    private void updateProducts () {
//        for (int i = 0; i < this.products; i++) {
//            this.productLabel.setText(this.products.get(i).getName());
//            this.pGrid.add(this.productLabel, 0, 1);
//            this.productGrid.add(this.pGrid, i, i);
//        }
//    }
    
    public void buisnessAccount() {
        if (this.registerGrid.getChildren().contains(cvrTF)) {
            this.registerGrid.getChildren().remove(cvrTF);
        } else {
            cvrTF = new TextField();
            this.registerGrid.add(cvrTF, 3, 1);
        }
        
        
    }
    
    @FXML
    private void searchProducts(ActionEvent event) {
        this.productGrid.getChildren().clear();
        this.products = FXCollections.observableArrayList(facade.searchProductsFromText(this.searchTF.getText()));
        int c1 = 0;
        int c2 = 0;
        for (int i = 0; i < this.products.size(); i++) {
            String[] s = this.products.get(i).toString().split(";");
            GridPane gp = null;
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pFXML.fxml"));
                gp = (GridPane) fxmlLoader.load();
                
            } catch (IOException ex) {
                Logger.getLogger(webshopFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            this.productGrid.add(gp, c2, c1);
            Button b = (Button) gp.getChildren().get(2);
            b.setUserData(s[4]);
            b.setStyle("-fx-background-color: transparent");
            b.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    goToProduct(Long.parseLong((String) b.getUserData()));
                }
            });
            TextArea ta = (TextArea) gp.getChildren().get(0);
            ta.appendText(s[0]);
            ta.appendText(s[1]);
            
            c2++;
            if (c2 == productGrid.getColumnConstraints().size()) {
                c1++;
                c2 = 0;
            }
        }
    }

    @FXML
    private void login(Event event) {
        this.loginNodes = this.loginGrid.getChildren();
        
        this.authen = new Login(this.logPhoneTF.getText(), this.logPassTF.getText());
        
        if (this.authen.doLogin()) {
            this.tabPane.getSelectionModel().select(0);
            this.loginGrid.getChildren().clear();
            //this.facade.getProfile().toString();
//            Button logoutBTN = new Button("Log ud");
//            logoutBTN.setOnAction(new EventHandler<ActionEvent>() {
//                @Override
//                public void handle(ActionEvent event) {
//                    facade.logout();
//                }
//            });
        } else {
            Label label = new Label("Det indtastede telefonnr. eller kode er forkert. Venligst prøv igen");
            this.loginGrid.add(label, 2, 4);
        }
        
    }
    
    @FXML
    private void register(ActionEvent event) {
        Address address;
        this.authen.createUser("customer");
        if (!this.registerGrid.getChildren().contains(cvrTF)) {
            this.registerGrid.add(cvrTF, 0, 0);
            this.cvrTF.clear();
            this.cvrTF.setStyle("-fx-background-color: transparent");
        }
        
        String[] s = new String[this.registerGrid.getChildren().size() - 10];
            for (int i = 9; i < this.registerGrid.getChildren().size() - 10; i++) {
                TextField textfield = (TextField) this.registerGrid.getChildren().get(i);
                s[i] = textfield.getText();
            }
        if (this.addressTF2.getText() == null) {
            address = new Address(s[4], s[5], s[7], s[8]);
        } else {
            address = new Address(s[4], s[5], s[6], s[7], s[8]);
        }
        this.authen = new Create(s[0], s[1], s[2], s[3], address, s[9], s[10]);
    }
    
    @FXML
    public void goToProduct(long productNr) {
        AnchorPane pane;
        try {
            FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("productFXML.fxml"));
            pane = (AnchorPane) fxmlLoader1.load();
            ProductFXMLController controller=fxmlLoader1.<ProductFXMLController>getController();
            controller.setProductId(productNr);
            this.mainPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(webshopFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
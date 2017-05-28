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
import WEBSHOP.iWebshop;
import com.jfoenix.controls.JFXToggleButton;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
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
import javafx.scene.Node;
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

    private Authenticateable authen;
    public iFacade facade;

    iWebshop webshop;

    ObservableList<?> products;
    ObservableList<?> categories;
    ObservableList<Node> loginNodes;
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
    private TextField logMailTF;
    @FXML
    private PasswordField logPF;
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
    private Button logoutBTN;
    @FXML
    private TextField addressTF2;
    @FXML
    private PasswordField regPassField;
    @FXML
    private TextField cvrTF;
    @FXML
    private Button basketBTN;
    @FXML
    private TextField pFnameTF;
    @FXML
    private TextField pLnameTF;
    @FXML
    private TextField pMailTF;
    @FXML
    private TextField pPhoneTF;
    @FXML
    private TextField pAddressTF;
    @FXML
    private TextField pNumberTF;
    @FXML
    private TextField pAdressTF2;
    @FXML
    private TextField pPostnrTF;
    @FXML
    private TextField pCityTF;
    @FXML
    private Tab profileTab;
    @FXML
    private GridPane profileGrid;
    @FXML
    private Label lbl;
            
     /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
	this.facade = WebshopFacade.getInstance().getFacade();
        System.out.println("Facade!");
	logMailTF.setText("mail2@mail2.dk");
	logPF.setText("pass");
        this.lbl = new Label();
        this.registerGrid.add(lbl, 3, 10, 2, 1);
	

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
	    this.cvrTF = new TextField();
	    this.cvrTF.setPromptText("CVR Nummer");
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
	
	//START
        this.authen = new Login(this.logMailTF.getText(), this.logPF.getText());
        
        if (this.authen.doLogin() != null) {
            TextArea ta = new TextArea();
            this.profileGrid.add(ta, 1, 0, 2, 1);
	    String[] customer = new String[4];
	    customer = facade.getCustomerInfo(this.logMailTF.getText());
	    String[] description = {"Navn: ", "Email: ", "Telefon: ", "CVR: "};
            
	    for (int i = 0; i < customer.length; i++) {
		ta.appendText(description[i] + customer[i] + "\n\n");
	    }
            
            this.facade.setLoginForCustomer(this.authen.doLogin());
            System.out.println("GUI " + this.authen.doLogin());
            this.loginTab.setDisable(true);
            this.profileTab.setDisable(false);
            this.registerTab.setDisable(true);
            this.logMailTF.setText("");
            this.logPF.setText("");
            
            
        } else {
            Label label = new Label("Den indtastede E-Mail eller kode er forkert. Venligst prøv igen");
            this.loginGrid.add(label, 2, 4, 2, 1);
            this.logPF.setText("");
        }
    }

    @FXML
    private void logout() {
        if (this.authen.doLogout()) {
            this.loginTab.setDisable(false);
            this.registerTab.setDisable(false);
        }
    }
    
    @FXML
    private void register(ActionEvent event) {
	Address address;
	TextField[] tfs = new TextField[11];
	if (!this.registerGrid.getChildren().contains(cvrTF)) {
	    this.cvrTF = new TextField();
	    this.registerGrid.add(cvrTF, 0, 0);
	    this.cvrTF.clear();
	    this.cvrTF.setStyle("-fx-background-color: transparent");
	}

	if (!this.mailTF.getText().contains("@") || !this.mailTF.getText().contains(".")) {
	    Label label = new Label("Ugyldig E-Mail");
	    label.setStyle("-fx-text-fill: RED");
	    this.registerGrid.add(label, 3, 3);
	} else {

	    tfs[0] = this.fNameTF;
	    tfs[1] = this.lNameTF;
	    tfs[2] = this.mailTF;
	    tfs[3] = this.regPhoneTF;
	    tfs[4] = this.addressTF;
	    tfs[5] = this.numberTF;
	    tfs[6] = this.addressTF2;
	    tfs[7] = this.postnrTF;
	    tfs[8] = this.cityTF;
	    tfs[9] = this.regPassField;
	    tfs[10] = this.cvrTF;

	    if (this.addressTF2 == null) {
		address = new Address(tfs[4].getText(), tfs[5].getText(), tfs[7].getText(),
			tfs[8].getText());
	    } else {
		address = new Address(tfs[4].getText(), tfs[5].getText(), tfs[6].getText(),
			tfs[7].getText(), tfs[8].getText());
	    }
            
	    this.authen = new Create(tfs[0].getText() + " " + tfs[1].getText(), tfs[2].getText(),
		    tfs[3].getText(), address, tfs[9].getText(), tfs[10].getText());
            
	    if (this.getAuthen().createUser("customer")) {              
                lbl.setText("Brugeren er oprettet.");
		this.authen = new Login(tfs[2].getText(), tfs[9].getText());
		this.getAuthen().doLogin();
	    } else {
                lbl.setText("De indtastede oplysninger er ugyldige eller brugeren findes allerede");
	    }
	}
    }

    @FXML
    private void showBasket(ActionEvent event) {
	TextArea ta = new TextArea();
	this.mainPane.getChildren().add(ta);
	ta.setEditable(false);
	ta.appendText(this.facade.showBasket());
	this.basketBTN.setOnAction(new EventHandler<ActionEvent>() {
	    @Override
	    public void handle(ActionEvent event) {
		closeBasket(event, ta);
	    }
	});
    }

    @FXML
    private void closeBasket(ActionEvent event, TextArea ta) {
	this.mainPane.getChildren().remove(ta);
	this.basketBTN.setOnAction(new EventHandler<ActionEvent>() {
	    @Override
	    public void handle(ActionEvent event) {
		showBasket(event);
	    }
	});
    }

    @FXML
    private void updateProfile(ActionEvent event) {
        Address address;
        if (this.addressTF2 == null) {
                address = new Address(this.pAddressTF.getText(), this.pNumberTF.getText(), this.pPostnrTF.getText(),
                        this.pCityTF.getText());
            } else {
                address = new Address(this.pAddressTF.getText(), this.pNumberTF.getText(), 
                        this.pAdressTF2.getText(), this.pPostnrTF.getText(), this.pCityTF.getText());
            }
        this.webshop.updateProfile(this.pFnameTF.getText() +" "+ this.pLnameTF.getText(), 
                this.pMailTF.getText(), this.pPhoneTF.getText(), " ");
    }
    
    @FXML
    public void goToProduct(long productNr) {
	AnchorPane pane;
	try {
	    FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("productFXML.fxml"));
	    pane = (AnchorPane) fxmlLoader1.load();
	    ProductFXMLController controller = fxmlLoader1.<ProductFXMLController>getController();
	    controller.setProductId(productNr);
	    this.mainPane.getChildren().setAll(pane);
	} catch (IOException ex) {
	    Logger.getLogger(webshopFXMLController.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    /**
     * @return the authen
     */
    public Authenticateable getAuthen() {
	return authen;
    }
    
    

}

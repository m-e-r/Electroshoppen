/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Authentication.Authenticateable;
import Authentication.Create;
import Authentication.Login;
import Facade.iFacade;
import com.jfoenix.controls.JFXToggleButton;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author MER
 */
public class webshopFXMLController implements Initializable {

    private static Authenticateable authen;
    public static iFacade facade;
    
    
    ObservableList<?> products;
    ObservableList<?> categories;
    ObservableList<Node> loginNodes;
    private ObservableList<String> orderLinesForView;
    private ObservableList<String> ordersForView;
    private HashMap<String, ArrayList<String>> orderLinesByOrder;
    
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
    private TextField numberTF;
    @FXML
    private Button logoutBTN;
    private TextField addressTF2;
    @FXML
    private PasswordField regPassField;
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
    private Label lbl;
    private TextField pCVRtf;
    @FXML
    private Label pCVRl;
    @FXML
    private Button updateBTN;

    private static String currentUserEmail = "";
    @FXML
    private TextField adressTF2;
    @FXML
    private ListView<String> ordersLV;
    @FXML
    private ListView<String> orderLinesLV;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
	this.facade = WebshopFacade.getInstance().getFacade();
	this.lbl = new Label();
	this.registerGrid.add(lbl, 3, 10, 2, 1);
	addressTF2 = new TextField();
	addressTF2.setText("");
        this.orderLinesForView = FXCollections.observableArrayList();
        this.ordersForView = FXCollections.observableArrayList();

    }

    @FXML
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

    public void afterLogin() {
        System.out.println(facade.isValid());
	if (facade.isValid()) {
	    String[] customer = facade.getCustomerInfo(currentUserEmail);
	    String[] address = facade.getAddressArray(currentUserEmail);
	    String[] fullArray = new String[customer.length + address.length];
	    for (int i = 0, j = customer.length; i < customer.length; i++, j++) {

		fullArray[i] = customer[i];
		fullArray[j] = address[i];

	    }

	    TextField[] tfs = new TextField[10];
	    tfs[0] = this.pFnameTF;
	    tfs[1] = this.pLnameTF;
	    tfs[2] = this.pMailTF;
	    tfs[3] = this.pPhoneTF;
	    tfs[5] = this.pAddressTF;
	    tfs[6] = this.pNumberTF;
	    tfs[7] = this.pAdressTF2;
	    tfs[8] = this.pPostnrTF;
	    tfs[9] = this.pCityTF;

	    this.loginTab.setDisable(true);
	    this.profileTab.setDisable(false);
	    this.registerTab.setDisable(true);

	    if (!customer[4].equals("") || customer[4] != null)  {
                System.out.println("Her: " + customer[4] + "..");
		pCVRtf = new TextField();
		tfs[4] = pCVRtf;
		this.profileGrid.add(pCVRtf, 1, 9);
		pCVRl.setVisible(true);
	    }
	    int i = 0;
	    for (TextField tf : tfs) {
		tf.setText(fullArray[i]);
		i++;
	    }

	    this.tabPane.getSelectionModel().select(productTab);
	    this.logMailTF.setText("");
	    this.logPF.setText("");
            
            
            //Orders
            this.orderLinesByOrder = facade.getOrderLinesByOrder(currentUserEmail);
            this.ordersForView.addAll(this.orderLinesByOrder.keySet());
            this.ordersLV.setItems(this.ordersForView);
            
	}
    }

//    public String getEmailLogin(){
//	return currentUserEmail;
//    }
    @FXML
    private void login(Event event) {

	//START
	this.authen = new Login(this.logMailTF.getText(), this.logPF.getText());

	if (this.authen.doLogin() != null) {
            this.facade.setLoginForCustomer(this.authen.doLogin());
	    this.currentUserEmail = this.logMailTF.getText();
	    this.facade.setCustomerEmail(currentUserEmail);
	    this.afterLogin();

	} else {
	    Label label = new Label("Den indtastede E-Mail eller kode er forkert. Venligst prøv igen");
	    this.loginGrid.add(label, 2, 4, 2, 1);
	    this.logPF.setText("");
	}
    }

    @FXML
    private void logout() {

	if (this.authen.doLogout()) {
	    this.currentUserEmail = "";
	    this.loginTab.setDisable(false);
	    this.registerTab.setDisable(false);
	    this.tabPane.getSelectionModel().select(productTab);
	    this.profileTab.setDisable(true);
	    this.facade.setNewCustomer();
	}
    }

    @FXML
    private void register(ActionEvent event) {

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

	    this.facade.setAddress(tfs[4].getText(), tfs[5].getText(), tfs[6].getText(), tfs[7].getText(),
		    tfs[8].getText());

	    this.authen = new Create(tfs[0].getText() + ";" + tfs[1].getText(), tfs[2].getText(),
		    tfs[3].getText(), this.facade.getAddress(), tfs[9].getText(), tfs[10].getText());

	    if (this.getAuthen().createUser("customer")) {
		lbl.setText("Brugeren er oprettet.");
		this.authen = new Login(tfs[2].getText(), tfs[9].getText());
		this.getAuthen().doLogin();
		this.facade.setLoginForCustomer(this.authen.doLogin());
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
	this.facade.setAddress(this.pAddressTF.getText(), this.pNumberTF.getText(), this.pAdressTF2.getText(), this.pPostnrTF.getText(),
		this.pCityTF.getText());
	this.facade.updateProfile(this.pFnameTF.getText() + ";" + this.pLnameTF.getText(),
		this.pMailTF.getText(), this.pPhoneTF.getText(), this.pCVRtf.getText());
    }

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

    @FXML
    private void handleOrderChoice(MouseEvent event) {
        String chosenOrder = this.ordersLV.getSelectionModel().getSelectedItem();

        this.orderLinesForView.clear();
        this.orderLinesForView.addAll(this.orderLinesByOrder.get(chosenOrder));
        this.orderLinesLV.setItems(this.orderLinesForView); 
    }
}

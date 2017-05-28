/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Facade.Facade;
import Facade.iFacade;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author MER
 */
public class ProductFXMLController implements Initializable {

    private long productId;
    private iFacade facade;
    

    @FXML
    private ImageView productIV;
    @FXML
    private TextArea productTA;
    @FXML
    private Button addBTN;
    @FXML
    private Button gobackBTN;
    @FXML
    private AnchorPane mainPane;
    @FXML
    private TextField amountTF;
    @FXML
    private GridPane mainGrid;
    @FXML
    private Button basketBTN;
    @FXML
    private ImageView gobackIV;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.facade = WebshopFacade.getInstance().getFacade();

    }

    @FXML
    private void addToBasket(ActionEvent event) {
	if (this.amountTF == null || "".equals(this.amountTF.getText())) {
	    int i = 1;
	    this.facade.addToOrder(this.facade.searchProduct(productId), i);
	} else {
	    this.facade.addToOrder(this.facade.searchProduct(productId), Integer.parseInt(this.amountTF.getText()));
	}
    }

    @FXML
    public void showBasket(ActionEvent event) {
	TextArea ta = new TextArea();
	this.mainGrid.add(ta, 0, 0, 2, 4);
	ta.appendText(this.facade.showBasket());
	this.basketBTN.setOnAction(new EventHandler<ActionEvent>() {
	    @Override
	    public void handle(ActionEvent event) {
		closeBasket(event, ta);
	    }
	});

    }

    public void closeBasket(ActionEvent event, TextArea ta) {
	this.mainGrid.getChildren().remove(ta);
	this.basketBTN.setOnAction(new EventHandler<ActionEvent>() {
	    @Override
	    public void handle(ActionEvent event) {
		showBasket(event);
	    }
	});
    }

    @FXML
    public void goBackToProducts(ActionEvent event) {
	AnchorPane pane;
	try {
	    FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("webshopFXML.fxml"));
	    pane = (AnchorPane) fxmlLoader1.load();
	    this.mainPane.getChildren().setAll(pane);
	} catch (IOException ex) {
	    Logger.getLogger(webshopFXMLController.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    public void setProductId(long id) {
	this.productId = id;
	String[] s = facade.searchProduct(productId).toString().split(";");
	String[] description = {"Navn: ", "Pris: ", "Beskrivelse: ", "Kategori: "};
	for (int i = 0; i < s.length - 1; i++) {
	    this.productTA.appendText(description[i] + s[i] + "\n\n");
	}
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elecetroshoppenprojekt;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

/**
 *
 * @author MER
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    private static final ObservableList<String> productsC = FXCollections.observableArrayList();
    private ArrayList<String> list;
    @FXML
    private ChoiceBox<String> productCatatogies;

    public FXMLDocumentController() {
    }
    
    private void handleButtonAction(ActionEvent event) {
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
	productsC.add("1");
	productsC.add("1");
	productsC.add("1");
	productsC.add("1");
	productsC.add("1");
	productCatatogies.setItems(productsC);
	
    }    
    
}
